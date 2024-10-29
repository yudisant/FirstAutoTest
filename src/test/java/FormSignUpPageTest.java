import factory.WebDriverFactory;
import factory.WebDriverManagerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.FormSignUpPage;

public class FormSignUpPageTest {

    private WebDriver driver;

    @BeforeAll
    public static void setUp() {
        new WebDriverManagerFactory().setDriverManager();
    }

    @BeforeEach
    public void initDriver() {
        driver = new WebDriverFactory().getDriver();
    }

    @AfterEach
    public void close() {
        if(driver != null) {
            driver.quit();
        }
    }

    @Test
    public void authorization() {
        new FormSignUpPage(driver)
                .open()
                .enterUserName()
                .enterEmail()
                .enterPassword()
                .enterConfirmPassword()
                .checkPassword()
                .enterBirthday()
                .openPopup()
                .signUpClick()
                .checkEnterData();
    }
}
