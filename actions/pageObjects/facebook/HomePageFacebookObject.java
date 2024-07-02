package pageObjects.facebook;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.facebook.HomePageFacebookUI;

public class HomePageFacebookObject extends BasePage {
    private WebDriver driver;
    public HomePageFacebookObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isEmailTextboxDisplayed() {
        waitForElementVisible(HomePageFacebookUI.EMAIL_TEXTBOX);
        return isElementDisplayed(HomePageFacebookUI.EMAIL_TEXTBOX);
    }

    public boolean isFirstNameTextboxDisplayed() {
        waitForElementVisible(HomePageFacebookUI.FIRSTNAME_TEXTBOX);
        return isElementDisplayed(HomePageFacebookUI.FIRSTNAME_TEXTBOX);
    }

    public boolean isLastNameTextboxDisplayed() {
        waitForElementVisible(HomePageFacebookUI.SURNAME_TEXTBOX);
        return isElementDisplayed(HomePageFacebookUI.SURNAME_TEXTBOX);
    }

    public boolean isPasswordTextboxDisplayed() {
        waitForElementVisible(HomePageFacebookUI.PASSWORD_TEXTBOX);
        return isElementDisplayed(HomePageFacebookUI.PASSWORD_TEXTBOX);
    }

    public void clickToCreateNewAccountButton() {
        waitForElementClickable(HomePageFacebookUI.CREATE_NEW_ACCOUNT_BUTTON);
        clickToElement(HomePageFacebookUI.CREATE_NEW_ACCOUNT_BUTTON);
    }

    public void clickToSignUpIcon() {
        waitForElementClickable(HomePageFacebookUI.CLOSE_SIGN_UP_FORM_ICON);
        clickToElement(HomePageFacebookUI.CLOSE_SIGN_UP_FORM_ICON);
        sleepInSeconds(2);
    }

    public boolean isConfirmEmailTextboxDisplayed() {
        waitForElementVisible(HomePageFacebookUI.CONFIRM_EMAIL_TEXTBOX);
        return isElementDisplayed(HomePageFacebookUI.CONFIRM_EMAIL_TEXTBOX);
    }

    public boolean isConfirmEmailTextboxUndisplayed() {
        return isElementUndisplayed(HomePageFacebookUI.CONFIRM_EMAIL_TEXTBOX);
    }

    public boolean isEmailTextboxUndisplayed() {
        return isElementUndisplayed(HomePageFacebookUI.EMAIL_TEXTBOX);
    }

    public boolean isFirstNameTextboxUndisplayed() {
        return isElementUndisplayed(HomePageFacebookUI.FIRSTNAME_TEXTBOX);
    }

    public boolean isLastNameTextboxUndisplayed() {
        return isElementUndisplayed(HomePageFacebookUI.SURNAME_TEXTBOX);
    }

    public boolean isPasswordTextboxUndisplayed() {
        return isElementUndisplayed(HomePageFacebookUI.PASSWORD_TEXTBOX);
    }

    public void enterToEmailTextbox(String email) {
        waitForElementClickable(HomePageFacebookUI.EMAIL_TEXTBOX);
        sendkeyToElement(HomePageFacebookUI.EMAIL_TEXTBOX, email);
        sleepInSeconds(2);
     }
}
