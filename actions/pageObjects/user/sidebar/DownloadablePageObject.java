package pageObjects.user.sidebar;

import org.openqa.selenium.WebDriver;
import pageObjects.user.SidebarPageObject;

public class DownloadablePageObject extends SidebarPageObject {
    private WebDriver driver;

    public DownloadablePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
