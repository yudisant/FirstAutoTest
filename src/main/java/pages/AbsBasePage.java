package pages;

import common.AbsCommon;
import data.Locators;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbsBasePage <T> extends AbsCommon {

    private final String path;

    public AbsBasePage(WebDriver driver, String path) {
        super(driver);
        this.path = path;
    }

    private String baseUrl = System.getProperty("base.url");

    public T open() {
        baseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
        driver.get(baseUrl + path);

        return (T) this;
    }

    protected void enterText(Locators locator, String text) {
        driver.findElement(By.id(locator.getLocator())).sendKeys(text);
    }

    protected void clickElement(By element) {
        driver.findElement(element).click();
    }

    protected void checkData(String original, String verifiable) {
        Assertions.assertEquals(original, verifiable);
    }

    protected WebElement getElement(Locators locator) {
        return driver.findElement(By.id(locator.getLocator()));
    }

    protected By meltingLocatorId(Locators locator) {
        return By.id(locator.getLocator());
    }

    protected By meltingLocatorCss(Locators locator) {
        return By.cssSelector(locator.getLocator());
    }
}
