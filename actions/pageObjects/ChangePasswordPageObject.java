package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class ChangePasswordPageObject extends BasePage {
    private WebDriver driver;

    public ChangePasswordPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
