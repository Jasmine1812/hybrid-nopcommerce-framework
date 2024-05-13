package com.nopcommerce.users;


import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.time.Duration;
import java.util.Random;

public class Level_03_Page_Object {

    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private CustomerInfoPageObject customerInfoPage;
    private RegisterPageObject registerPage;


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Register() {
        homePage.clickRegisterLink();
        registerPage = new RegisterPageObject();
        registerPage.clickToGenderMaleRadio();
        registerPage.enterToFirstNameTextbox();
        registerPage.enterToLastNameTextbox();
        registerPage.selectDayDropdown();
        registerPage.selectMonthDropdown();
        registerPage.selectYearDropdown();
        registerPage.enterToMailTextbox();
        registerPage.enterToCompanyNameTextbox();
        registerPage.enterToPasswordTextbox();
        registerPage.enterToConfirmPasswordTextbox();
        registerPage.clickToRegisterButton();
        Assert.assertTrue(registerPage.getRegisterSuccessMessage(), "Your registration completed");
        registerPage.clickToLogoutLink();
    }

    @Test
    public void TC_02_Login() {
        homePage = new HomePageObject();
        homePage.clickToLoginButton();
        loginPage = new LoginPageObject();
        loginPage.enterToEmailTextbox();
        loginPage.enterToPasswordTextbox();
        loginPage.clickToLoginButton();
        homePage = new HomePageObject();
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void TC_03_MyAccount() {
        homePage.clickToMyAccountLink();
        customerInfoPage = new CustomerInfoPageObject();
        Assert.assertTrue(customerInfoPage.isMaleDisplayed());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue, "");
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue, "");
        Assert.assertEquals(customerInfoPage.getDayDropdownSelectedValue, "");
        Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedValue, "");
        Assert.assertEquals(customerInfoPage.getYearDropdownSelectedValue, "");
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue, "");
        Assert.assertEquals(customerInfoPage.getCompanyTextboxValue, "");

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
