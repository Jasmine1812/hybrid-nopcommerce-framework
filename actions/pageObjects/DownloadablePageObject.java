package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class DownloadablePageObject extends BasePage {
    private WebDriver driver;

    public DownloadablePageObject(WebDriver driver) {
        this.driver = driver;
    }

}
