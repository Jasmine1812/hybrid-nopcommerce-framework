package com.nopcommerce.users;


import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.PageGenerator;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.sidebar.*;

import java.time.Duration;

public class Level_09_Switch_Role extends BaseTest {
    @Parameters({"browser","userUrl", "adminUrl" })
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl) {
        driver = getBrowserDriver(browserName,userUrl);
        this.adminUrl = adminUrl;
        this.userUrl = userUrl;
        homePage = PageGenerator.getHomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
        adminDashboardPage = adminLoginPage.loginToAdmin("admin@yourstore.com", "admin");
        Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));
    }

    @Test
    public void TC_02_Admin_To_User() {
        adminLoginPage = adminDashboardPage.clickToLogoutButton();
        adminLoginPage.openPageUrl(driver,userUrl);
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
    private String adminUrl, userUrl;
    private AdminDashboardPageObject adminDashboardPage;
    private AdminLoginPageObject adminLoginPage;


}
