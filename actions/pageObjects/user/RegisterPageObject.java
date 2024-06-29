package pageObjects.user;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.users.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click to Gender Male Radio")
    public void clickToGenderMaleRadio() {
        waitForElementClickable(RegisterPageUI.GENDER_MALE_RADIO);
        checkToCheckboxRadio(RegisterPageUI.GENDER_MALE_RADIO);
    }

    @Step("Enter to First Name textbox with value is {0}")
    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    @Step("Enter to Last Name textbox value is {0}")
    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(RegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    @Step("Select to Day dropdown value is {0}")
    public void selectDayDropdown(String day) {
        waitForElementClickable(RegisterPageUI.DAY_DROPDOWN);
        selectItemInDropdown(RegisterPageUI.DAY_DROPDOWN, day);
    }

    @Step("Select to Month dropdown value is {0}")
    public void selectMonthDropdown(String month) {
        waitForElementClickable(RegisterPageUI.MONTH_DROPDOWN);
        selectItemInDropdown(RegisterPageUI.MONTH_DROPDOWN, month);
    }

    @Step("Select to Year dropdown value is {0}")
    public void selectYearDropdown(String year) {
        waitForElementClickable(RegisterPageUI.YEAR_DROPDOWN);
        selectItemInDropdown(RegisterPageUI.YEAR_DROPDOWN, year);
    }

    @Step("Enter to Mail textbox value is {0}")
    public void enterToMailTextbox(String email) {
        waitForElementVisible(RegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(RegisterPageUI.EMAIL_TEXTBOX, email);
    }

    @Step("Enter to Company Name textbox value is {0}")
    public void enterToCompanyNameTextbox(String company) {
        waitForElementVisible(RegisterPageUI.COMPANY_NAME_TEXTBOX);
        sendkeyToElement(RegisterPageUI.COMPANY_NAME_TEXTBOX, company);
    }

    @Step("Enter to Password textbox value is {0}")
    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Enter to Confirm Password textbox value is {0}")
    public void enterToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    @Step("Click to Register Button")
    public void clickToRegisterButton() {
        waitForElementClickable(RegisterPageUI.REGISTER_BUTTON);
        clickToElement(RegisterPageUI.REGISTER_BUTTON);
    }
    @Step("Verify the resgister success message is displayed")
    public String getRegisterSuccessMessage() {
        waitForElementVisible(RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }
    @Step("Click to Logout Link")
    public HomePageObject clickToLogoutLink() {
        waitForElementClickable(RegisterPageUI.LOGOUT_LINK);
        clickToElement(RegisterPageUI.LOGOUT_LINK);
        return PageGenerator.getHomePage(driver);
    }
    @Step("Verify the last name error message text is displayed")
    public String getLastNameErrorMessageText() {
        waitForElementVisible(RegisterPageUI.LAST_NAME_ERROR_MESSAGE_TEXT);
        return getElementText(RegisterPageUI.LAST_NAME_ERROR_MESSAGE_TEXT);
    }

    @Step("Verify the first name error message text is displayed")
    public String getFirstNameErrorMessageText() {
        waitForElementVisible(RegisterPageUI.FIRST_NAME_ERROR_MESSAGE_TEXT);
        return getElementText(RegisterPageUI.FIRST_NAME_ERROR_MESSAGE_TEXT);
    }
}
