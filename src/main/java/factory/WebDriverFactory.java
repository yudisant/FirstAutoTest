package factory;

import ENUM.BrowserType;
import ENUM.Mode;
import exeptions.BrowserNotFoundExceptions;
import factory.browserSettings.ChromeSetting;
import factory.browserSettings.EdgeSetting;
import factory.browserSettings.FirefoxSetting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    private final String browser = System.getProperty("browser");

    public WebDriver getDriver() {

        BrowserType browserType = BrowserType.valueOf(browser.toUpperCase());

        WebDriver driver;

        if(browserType == BrowserType.CHROME) {
            driver = new ChromeDriver();
        } else if(browserType == BrowserType.FIREFOX) {
            driver = new FirefoxDriver();
        } else if(browserType == BrowserType.EDGE) {
            driver = new EdgeDriver();
        } else {
            throw new BrowserNotFoundExceptions(browser);
        }
        return driver;
    }

    public WebDriver getDriver(Mode mode) {

        BrowserType browserType = BrowserType.valueOf(browser.toUpperCase());

        WebDriver driver;

        if(browserType == BrowserType.CHROME) {
            driver = new ChromeDriver((ChromeOptions) new ChromeSetting().setting(mode.getArgument()));
        } else if(browserType == BrowserType.FIREFOX) {
            driver = new FirefoxDriver((FirefoxOptions) new FirefoxSetting().setting(mode.getArgument()));
        } else if(browserType == BrowserType.EDGE) {
            driver = new EdgeDriver((EdgeOptions) new EdgeSetting().setting(mode.getArgument()));
        } else {
            throw new BrowserNotFoundExceptions(browser);
        }
        return driver;
    }
}
