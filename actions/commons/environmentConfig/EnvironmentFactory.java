package commons.environmentConfig;

import org.openqa.selenium.WebDriver;

public interface EnvironmentFactory {
    public WebDriver createDriver();

    WebDriver createDriver(String osName, String osVersion, String browserName, String browserVersion);
}
