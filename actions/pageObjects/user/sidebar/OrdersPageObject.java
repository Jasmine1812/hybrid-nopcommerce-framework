package pageObjects.user.sidebar;

import org.openqa.selenium.WebDriver;
import pageObjects.user.SidebarPageObject;

public class OrdersPageObject extends SidebarPageObject {
    private WebDriver driver;

    public OrdersPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
