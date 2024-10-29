package pages;

import data.Locators;
import org.openqa.selenium.WebDriver;

public class FormSignUpPage extends AbsBasePage {

    private final String name = "Sergey";
    private final String email = "sergey195@mail.ru";
    private final String password = "12Qqrt12";
    private final String birthday = "23.12.1990";

    public FormSignUpPage(WebDriver driver) {
        super(driver, "/form.html");
    }

    public FormSignUpPage enterUserName() {
        enterText(Locators.USERNAME, name);
        logger.info("Enter username {}", name);
        return this;
    }

    public FormSignUpPage enterEmail() {
        enterText(Locators.ENTER_EMAIL, email);
        logger.info("Enter email {}", email);
        return this;
    }

    public FormSignUpPage enterPassword() {
        enterText(Locators.PASSWORD, password);
        logger.info("Enter password");
        return this;
    }

    public FormSignUpPage enterConfirmPassword() {
        enterText(Locators.CON_PASSWORD, password);
        logger.info("Enter confirm password");
        return this;
    }

    public FormSignUpPage checkPassword() {
        String pass1 = getElement(Locators.PASSWORD).getAttribute("value");
        String pass2 = getElement(Locators.CON_PASSWORD).getAttribute("value");

        checkData(pass1, pass2);
        logger.info("Comparison of the entered password and the confirmation password");
        return this;
    }

    public FormSignUpPage enterBirthday() {
        enterText(Locators.ENTER_BIRTHDAY, birthday);
        logger.info("Enter birthday {}", birthday);

        return this;
    }

    public FormSignUpPage openPopup() {
        if(isElementReady(Locators.LANGUAGE_LVL)) {
            clickElement(Locators.LANGUAGE_BEGINNER);
        } else {
            clickElement(Locators.LANGUAGE_LVL);
        }
        logger.info("Open a popUp window and select your language proficiency level");
        return this;
    }

    public FormSignUpPage signUpClick() {
        clickElement(Locators.SIGN_UP_BTN);
        logger.info("Pressing the registration");
        return this;
    }

    public void checkEnterData() {
        String data = getElement(Locators.CHECK_ENTER_DATA).getText();
        String enterData = String.format(
                "Имя пользователя: %s\n" +
                "Электронная почта: %s\n" +
                "Дата рождения: %s\n" +
                "Уровень языка: beginner", name, email, reverseDate(birthday));

        checkData(data, enterData);
        logger.info("Comparison entered data");
    }

    private String reverseDate(String date) {
        String[] revDate = date.split("\\.");
        return String.format("%s-%s-%s", revDate[2], revDate[1], revDate[0]);
    }
}
