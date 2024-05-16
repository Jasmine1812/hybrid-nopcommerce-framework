package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;

public class BaseTest {
    protected int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(99999);
    }
    private WebDriver driver;

    protected WebDriver getBrowserDriver(String browserName){
        switch (browserName) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        return driver;
    }
}
