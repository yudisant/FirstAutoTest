package pages;

import common.AbsCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbsBasePage extends AbsCommon {

    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

    private final String BASE_URL = System.getProperty("base.url");

    public void open(String path) {
        driver.get(BASE_URL + path);
    }

    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void clickElement(WebElement element) {
        element.click();
    }
}
