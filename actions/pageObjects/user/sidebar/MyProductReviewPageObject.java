package pageObjects.user.sidebar;

import org.openqa.selenium.WebDriver;
import pageObjects.user.SidebarPageObject;

public class MyProductReviewPageObject extends SidebarPageObject {
    private WebDriver driver;

    public MyProductReviewPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
