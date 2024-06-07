package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.sidebar.*;

public class PageGenerator {
    public static HomePageObject getHomePageObject(WebDriver driver){
        return new HomePageObject(driver);
    }

    public static UserLoginPageObject getUserLoginPage(WebDriver driver){
        return new UserLoginPageObject(driver);
    }
    
    public static CustomerInfoPageObject getCustomerInfoPageObject(WebDriver driver){
        return new CustomerInfoPageObject(driver);
    }
    
    public static RegisterPageObject getRegisterPage(WebDriver driver){
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

    public static AdminLoginPageObject getAdminLoginPage(WebDriver driver){
        return new AdminLoginPageObject(driver);
    }

    public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver){
        return new AdminDashboardPageObject(driver);
    }

}
