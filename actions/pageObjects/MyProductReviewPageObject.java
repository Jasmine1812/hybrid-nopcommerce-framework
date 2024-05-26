package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class MyProductReviewPageObject extends BasePage {
    private WebDriver driver;

    public MyProductReviewPageObject(WebDriver driver) {
        this.driver = driver;
    }

}