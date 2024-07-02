package pageObjects.user;

import commons.BaseElement;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.users.UserLoginPageUI;

public class UserLoginPageObject extends BaseElement {
    private WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(UserLoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(UserLoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(UserLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(UserLoginPageUI.PASSWORD_TEXTBOX, password);

    }

    public HomePageObject clickToLoginButton() {
        waitForElementClickable( UserLoginPageUI.LOGIN_BUTTON);
        clickToElement( UserLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getHomePage(driver);
    }

    public HomePageObject loginToUserPage(String email, String password){
        enterToEmailTextbox(email);
        enterToPasswordTextbox(password);
        return clickToLoginButton();
    }
}
