package pageObjects.user.sidebar;

import org.openqa.selenium.WebDriver;
import pageObjects.user.SidebarPageObject;

public class ChangePasswordPageObject extends SidebarPageObject {
    private WebDriver driver;

    public ChangePasswordPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
