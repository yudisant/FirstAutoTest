package pages;

import common.AbsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbsBasePage <FormSignUpPage> extends AbsCommon {

    private final String path;

    public AbsBasePage(WebDriver driver, String path) {
        super(driver);
        this.path = path;
    }

    private String baseUrl = System.getProperty("base.url");

    public AbsBasePage open() {
        baseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
        driver.get(baseUrl + path);

        return this;
    }

    protected void enterText(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    protected void clickElement(WebElement element) {
        element.click();
    }

    protected <T> getElement(By element) {
        driver.findElement(element);
        return this;
    }
}
