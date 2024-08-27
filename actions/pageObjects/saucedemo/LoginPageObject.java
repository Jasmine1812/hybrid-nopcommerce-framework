package pageObjects.saucedemo;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;
import pageUIs.sauce.LoginPageUI;

public class LoginPageObject extends BaseElement {
    private WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToUserNameTextbox(String userName){
        waitForElementVisible(LoginPageUI.USER_NAME);
        sendkeyToElement(LoginPageUI.USER_NAME, userName);
    }

    public void enterToPasswordTextbox(String password){
        waitForElementVisible(LoginPageUI.PASS_WORD);
        sendkeyToElement(LoginPageUI.PASS_WORD, password);
    }
    public ProductsPageObject clickToLoginButton(){
        waitForElementClickable(LoginPageUI.LOGIN_BUTTON);
        clickToElement(LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorSauce.getProductsPage(driver);
    }
    public ProductsPageObject loginToPage(String userName, String password){
        enterToUserNameTextbox(userName);
        enterToPasswordTextbox(password);
        return clickToLoginButton();
    }

}
