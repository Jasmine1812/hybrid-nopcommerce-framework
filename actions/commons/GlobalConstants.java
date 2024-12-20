package commons;

import java.io.File;

public class GlobalConstants {
    public static final String DEV_USER_URL = "https://demo.nopcommerce.com";
    public static final String DEV_ADMIN_URL = "https://admin-demo.nopcommerce.com";
    public static final String DEV_ADMIN_USERNAME = "admin@yourstore.com";
    public static final String DEV_ADMIN_PASSWORD = "admin";
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
    public static final String UPLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String DOWNLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "downloadFiles" + File.separator;
    public static final String REPORTNG_IMAGE_PATH = RELATIVE_PROJECT_PATH + File.separator + "reportNGImage" + File.separator;
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String BROWSER_EXTENSION = RELATIVE_PROJECT_PATH + File.separator + "browserExtensions" + File.separator;
    public static final String BROWSER_LOG = RELATIVE_PROJECT_PATH + File.separator + "browserLogs" + File.separator;
    public static final String ENVIRONMENT_CONFIG_PATH = RELATIVE_PROJECT_PATH + File.separator + "environmentConfig" + File.separator;
    public static final String BROWSER_USERNAME = "trngbia_5fOp8R";
    public static final String BROWSER_AUTOMATE_KEY = "qRMRAqkLcz6jwH8p3jVe";
    public static final String BROWSER_STACK_URL = "https://" + BROWSER_USERNAME + ":" + BROWSER_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static final String SAUCE_USERNAME = "oauth-jamesnguyen0102-a3470";
    public static final String SAUCE_AUTOMATE_KEY = "b01f2499-70ba-469e-9875-62932e9b463a";
    public static final String SAUCE_URL = "https://ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    public static final String BITBAR_AUTOMATE_KEY = "CHbYi4A0arCcacd2qgey0ZDti0isAfQn";
    public static final String BITBAR_URL = "https://eu-desktop-hub.bitbar.com/wd/hub";
    public static final Object LAMBDA_USERNAME = "jamesnguyen0103";
    public static final Object LAMBDA_AUTOMATE_KEY = "y2oeBKgYN9uzITB5hWq5ATo5AzYZf8nbAh8x5et299uSNHHjZs";
    public static final String LAMBDA_URL = "https://hub.lambdatest.com/wd/hub";
}
