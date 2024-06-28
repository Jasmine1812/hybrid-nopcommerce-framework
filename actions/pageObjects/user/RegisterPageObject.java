package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.users.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToGenderMaleRadio() {
        waitForElementClickable(RegisterPageUI.GENDER_MALE_RADIO);
        checkToCheckboxRadio(RegisterPageUI.GENDER_MALE_RADIO);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(RegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void selectDayDropdown(String day) {
        waitForElementClickable(RegisterPageUI.DAY_DROPDOWN);
        selectItemInDropdown(RegisterPageUI.DAY_DROPDOWN, day);
    }

    public void selectMonthDropdown(String month) {
        waitForElementClickable(RegisterPageUI.MONTH_DROPDOWN);
        selectItemInDropdown(RegisterPageUI.MONTH_DROPDOWN, month);
    }

    public void selectYearDropdown(String year) {
        waitForElementClickable(RegisterPageUI.YEAR_DROPDOWN);
        selectItemInDropdown(RegisterPageUI.YEAR_DROPDOWN, year);
    }

    public void enterToMailTextbox(String email) {
        waitForElementVisible(RegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(RegisterPageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToCompanyNameTextbox(String company) {
        waitForElementVisible(RegisterPageUI.COMPANY_NAME_TEXTBOX);
        sendkeyToElement(RegisterPageUI.COMPANY_NAME_TEXTBOX, company);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(RegisterPageUI.REGISTER_BUTTON);
        clickToElement(RegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public HomePageObject clickToLogoutLink() {
        waitForElementClickable(RegisterPageUI.LOGOUT_LINK);
        clickToElement(RegisterPageUI.LOGOUT_LINK);
        return PageGenerator.getHomePage(driver);
    }

    public String getLastNameErrorMessageText() {
        waitForElementVisible(RegisterPageUI.LAST_NAME_ERROR_MESSAGE_TEXT);
        return getElementText(RegisterPageUI.LAST_NAME_ERROR_MESSAGE_TEXT);
    }

    public String getFirstNameErrorMessageText() {
        waitForElementVisible(RegisterPageUI.FIRST_NAME_ERROR_MESSAGE_TEXT);
        return getElementText(RegisterPageUI.FIRST_NAME_ERROR_MESSAGE_TEXT);
    }
}
