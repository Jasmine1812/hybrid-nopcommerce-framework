package commons;

import commons.environmentConfig.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Random;

public class BaseTest {
    protected final Logger log;

    public BaseTest() {
        log = LogManager.getLogger(getClass());
    }

    protected int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(99999);
    }

    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver driver;
    private long longTimeout = GlobalConstants.LONG_TIMEOUT;
    public Platform platform;

    //getBrowserDriverAllEnvironment
    protected WebDriver getBrowserDriverAllEnvironment(String browserName, String serverName, String envName, String osName, String osVersion, String browserVersion, String portNumber) {
        EnvironmentList environmentList = EnvironmentList.valueOf(envName.toUpperCase());
        switch (envName) {
            case "local":
                driver = new LocalFactory(browserName).createDriver(browserName);
                break;
            case "grid":
                driver = new GridFactory(browserName, osName, osVersion, portNumber).createDriver(browserName, osName, osVersion, portNumber);
                break;
            case "browserstack":
                driver = new BrowserStackFactory(osName, osVersion, browserName, browserVersion).createDriver(osName, osVersion, browserName, browserVersion);
                break;
            case "saucelab":
                driver = new SauceLabFactory(osName, browserName, browserVersion).createDriver(osName, browserName, browserVersion);
                break;
            case "bitbar":
                driver = new BitBarFactory(osName, osVersion, browserName, browserVersion).createDriver(osName, osVersion, browserName, browserVersion);
                break;
            default:
                driver = getBrowserEnvironment(browserName, serverName);
        }
        driver.get(getUrlByServerName(serverName));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName, String url) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
        return driver;
    }

    // Selenium Grid
    protected WebDriver getBrowserDriver(String browserName, String osName, String ipAddress, String portNumber) {
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

        driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
        return driver;
    }

    //BrowserStack
    protected WebDriver getBrowserDriverBrowserStack(String url, String osName, String osVersion, String browserName, String browserVersion) {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, Object> bstackOptions = new HashMap<String, Object>();

        capabilities.setCapability("browser", browserName);
        bstackOptions.put("osName", osName);
        bstackOptions.put("osVersion", osVersion);
        bstackOptions.put("browserVersion", browserVersion);
        bstackOptions.put("projectName", "Jasmine Project");
        bstackOptions.put("buildName", "Jasmine Nguyen");
//        bstackOptions.put("userName", "jasminenguyen_2Aabt7");
//        bstackOptions.put("accessKey", "T5TLiAtPUTHWfwh3PSJa");
        bstackOptions.put("consoleLogs", "info");
        capabilities.setCapability("bstack:options", bstackOptions);
        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_STACK_URL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
        return driver;
    }

    //SauceLab
    protected WebDriver getBrowserDriverSaucelab(String url, String osName, String browserName, String browserVersion) {
        MutableCapabilities capability = null;

        switch (browserName) {
            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.setPlatformName(osName);
                fOptions.setBrowserVersion(browserVersion);
                capability = fOptions;
                break;
            case "chrome":
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.setPlatformName(osName);
                cOptions.setBrowserVersion(browserVersion);
                capability = cOptions;
                break;
            case "edge":
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.setPlatformName(osName);
                eOptions.setBrowserVersion(browserVersion);
                capability = eOptions;
                break;
            case "safari":
                SafariOptions sOptions = new SafariOptions();
                sOptions.setPlatformName(osName);
                sOptions.setBrowserVersion(browserVersion);
                capability = sOptions;
                break;
            default:
                throw new RuntimeException("Browser is not valid!");
        }

        HashMap<String, String> sauceOptions = new HashMap<String, String>();
        sauceOptions.put("username", GlobalConstants.SAUCE_USERNAME);
        sauceOptions.put("accessKey", GlobalConstants.SAUCE_AUTOMATE_KEY);
        sauceOptions.put("build", "JasmineProject");
        sauceOptions.put("name", "Run on " + osName + " | " + browserName + " | " + browserVersion);

        capability.setCapability("sauce:options", sauceOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.SAUCE_URL), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    //BitBar
    protected WebDriver getBrowserDriverBitbar(String url, String osName, String osVersion, String browserName, String browserVersion) {
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

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    protected WebDriver getBrowserEnvironment(String browserName, String serverName) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        driver.get(getUrlByServerName(serverName));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
        return driver;
    }

    private String getUrlByServerName(String serverName) {
        ServerList environmentList = ServerList.valueOf(serverName.toUpperCase());
        switch (environmentList) {
            case DEV:
                serverName = "https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/";
                break;
            case TEST:
                serverName = "https://kenh14.vn/";
                break;
            case STAGING:
                serverName = "https://www.facebook.com/";
                break;
            case PROD:
                serverName = "https://www.nopcommerce.com/vi";
                break;
            default:
                new IllegalArgumentException("Unexpected value: " + serverName);
        }
        return serverName;
    }

    protected WebDriver getBrowserDriver(String browserName) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
//                FirefoxOptions ffOptions = new FirefoxOptions();
//                ffOptions.addArguments("-private");
//                driver = new FirefoxDriver(ffOptions);
                driver = new FirefoxDriver();
                break;
            case CHROME:
//                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.addArguments("--user-data-dir=C:/Users/Admin/AppData/Local/Google/Chrome/User Data/");
//                chromeOptions.addArguments("--profile-directory=Profile 11");
//                driver = new ChromeDriver(chromeOptions);
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        driver.get("https://demo.nopcommerce.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
        return driver;
    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
            log.info("---------------------- Passed -----------------------");
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
            log.info("---------------------- Failed -----------------------");
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
            log.info("---------------------- Passed -----------------------");
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
            log.info("---------------------- Failed -----------------------");
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info("---------------------- Passed -----------------------");
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
            log.info("---------------------- Failed -----------------------");
        }
        return pass;
    }

    @BeforeSuite
    public void deleteFileInReport() {
        // Remove all file in ReportNG screenshot (image)
        log.info("-----START delete file in folder----------");
        deleteAllFileInFolder("reportNGImage");
        log.info("-----END delete file in folder----------");

        // Remove all file in Allure attachment (json file)
        deleteAllFileInFolder("allure-json");
    }

    public void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.RELATIVE_PROJECT_PATH + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = GlobalConstants.OS_NAME.toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

