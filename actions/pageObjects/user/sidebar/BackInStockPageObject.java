package pageObjects.user.sidebar;

import org.openqa.selenium.WebDriver;
import pageObjects.user.SidebarPageObject;

public class BackInStockPageObject extends SidebarPageObject {
    private WebDriver driver;

    public BackInStockPageObject(WebDriver driver) {super(driver);
        this.driver = driver;
    }

}
