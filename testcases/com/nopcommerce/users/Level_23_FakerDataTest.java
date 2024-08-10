
package com.nopcommerce.users;


import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.sidebar.CustomerInfoPageObject;
import utilities.DataFakerConfig;

import java.time.Duration;

public class Level_23_FakerDataTest extends BaseTest {

    private WebDriver driver;
    private HomePageObject homePage;
    private UserLoginPageObject loginPage;
    private CustomerInfoPageObject customerInfoPage;
    private RegisterPageObject registerPage;
    private DataFakerConfig fakerConfig;

    private String firstName, lastName, month, email, company, password, confirmPassword, day,year;



    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGenerator.getHomePage(driver);
        fakerConfig = DataFakerConfig.getFaker();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        firstName = fakerConfig.getFirstName();
        lastName = fakerConfig.getLastName();
        day = fakerConfig.getDay();
        month = "May";
        year = fakerConfig.getYear();
        email = fakerConfig.getEmail();
        company = fakerConfig.getCompany();
        password = fakerConfig.getPassword();
        confirmPassword = password;
    }

    @Test
    public void TC_01_Register() {

        homePage.clickToHeaderLinkByText("Register");
        registerPage = PageGenerator.getRegisterPage(driver);

        registerPage.clickToGenderMaleRadio();
        registerPage.enterToTextboxByID("FirstName", firstName);
        registerPage.enterToTextboxByID("LastName", lastName);
        registerPage.selectDayDropdown(day);
        registerPage.selectMonthDropdown(month);
        registerPage.selectYearDropdown(year);
        registerPage.enterToTextboxByID("Email", email);
        registerPage.enterToTextboxByID("Company", company);
        registerPage.enterToTextboxByID("Password", password);
        registerPage.enterToTextboxByID("ConfirmPassword", confirmPassword);
        registerPage.clickToButtonByText("Register");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
        registerPage.clickToHeaderLinkByText("Log out");
        homePage = PageGenerator.getHomePage(driver);

    }

    @Test
    public void TC_02_Login() {
        homePage.clickToHeaderLinkByText("Log in");
        loginPage = PageGenerator.getUserLoginPage(driver);
        loginPage.enterToTextboxByID("Email", email);
        loginPage.enterToTextboxByID("Password", password);
        loginPage.clickToButtonByText("Log in");
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
