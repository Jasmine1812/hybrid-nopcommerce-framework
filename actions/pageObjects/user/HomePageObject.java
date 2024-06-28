package pageObjects.user;

import commons.BasePage;
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

    public RegisterPageObject clickRegisterLink() {
        waitForElementClickable(HomePageUI.REGISTER_LINK);
        clickToElement(HomePageUI.REGISTER_LINK);
        return PageGenerator.getRegisterPage(driver);
    }

    public UserLoginPageObject clickToLoginLink() {
        waitForElementClickable(HomePageUI.LOGIN_LINK);
        clickToElement(HomePageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(HomePageUI.MY_ACCOUNT_LINK);
    }

    public CustomerInfoPageObject clickToMyAccountLink() {
        waitForElementClickable(HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(HomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getCustomerInfoPageObject(driver);
    }

    public boolean isRegisterLinkDisplayed() {
        waitForElementVisible(HomePageUI.REGISTER_LINK);
        return isElementDisplayed(HomePageUI.REGISTER_LINK);
    }
}
