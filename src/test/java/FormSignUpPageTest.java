import factory.WebDriverFactory;
import factory.WebDriverManagerFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.FormSignUpPage;

public class FormSignUpPageTest {

    private static WebDriverManager driverManager;
    private WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driverManager = new WebDriverManagerFactory().setDriverManager();
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
        ((FormSignUpPage) new FormSignUpPage(driver)
                .open())
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
