package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class BackInStockPageObject extends BasePage {
    private WebDriver driver;

    public BackInStockPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
