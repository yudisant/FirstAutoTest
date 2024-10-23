package factory.browserSettings;

import ENUM.Mode;
import imp.IBrowserSetting;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class FirefoxSetting implements IBrowserSetting {

    @Override
    public AbstractDriverOptions setting(String mode) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(mode);
        return firefoxOptions;
    }
}
