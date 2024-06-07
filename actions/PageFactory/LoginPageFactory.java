package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePageFactory {
    private WebDriver driver;

    public LoginPageFactory(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@class='email']")
    private WebElement emailTextbox;

    @FindBy(xpath = "//input[@class='password']")
    private WebElement passwordTextbox;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
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
