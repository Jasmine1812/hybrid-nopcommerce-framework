package commons.environmentConfig;

import commons.GlobalConstants;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserStackFactory {
    private WebDriver driver;
    private String osName;
    private String osVersion;
    private String browserName;
    private String browserVersion;

    public BrowserStackFactory(String osName, String osVersion, String browserName, String browserVersion) {
        this.osName = osName;
        this.osVersion = osVersion;
        this.browserName = browserName;
        this.browserVersion = browserVersion;
    }
    public WebDriver createDriver(String osName, String osVersion, String browserName, String browserVersion) {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, Object> bstackOptions = new HashMap<String, Object>();

        capabilities.setCapability("browser", browserName);
        bstackOptions.put("osName", osName);
        bstackOptions.put("osVersion", osVersion);
        bstackOptions.put("browserVersion", browserVersion);
        bstackOptions.put("projectName", "Jasmine Project");
        bstackOptions.put("buildName", "Jasmine Nguyen");
        bstackOptions.put("consoleLogs", "info");
        capabilities.setCapability("bstack:options", bstackOptions);
        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_STACK_URL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
