package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.KeyStore;

public class FormSignUpPage extends AbsBasePage {

    private final String name = "Sergey";
    KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
    private final String email = "sergey195@mail.ru";
    private final String passw = "12Qqrt12";
    private final String birthday = "23.12.1990";

    public FormSignUpPage(WebDriver driver) {
        super(driver, "/form.html");
    }

    private final By username = (By.id("username"));
    private final By enterEmail = By.id("email");
    private final By password = By.id("password");
    private final By conPassword = By.id("confirm_password");
    private final By enterBirthday = By.id("birthday");
    private final By languageLvl = By.id("language_level");
    private final By signUpBtn = By.cssSelector("[type='submit']");
    private final By languageBeginner = By.cssSelector("[value='beginner'");
    private final By checkEnterData = By.id("output");

    public FormSignUpPage enterUserName() {
        enterText(username, name);
        logger.info("Enter username {}", username);
        return this;
    }

    public FormSignUpPage enterEmail() {
        enterText(enterEmail, email);
        logger.info("Enter email {}", email);
        return this;
    }

    public FormSignUpPage enterPassword() {
        enterText(password, passw);
        logger.info("Enter password");
        return this;
    }

    public FormSignUpPage enterConfirmPassword() {
        enterText(conPassword, passw);
        logger.info("Enter confirm password");
        return this;
    }

    public FormSignUpPage checkPassword() {
        String pass1 = password.getAttribute("value");
        String pass2 = conPassword.getAttribute("value");
        Assertions.assertEquals(pass1, pass2);
        logger.info("Comparison of the entered password and the confirmation password");
        return this;
    }

    public FormSignUpPage enterBirthday() {
        enterText(enterBirthday, birthday);
        logger.info("Enter birthday {}", birthday);

        return this;
    }

    public FormSignUpPage openPopup() {
        if(isElementReady(languageLvl)) {
            clickElement(languageBeginner);
        } else {
            clickElement(languageLvl);
        }
        logger.info("Open a popUp window and select your language proficiency level");
        return this;
    }

    public FormSignUpPage signUpClick() {
        clickElement(signUpBtn);
        logger.info("Pressing the registration");
        return this;
    }

    public void checkEnterData() {
        String data = checkEnterData.getText();
        String enterData = String.format(
                "Имя пользователя: %s\n" +
                "Электронная почта: %s\n" +
                "Дата рождения: %s\n" +
                "Уровень языка: beginner", name, email, reverseDate(birthday));

        Assertions.assertEquals(data, enterData);
        logger.info("Comparison entered data");
    }

    private boolean isElementReady(WebElement element) {
        try {
            return element.isDisplayed() && element.isEnabled();
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }

    private String reverseDate(String date) {
        String[] revDate = date.split("\\.");
        return String.format("%s-%s-%s", revDate[2], revDate[1], revDate[0]);
    }
}
