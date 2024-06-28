package pageObjects.user.sidebar;

import org.openqa.selenium.WebDriver;
import pageObjects.user.SidebarPageObject;
import pageUIs.users.CustomerInfoPageUI;

public class CustomerInfoPageObject extends SidebarPageObject {
    private WebDriver driver;

    public CustomerInfoPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isMaleDisplayed() {
        waitForElementSelected(CustomerInfoPageUI.GENDER_MALE_RADIO);
        return isElementDisplayed(CustomerInfoPageUI.GENDER_MALE_RADIO);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(CustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(CustomerInfoPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(CustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
    }

    public String getDayDropdownSelectedValue() {
        waitForElementClickable(CustomerInfoPageUI.DAY_DROPDOWN);
        return getSelectedItemInDropdown(CustomerInfoPageUI.DAY_DROPDOWN);
    }

    public String getMonthDropdownSelectedValue() {
        waitForElementClickable(CustomerInfoPageUI.MONTH_DROPDOWN);
        return getSelectedItemInDropdown(CustomerInfoPageUI.MONTH_DROPDOWN);
    }

    public String getYearDropdownSelectedValue() {
        waitForElementClickable(CustomerInfoPageUI.YEAR_DROPDOWN);
        return getSelectedItemInDropdown(CustomerInfoPageUI.YEAR_DROPDOWN);
    }

    public String getEmailTextboxValue() {
        waitForElementVisible(CustomerInfoPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
    }

    public String getCompanyTextboxValue() {
        waitForElementVisible(CustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
        return getElementAttribute(CustomerInfoPageUI.COMPANY_NAME_TEXTBOX, "value");
    }
}
