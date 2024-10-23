package factory.browserSettings;

import ENUM.Mode;
import imp.IBrowserSetting;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class ChromeSetting implements IBrowserSetting {

    @Override
    public AbstractDriverOptions setting(String mode) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(mode);
        return chromeOptions;
    }
}
