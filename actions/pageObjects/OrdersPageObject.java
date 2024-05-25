package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class OrdersPageObject extends BasePage {
    private WebDriver driver;

    public OrdersPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
