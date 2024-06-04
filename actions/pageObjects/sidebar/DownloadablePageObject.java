package pageObjects.sidebar;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.SidebarPageObject;
import pageUIs.HomePageUI;

public class DownloadablePageObject extends SidebarPageObject {
    private WebDriver driver;

    public DownloadablePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
