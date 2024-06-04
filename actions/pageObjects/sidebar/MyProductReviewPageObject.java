package pageObjects.sidebar;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.SidebarPageObject;
import pageUIs.LoginPageUI;

public class MyProductReviewPageObject extends SidebarPageObject {
    private WebDriver driver;

    public MyProductReviewPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
