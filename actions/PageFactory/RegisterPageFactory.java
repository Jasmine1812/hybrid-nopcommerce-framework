package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageFactory extends BasePageFactory {
    private WebDriver driver;

    public RegisterPageFactory(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "gender-male")
    private WebElement genderMaleRadio;
    @CacheLookup
    @FindBy(id = "FirstName")
    private WebElement firstNameTextbox;

    @CacheLookup
    @FindBy(id = "LastName")
    private WebElement lastNameTextbox;

    @CacheLookup
    @FindBy(name = "DateOfBirthDay")
    private WebElement dayDropdown;

    @CacheLookup
    @FindBy(name = "DateOfBirthMonth")
    private WebElement monthDropdown;

    @FindBy(how = How.NAME, using = "DateOfBirthYear")
    private WebElement yearDropdown;

    @FindBy(how = How.ID, using = "Email")
    private WebElement emailTextbox;

    @FindBy(how = How.ID, using = "Company")
    private WebElement companyTextbox;

    @FindBy(how = How.ID, using = "Password")
    private WebElement passwordTextbox;

    @FindBy(how = How.ID, using = "ConfirmPassword")
    private WebElement confirmPasswordTextbox;

    @FindBy(how = How.ID, using = "register-button")
    private WebElement registerButton;

    @FindBy(className = "ico-logout")
    private WebElement logoutLink;

    @FindBy(className = "result")
    private WebElement registerSuccessMessage;


    public void clickToGenderMaleRadio() {
        waitForElementClickable(driver, genderMaleRadio);
        checkToCheckboxRadio(driver, genderMaleRadio);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, firstNameTextbox);
        sendkeyToElement(driver, firstNameTextbox, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, lastNameTextbox);
        sendkeyToElement(driver, lastNameTextbox, lastName);
    }

    public void selectDayDropdown(String day) {
        waitForElementClickable(driver, dayDropdown);
        selectItemInDropdown(driver, dayDropdown, day);
    }

    public void selectMonthDropdown(String month) {
        waitForElementClickable(driver, monthDropdown);
        selectItemInDropdown(driver, monthDropdown, month);
    }

    public void selectYearDropdown(String year) {
        waitForElementClickable(driver, yearDropdown);
        selectItemInDropdown(driver, yearDropdown, year);
    }

    public void enterToMailTextbox(String email) {
        waitForElementVisible(driver, emailTextbox);
        sendkeyToElement(driver, emailTextbox, email);
    }

    public void enterToCompanyNameTextbox(String company) {
        waitForElementVisible(driver, companyTextbox);
        sendkeyToElement(driver, companyTextbox, company);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, passwordTextbox);
        sendkeyToElement(driver, passwordTextbox, password);
    }

    public void enterToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver, confirmPasswordTextbox);
        sendkeyToElement(driver, confirmPasswordTextbox, confirmPassword);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, registerButton);
        clickToElement(driver, registerButton);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, registerSuccessMessage);
        return getElementText(driver, registerSuccessMessage);
    }

    public void clickToLogoutLink() {
        waitForElementClickable(driver, logoutLink);
        clickToElement(driver, logoutLink);
    }
}
