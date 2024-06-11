package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.user.sidebar.*;
import pageUIs.users.SidebarPageUI;

public class SidebarPageObject extends BasePage {
    private WebDriver driver;

    public SidebarPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AddressPageObject openAddressPage() {
        waitForElementVisible(driver, SidebarPageUI.ADDRESSES_LINK);
        clickToElement(driver, SidebarPageUI.ADDRESSES_LINK);
        return PageGenerator.getAddressPage(driver);
    }

    public OrdersPageObject openOrdersPage() {
        waitForElementVisible(driver, SidebarPageUI.ORDERS_LINK);
        clickToElement(driver, SidebarPageUI.ORDERS_LINK);
        return PageGenerator.getOrdersPage(driver);
    }

    public DownloadablePageObject openDownloadPage() {
        waitForElementVisible(driver, SidebarPageUI.DOWNLOADABLE_PRODUCTS_LINK);
        clickToElement(driver, SidebarPageUI.DOWNLOADABLE_PRODUCTS_LINK);
        return PageGenerator.getDownloadPage(driver);
    }

    public BackInStockPageObject openBackInStockPage() {
        waitForElementVisible(driver, SidebarPageUI.BACK_IN_STOCK_LINK);
        clickToElement(driver, SidebarPageUI.BACK_IN_STOCK_LINK);
        return PageGenerator.getBackInStockPage(driver);
    }

    public RewardPointsPageObject openRewardPointsPage() {
        waitForElementVisible(driver, SidebarPageUI.REWARD_POINTS_LINK);
        clickToElement(driver, SidebarPageUI.REWARD_POINTS_LINK);
        return PageGenerator.getRewardPointsPage(driver);
    }

    public ChangePasswordPageObject openChangePasswordPage() {
        waitForElementVisible(driver, SidebarPageUI.CHANGE_PASSWORD_LINK);
        clickToElement(driver, SidebarPageUI.CHANGE_PASSWORD_LINK);
        return PageGenerator.getChangePasswordPage(driver);
    }

    public MyProductReviewPageObject openMyProductReviewPage() {
        waitForElementVisible(driver, SidebarPageUI.MY_PRODUCT_REVIEW_LINK);
        clickToElement(driver, SidebarPageUI.MY_PRODUCT_REVIEW_LINK);
        return PageGenerator.getMyProductReviewPage(driver);
    }

    public CustomerInfoPageObject openCustomerInforPage() {
        waitForElementVisible(driver, SidebarPageUI.CUSTOMER_INFOR_LINK);
        clickToElement(driver, SidebarPageUI.CUSTOMER_INFOR_LINK);
        return PageGenerator.getCustomerInfoPageObject(driver);
    }

    public SidebarPageObject openDynamicSideBarPage(String pageName) {
        waitForElementVisible(driver, SidebarPageUI.DYNAMIC_SIDEBAR_LINK, pageName);
        clickToElement(driver, SidebarPageUI.DYNAMIC_SIDEBAR_LINK, pageName);

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
        waitForElementVisible(driver, SidebarPageUI.DYNAMIC_SIDEBAR_LINK, pageName);
        clickToElement(driver, SidebarPageUI.DYNAMIC_SIDEBAR_LINK, pageName);
    }
}

