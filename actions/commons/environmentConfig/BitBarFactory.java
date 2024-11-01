package commons.environmentConfig;

import commons.GlobalConstants;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BitBarFactory  {
    private WebDriver driver;
    private String osName;
    private String osVersion;
    private String browserName;
    private String browserVersion;

    public BitBarFactory(String osName,String osVersion, String browserName, String browserVersion) {
        this.osName = osName;
        this.osVersion = osVersion;
        this.browserName = browserName;
        this.browserVersion = browserVersion;
    }

    public WebDriver createDriver(String osName, String osVersion, String browserName, String browserVersion) {
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("platformName", osName);
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", browserVersion);

        HashMap<String, String> bitbarOptions = new HashMap<String, String>();
        bitbarOptions.put("project", "NopCommerce");
        bitbarOptions.put("testrun", "Run on " + osName + " | " + osVersion + " | " + browserName + " | " + browserVersion);
        bitbarOptions.put("apiKey", GlobalConstants.BITBAR_AUTOMATE_KEY);
        bitbarOptions.put("osVersion", osVersion);

        if (osName.contains("Windows") || osName.contains("Linux")) {
            bitbarOptions.put("resolution", "1920x1080");
        } else {
            bitbarOptions.put("resolution", "1920x1200");
        }

        bitbarOptions.put("seleniumVersion", "4");

        capabilities.setCapability("bitbar:options", bitbarOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.BITBAR_URL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

}
