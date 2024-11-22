package factory;

import data.Mode;
import exeptions.BrowserNotFoundExceptions;
import factory.browserSettings.ChromeSetting;
import factory.browserSettings.EdgeSetting;
import factory.browserSettings.FirefoxSetting;
import factory.browserSettings.Remotedriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    private final String browser = System.getProperty("browser");

    public WebDriver getDriver() {
        WebDriver driver;

        if(browser.toLowerCase().equals("chrome")) {
            driver = new ChromeDriver();
        } else if(browser.toLowerCase().equals("firefox")) {
            driver = new FirefoxDriver();
        } else if(browser.toLowerCase().equals("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new BrowserNotFoundExceptions(browser);
        }
        return driver;
    }

    public WebDriver getDriver(Mode mode) throws MalformedURLException {
        WebDriver driver;

        if(browser.toLowerCase().equals("chrome")) {
            driver = new ChromeDriver((ChromeOptions) new ChromeSetting().setting(mode.getArgument()));
        } else if(browser.toLowerCase().equals("firefox")) {
            driver = new FirefoxDriver((FirefoxOptions) new FirefoxSetting().setting(mode.getArgument()));
        } else if(browser.toLowerCase().equals("edge")) {
            driver = new EdgeDriver((EdgeOptions) new EdgeSetting().setting(mode.getArgument()));
        } else {
            throw new BrowserNotFoundExceptions(browser);
        }
        return driver;
    }
}
