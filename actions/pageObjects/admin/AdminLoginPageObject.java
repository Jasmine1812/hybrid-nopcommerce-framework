package pageObjects.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    private WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {

        super(driver);
        this.driver = driver;
    }

    protected void enterToEmailTextbox(String email) {
        waitForElementVisible(AdminLoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(AdminLoginPageUI.EMAIL_TEXTBOX, email);
    }

    protected void enterToPasswordTextbox(String password) {
        waitForElementVisible(AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(AdminLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    protected AdminDashboardPageObject clickToLoginButton() {
        waitForElementClickable(AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(AdminLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getAdminDashboardPage(driver);
    }

    public AdminDashboardPageObject loginToAdmin(String email, String password) {
        enterToEmailTextbox(email);
        enterToPasswordTextbox(password);
        return clickToLoginButton();
    }
}
