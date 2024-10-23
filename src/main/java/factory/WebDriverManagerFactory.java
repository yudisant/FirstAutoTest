package factory;

import ENUM.BrowserType;
import exeptions.BrowserNotFoundExceptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerFactory { ;

    private WebDriverManager driverManager;

    private final String BROWSER = System.getProperty("browser");

    public WebDriverManager setDriverManager() {

        BrowserType browserType = BrowserType.valueOf(BROWSER.toUpperCase());
        if(browserType == BrowserType.CHROME) {
            WebDriverManager.chromedriver().setup();
        } else if(browserType == BrowserType.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
        } else if(browserType == BrowserType.EDGE) {
            WebDriverManager.edgedriver().setup();
        } else {
            throw new BrowserNotFoundExceptions(BROWSER);
        }
        return driverManager;
    }
}
