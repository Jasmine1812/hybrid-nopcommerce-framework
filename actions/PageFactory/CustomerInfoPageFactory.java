package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class CustomerInfoPageFactory extends BasePageFactory {
    private WebDriver driver;

    public CustomerInfoPageFactory(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@id='gender-male']")
    private WebElement genderMaleRadio;

    @FindBys({
            @FindBy(how = How.ID, using = "FirstName"),
            @FindBy(how = How.XPATH, using = "//input[@id='FirstName']")
    })
    private WebElement firstNameTextbox;

    @FindAll({
            @FindBy(how = How.ID, using = "LastName"),
            @FindBy(how = How.XPATH, using = "//input[@id='LastName']")
    })
    private WebElement lastNameTextbox;


    @FindBy(how = How.XPATH, using = "//select[@name='DateOfBirthDay']")
    private WebElement dayDropdown;

    @FindBy(how = How.NAME, using = "DateOfBirthMonth")
    private WebElement monthDropdown;

    @FindBy(how = How.NAME, using = "DateOfBirthYear")
    private WebElement yearDropdown;

    @FindBy(how = How.ID, using = "Email")
    private WebElement emailTextbox;

    @FindBy(how = How.ID, using = "Company")
    private WebElement companyTextbox;

    public boolean isMaleDisplayed() {
        waitForElementSelected(driver, genderMaleRadio);
        return isElementDisplayed(driver, genderMaleRadio);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, firstNameTextbox);
        return getElementAttribute(driver, firstNameTextbox, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, lastNameTextbox);
        return getElementAttribute(driver, lastNameTextbox, "value");
    }

    public String getDayDropdownSelectedValue() {
        waitForElementClickable(driver, dayDropdown);
        return getSelectedItemInDropdown(driver, dayDropdown);
    }

    public String getMonthDropdownSelectedValue() {
        waitForElementClickable(driver, monthDropdown);
        return getSelectedItemInDropdown(driver, monthDropdown);
    }

    public String getYearDropdownSelectedValue() {
        waitForElementClickable(driver, yearDropdown);
        return getSelectedItemInDropdown(driver, yearDropdown);
    }

    public String getEmailTextboxValue() {
        waitForElementVisible(driver, emailTextbox);
        return getElementAttribute(driver, emailTextbox, "value");
    }

    public String getCompanyTextboxValue() {
        waitForElementVisible(driver, companyTextbox);
        return getElementAttribute(driver, companyTextbox, "value");
    }
}
