package pageObjects.sidebar;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.SidebarPageObject;
import pageUIs.HomePageUI;
import pageUIs.SidebarPageUI;

public class BackInStockPageObject extends SidebarPageObject {
    private WebDriver driver;

    public BackInStockPageObject(WebDriver driver) {super(driver);
        this.driver = driver;
    }

}
