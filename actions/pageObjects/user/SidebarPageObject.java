package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.user.sidebar.*;
import pageUIs.users.SidebarPageUI;

public class SidebarPageObject extends BasePage {
    private WebDriver driver;

    public SidebarPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public AddressPageObject openAddressPage() {
        waitForElementVisible(SidebarPageUI.ADDRESSES_LINK);
        clickToElement(SidebarPageUI.ADDRESSES_LINK);
        return PageGenerator.getAddressPage(driver);
    }

    public OrdersPageObject openOrdersPage() {
        waitForElementVisible(SidebarPageUI.ORDERS_LINK);
        clickToElement(SidebarPageUI.ORDERS_LINK);
        return PageGenerator.getOrdersPage(driver);
    }

    public DownloadablePageObject openDownloadPage() {
        waitForElementVisible(SidebarPageUI.DOWNLOADABLE_PRODUCTS_LINK);
        clickToElement(SidebarPageUI.DOWNLOADABLE_PRODUCTS_LINK);
        return PageGenerator.getDownloadPage(driver);
    }

    public BackInStockPageObject openBackInStockPage() {
        waitForElementVisible(SidebarPageUI.BACK_IN_STOCK_LINK);
        clickToElement(SidebarPageUI.BACK_IN_STOCK_LINK);
        return PageGenerator.getBackInStockPage(driver);
    }

    public RewardPointsPageObject openRewardPointsPage() {
        waitForElementVisible(SidebarPageUI.REWARD_POINTS_LINK);
        clickToElement(SidebarPageUI.REWARD_POINTS_LINK);
        return PageGenerator.getRewardPointsPage(driver);
    }

    public ChangePasswordPageObject openChangePasswordPage() {
        waitForElementVisible(SidebarPageUI.CHANGE_PASSWORD_LINK);
        clickToElement(SidebarPageUI.CHANGE_PASSWORD_LINK);
        return PageGenerator.getChangePasswordPage(driver);
    }

    public MyProductReviewPageObject openMyProductReviewPage() {
        waitForElementVisible(SidebarPageUI.MY_PRODUCT_REVIEW_LINK);
        clickToElement(SidebarPageUI.MY_PRODUCT_REVIEW_LINK);
        return PageGenerator.getMyProductReviewPage(driver);
    }

    public CustomerInfoPageObject openCustomerInforPage() {
        waitForElementVisible(SidebarPageUI.CUSTOMER_INFOR_LINK);
        clickToElement(SidebarPageUI.CUSTOMER_INFOR_LINK);
        return PageGenerator.getCustomerInfoPageObject(driver);
    }

    public SidebarPageObject openDynamicSideBarPage(String pageName) {
        waitForElementVisible(SidebarPageUI.DYNAMIC_SIDEBAR_LINK, pageName);
        clickToElement( SidebarPageUI.DYNAMIC_SIDEBAR_LINK, pageName);

        switch (pageName) {
            case "Customer info":
                return PageGenerator.getCustomerInfoPageObject(driver);
            case "Addresses":
                return PageGenerator.getAddressPage(driver);
            case "Orders":
                return PageGenerator.getOrdersPage(driver);
            case "Downloadable products":
                return PageGenerator.getDownloadPage(driver);
            case "Back in stock subscriptions":
                return PageGenerator.getBackInStockPage(driver);
            case "Reward points":
                return PageGenerator.getRewardPointsPage(driver);
            case "Change password":
                return PageGenerator.getChangePasswordPage(driver);
            case "My product reviews":
                return PageGenerator.getMyProductReviewPage(driver);
            default:
                new RuntimeException("Sidebar page name incorrect");
                return null;
        }
    }

    public void openDynamicSideBarPagebyName(String pageName) {
        waitForElementVisible(SidebarPageUI.DYNAMIC_SIDEBAR_LINK, pageName);
        clickToElement(SidebarPageUI.DYNAMIC_SIDEBAR_LINK, pageName);
    }
}

