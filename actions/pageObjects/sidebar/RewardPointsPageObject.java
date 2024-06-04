package pageObjects.sidebar;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.SidebarPageObject;
import pageUIs.HomePageUI;

public class RewardPointsPageObject extends SidebarPageObject {
    private WebDriver driver;

    public RewardPointsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
