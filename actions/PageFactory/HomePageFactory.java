package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory extends BasePageFactory {
    private WebDriver driver;

    public HomePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CLASS_NAME, using = "ico-register")
    private WebElement registerLink;

    @FindBy(how = How.CLASS_NAME, using = "ico-login")
    private WebElement loginLink;

    @FindBy(how = How.CLASS_NAME, using = "ico-account")
    private WebElement myAccountLink;



    public void clickRegisterLink() {
        waitForElementClickable(driver,registerLink);
        clickToElement(driver, registerLink);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver,loginLink);
        clickToElement(driver,loginLink);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver,myAccountLink);
        return isElementDisplayed(driver,myAccountLink);
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver,myAccountLink);
        clickToElement(driver,myAccountLink);
    }
}
