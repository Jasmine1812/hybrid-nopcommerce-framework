package commons.environmentConfig;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GridFactory {
    private WebDriver driver;
    private String serverName;
    private String browserName;
    private String osName;
    private String ipAddress;
    private String portNumber;
    public Platform platform;

    public GridFactory(String browserName, String osName, String ipAddress, String portNumber) {
        this.browserName = browserName;
        this.osName = osName;
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
    }



    public WebDriver createDriver(String browserName, String osName, String ipAddress, String portNumber) {
        Capabilities capabilities = null;
        if (osName.toLowerCase().contains("windows")) {
            platform = Platform.WINDOWS;
        } else {
            platform = Platform.MAC;
        }
        switch (browserName) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capabilities = firefoxOptions;
                break;
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capabilities = chromeOptions;
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capabilities = edgeOptions;
                break;
            case "safari":
                SafariOptions sOptions = new SafariOptions();
                sOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capabilities = sOptions;
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        try {
            driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/", ipAddress, portNumber)), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }
}
