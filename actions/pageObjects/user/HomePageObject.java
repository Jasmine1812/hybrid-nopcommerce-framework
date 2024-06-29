package pageObjects.user;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.user.sidebar.CustomerInfoPageObject;
import pageUIs.users.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click to Register Link")
    public RegisterPageObject clickRegisterLink() {
        waitForElementClickable(HomePageUI.REGISTER_LINK);
        clickToElement(HomePageUI.REGISTER_LINK);
        return PageGenerator.getRegisterPage(driver);
    }
    @Step("Click to Login Link")
    public UserLoginPageObject clickToLoginLink() {
        waitForElementClickable(HomePageUI.LOGIN_LINK);
        clickToElement(HomePageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(HomePageUI.MY_ACCOUNT_LINK);
    }
    @Step("Click to My Account Link")
    public CustomerInfoPageObject clickToMyAccountLink() {
        waitForElementClickable(HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(HomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getCustomerInfoPageObject(driver);
    }

    @Step("Verify the register link is displayed")
    public boolean isRegisterLinkDisplayed() {
        waitForElementVisible(HomePageUI.REGISTER_LINK);
        return isElementDisplayed(HomePageUI.REGISTER_LINK);
    }
}
