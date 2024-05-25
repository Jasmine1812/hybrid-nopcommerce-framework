package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import pageUIs.BasePageUI;

public class PageGenerator {
    public static HomePageObject getHomePageObject(WebDriver driver){
        return new HomePageObject(driver);
    }

    public static LoginPageObject getLoginPageObject(WebDriver driver){
        return new LoginPageObject(driver);
    }
    
    public static CustomerInfoPageObject getCustomerInfoPageObject(WebDriver driver){
        return new CustomerInfoPageObject(driver);
    }
    
    public static RegisterPageObject getRegisterPageObject(WebDriver driver){
        return new RegisterPageObject(driver);
    }

    public static AddressPageObject getAddressPage(WebDriver driver){
        return new AddressPageObject(driver);
    }

    public static OrdersPageObject getOrdersPage(WebDriver driver){
        return new OrdersPageObject(driver);
    }

    public static DownloadablePageObject getDownloadPage(WebDriver driver){
        return new DownloadablePageObject(driver);
    }

    public static BackInStockPageObject getBackInStockPage(WebDriver driver){
        return new BackInStockPageObject(driver);
    }

    public static RewardPointsPageObject getRewardPointsPage(WebDriver driver){
        return new RewardPointsPageObject(driver);
    }

    public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver){
        return new ChangePasswordPageObject(driver);
    }

    public static MyProductReviewPageObject getMyProductReviewPage(WebDriver driver){
        return new MyProductReviewPageObject(driver);
    }

}
