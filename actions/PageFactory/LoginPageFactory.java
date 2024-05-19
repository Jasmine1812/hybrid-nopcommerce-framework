package PageFactory;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageUIs.LoginPageUI;

public class LoginPageFactory extends BasePageFactory {
    private WebDriver driver;

    public LoginPageFactory(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@class='email']")
    private WebElement emailTextbox;

    @FindBy(how = How.XPATH, using = "//input[@class='password']")
    private WebElement passwordTextbox;

    @FindBy(how = How.XPATH, using = "//button[@class='button-1 login-button']")
    private WebElement loginButton;

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, emailTextbox);
        sendkeyToElement(driver, emailTextbox, email);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver,passwordTextbox);
        sendkeyToElement(driver, passwordTextbox, password);

    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, loginButton);
        clickToElement(driver,loginButton);
    }
}
