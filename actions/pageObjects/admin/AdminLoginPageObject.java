package pageObjects.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    private WebDriver driver;
    public AdminLoginPageObject(WebDriver driver){
        this.driver = driver;
    }
    protected void enterToEmailTextbox(String email){
        waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, email);
    }

    protected void enterToPasswordTextbox(String password){
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    protected AdminDashboardPageObject clickToLoginButton(){
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getAdminDashboardPage(driver);
    }

    public AdminDashboardPageObject loginToAdmin(String email, String password){
        enterToEmailTextbox(email);
        enterToPasswordTextbox(password);
        return clickToLoginButton();
    }
}
