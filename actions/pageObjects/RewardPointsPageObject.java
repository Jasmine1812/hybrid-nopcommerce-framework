package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class RewardPointsPageObject extends BasePage {
    private WebDriver driver;

    public RewardPointsPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
