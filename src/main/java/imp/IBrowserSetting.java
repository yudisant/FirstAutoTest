package imp;

import ENUM.Mode;
import org.openqa.selenium.remote.AbstractDriverOptions;

public interface IBrowserSetting {

    AbstractDriverOptions setting(String mode);
}
