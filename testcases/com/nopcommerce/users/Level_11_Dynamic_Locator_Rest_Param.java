package com.nopcommerce.users;


import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.sidebar.*;

public class Level_11_Dynamic_Locator_Rest_Param extends BaseTest {
    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName, userUrl);
        homePage = PageGenerator.getHomePageObject(driver);

        firstName = "Tran";
        lastName = "Thi";
        day = "10";
        month = "May";
        year = "1994";
        email = "jasmine" + generateRandomNumber() + "@gmail.com";
        company = "NEXTG";
        password = "abcde12345-";
        confirmPassword = "abcde12345-";
    }

    @Test
    public void TC_01_Register_User_To_Admin() {

        registerPage = homePage.clickRegisterLink();
        registerPage.clickToGenderMaleRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.selectDayDropdown(day);
        registerPage.selectMonthDropdown(month);
        registerPage.selectYearDropdown(year);
        registerPage.enterToMailTextbox(email);
        registerPage.enterToCompanyNameTextbox(company);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(confirmPassword);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
        homePage = registerPage.clickToLogoutLink();

        //Tu UserPage sang AdminPage
        homePage.openPageUrl(driver, adminUrl);
        adminLoginPage = PageGenerator.getAdminLoginPage(driver);
        adminDashboardPage = adminLoginPage.loginToAdmin(GlobalConstants.DEV_ADMIN_USERNAME, GlobalConstants.DEV_ADMIN_PASSWORD);
        Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));
    }

    @Test
    public void TC_02_Admin_To_User() {
        adminLoginPage = adminDashboardPage.clickToLogoutButton();
        adminLoginPage.openPageUrl(driver,userUrl);
        homePage = PageGenerator.getHomePageObject(driver);
        userLoginPage = homePage.clickToLoginLink();
        homePage = userLoginPage.loginToUserPage(email,password);
    }

    @Test
    public void TC_03_MyAccount() {
        customerInfoPage = homePage.clickToMyAccountLink();
        Assert.assertTrue(customerInfoPage.isMaleDisplayed());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(customerInfoPage.getDayDropdownSelectedValue(), day);
        Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedValue(), month);
        Assert.assertEquals(customerInfoPage.getYearDropdownSelectedValue(), year);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), email);
        Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(), company);

    }

    @Test
    public void TC_04_Switch_Page() {
//        addressPage = customerInfoPage.openAddressPage();
        addressPage = (AddressPageObject) customerInfoPage.openDynamicSideBarPage("customer-addresses");
//        ordersPage = addressPage.openOrdersPage();
//        downloadablePage = ordersPage.openDownloadPage();
//        backInStockPage = downloadablePage.openBackInStockPage();
//        rewardPointsPage = backInStockPage.openRewardPointsPage();
//        changePasswordPage = rewardPointsPage.openChangePasswordPage();
//        myProductReviewPage = changePasswordPage.openMyProductReviewPage();
//        customerInfoPage = myProductReviewPage.openCustomerInforPage();

    }

    @Test
    public void TC_05_Switch_Page() {
        addressPage.openDynamicSideBarPage("customer-reviews");
        myProductReviewPage = PageGenerator.getMyProductReviewPage(driver);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private HomePageObject homePage;
    private UserLoginPageObject userLoginPage;
    private CustomerInfoPageObject customerInfoPage;
    private RegisterPageObject registerPage;


    private AddressPageObject addressPage;
    private BackInStockPageObject backInStockPage;
    private ChangePasswordPageObject changePasswordPage;
    private DownloadablePageObject downloadablePage;
    private MyProductReviewPageObject myProductReviewPage;
    private OrdersPageObject ordersPage;
    private RewardPointsPageObject rewardPointsPage;

    private String firstName, lastName, day, month, year, email, company, password, confirmPassword;
    private String adminUrl = GlobalConstants.DEV_ADMIN_URL;
    private String userUrl = GlobalConstants.DEV_USER_URL;

    private AdminDashboardPageObject adminDashboardPage;
    private AdminLoginPageObject adminLoginPage;


}
