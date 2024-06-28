package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.HomePageJQueryUI;

import java.util.ArrayList;
import java.util.List;

public class HomePageJQueryObject extends BasePage {
    private WebDriver driver;

    public HomePageJQueryObject(WebDriver driver) {

        super(driver);
        this.driver = driver;
    }

    public void inputToSearchTextboxByName(String columnName, String valueToSend) {
        waitForElementVisible(HomePageJQueryUI.SEARCH_TEXTBOX_BY_NAME, columnName);
        sendkeyToElement(HomePageJQueryUI.SEARCH_TEXTBOX_BY_NAME, valueToSend, columnName);
    }

    public void clickToPagingByNumber(String pageNumber) {
        waitForElementClickable(HomePageJQueryUI.PAGE_LINK_BY_NUMBER, pageNumber);
        clickToElement(HomePageJQueryUI.PAGE_LINK_BY_NUMBER, pageNumber);
    }

    public boolean isPageActiveByNumber(String pageNumber) {
        return isElementDisplayed(HomePageJQueryUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
    }

    public boolean isCellValuesDisplayed(String female, String country, String male, String total) {
        return isElementDisplayed(HomePageJQueryUI.DYNAMIC_CELL_VALUE, female, country, male, total);
    }

    public void clickToRowActionByCountryName(String country, String action) {
        waitForElementClickable(HomePageJQueryUI.ROW_ACTION_BY_COUNTRY_NAME, country, action);
        clickToElement( HomePageJQueryUI.ROW_ACTION_BY_COUNTRY_NAME, country, action);
    }

    public void getAllPageValuesByColumnName(String country) {
        List<String> allValues = new ArrayList<String>();

        //Get tất cả các trang
        List<WebElement> allPageLinks = getListElement(HomePageJQueryUI.ALL_PAGE_LINKS);

        int columnIndex = getListElementSize(HomePageJQueryUI.COLUMN_INDEX_BY_COLUMN_NAME, country) + 1;
        //Duyệt qua từng page
        for (WebElement link : allPageLinks) {
            link.click();

            //Lấy tất cả các giá trị trong 1 column của page đó
            List<WebElement> allRowValues = getListElement( HomePageJQueryUI.ALL_VALUE_BY_COLUMN_INDEX, String.valueOf(columnIndex));

            for (WebElement rowValue : allRowValues) {
                allValues.add(rowValue.getText());
                System.out.println(rowValue.getText());
            }

        }
    }
    public void inputToTextBoxByColumnNameAndRowIndex( String columnName, String rowIndex, String valueToSend){
        int indexColumn = getListElementSize(HomePageJQueryUI.COLUMN_INDEX_JQUERY_BY_COLUMN_NAME, columnName) + 1;
        waitForElementVisible(HomePageJQueryUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(indexColumn));
        sendkeyToElement(HomePageJQueryUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, valueToSend, rowIndex, String.valueOf(indexColumn));
    }

    public void selectToDropdownByColumnNameAndRowIndex( String columnName, String rowIndex, String selectItem){
        int indexColumn = getListElementSize(HomePageJQueryUI.COLUMN_INDEX_JQUERY_BY_COLUMN_NAME, columnName) + 1;
        waitForElementVisible(HomePageJQueryUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(indexColumn));
        selectItemInDropdown(HomePageJQueryUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, selectItem, rowIndex, String.valueOf(indexColumn));
    }
}
