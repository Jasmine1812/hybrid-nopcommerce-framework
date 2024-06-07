package pageObjects.user.sidebar;

import org.openqa.selenium.WebDriver;
import pageObjects.user.SidebarPageObject;

public class RewardPointsPageObject extends SidebarPageObject {
    private WebDriver driver;

    public RewardPointsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
