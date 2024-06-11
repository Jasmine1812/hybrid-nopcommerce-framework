package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.jquery.HomePageJQueryUI;

public class HomePageJQueryObject extends BasePage {
    private WebDriver driver;

    public HomePageJQueryObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToSearchTextboxByName(String columnName, String valueToSend){
        waitForElementVisible(driver, HomePageJQueryUI.SEARCH_TEXTBOX_BY_NAME, columnName);
        sendkeyToElement(driver, HomePageJQueryUI.SEARCH_TEXTBOX_BY_NAME, valueToSend, columnName);
    }
    public void clickToPagingByNumber(String pageNumber){
        waitForElementClickable(driver, HomePageJQueryUI.PAGE_LINK_BY_NUMBER, pageNumber);
        clickToElement(driver, HomePageJQueryUI.PAGE_LINK_BY_NUMBER, pageNumber);
    }

    public boolean isPageActiveByNumber(String pageNumber){
        return isElementDisplayed(driver, HomePageJQueryUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
    }

    public boolean isCellValuesDisplayed(String female, String country, String male, String total){
        return isElementDisplayed(driver, HomePageJQueryUI.DYNAMIC_CELL_VALUE, female, country, male, total);
    }

    public void clickToRowActionByCountryName(String country, String action){
        waitForElementClickable(driver, HomePageJQueryUI.ROW_ACTION_BY_COUNTRY_NAME, country, action);
        clickToElement(driver, HomePageJQueryUI.ROW_ACTION_BY_COUNTRY_NAME, country, action);
    }
}
