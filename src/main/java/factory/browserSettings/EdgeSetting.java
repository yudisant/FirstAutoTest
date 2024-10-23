package factory.browserSettings;

import ENUM.Mode;
import imp.IBrowserSetting;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class EdgeSetting implements IBrowserSetting {

    @Override
    public AbstractDriverOptions setting(String mode) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments(mode);
        return edgeOptions;
    }
}
