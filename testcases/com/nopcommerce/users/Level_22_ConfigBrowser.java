
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

import java.time.Duration;

public class Level_22_ConfigBrowser extends BaseTest {

    private WebDriver driver;
    private HomePageObject homePage;
    private UserLoginPageObject loginPage;
    private CustomerInfoPageObject customerInfoPage;
    private RegisterPageObject registerPage;

    private String firstName, lastName, day, month, year, email, company, password, confirmPassword;


    @Parameters({"browser" })
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGenerator.getHomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        firstName = "Tran";
        lastName = "Thi";
        day = "10";
        month = "May";
        year = "1994";
        email = "jasmine"+ generateRandomNumber() + "@gmail.com";
        company = "NEXTG";
        password = "abcde12345-";
        confirmPassword = "abcde12345-";
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

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
