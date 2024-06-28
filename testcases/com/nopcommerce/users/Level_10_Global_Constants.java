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
import pageObjects.user.sidebar.CustomerInfoPageObject;

public class Level_10_Global_Constants extends BaseTest {
    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName, userUrl);
        homePage = PageGenerator.getHomePage(driver);

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
        homePage.openPageUrl(adminUrl);
        adminLoginPage = PageGenerator.getAdminLoginPage(driver);
        adminDashboardPage = adminLoginPage.loginToAdmin(GlobalConstants.DEV_ADMIN_USERNAME, GlobalConstants.DEV_ADMIN_PASSWORD);
        Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));
    }

    @Test
    public void TC_02_Admin_To_User() {
        adminLoginPage = adminDashboardPage.clickToLogoutButton();
        adminLoginPage.openPageUrl(userUrl);
        homePage = PageGenerator.getHomePage(driver);
        userLoginPage = homePage.clickToLoginLink();
        homePage = userLoginPage.loginToUserPage(email,password);
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

    private String firstName, lastName, day, month, year, email, company, password, confirmPassword;
    private String adminUrl = GlobalConstants.DEV_ADMIN_URL;
    private String userUrl = GlobalConstants.DEV_USER_URL;

    private AdminDashboardPageObject adminDashboardPage;
    private AdminLoginPageObject adminLoginPage;


}
