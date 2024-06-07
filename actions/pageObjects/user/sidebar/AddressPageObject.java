package pageObjects.user.sidebar;

import org.openqa.selenium.WebDriver;
import pageObjects.user.SidebarPageObject;

public class AddressPageObject extends SidebarPageObject {
    private WebDriver driver;

    public AddressPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
