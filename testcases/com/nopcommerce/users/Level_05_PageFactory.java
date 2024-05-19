package com.nopcommerce.users;


import PageFactory.CustomerInfoPageFactory;
import PageFactory.HomePageFactory;
import PageFactory.LoginPageFactory;
import PageFactory.RegisterPageFactory;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.time.Duration;

public class Level_05_PageFactory extends BaseTest {

    private WebDriver driver;
    private HomePageFactory homePage;
    private LoginPageFactory loginPage;
    private CustomerInfoPageFactory customerInfoPage;
    private RegisterPageFactory registerPage;

    private String firstName, lastName, day, month, year, email, company, password, confirmPassword;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
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
        homePage = new HomePageFactory(driver);
        homePage.clickRegisterLink();
        registerPage = new RegisterPageFactory(driver);
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
        registerPage.clickToLogoutLink();
    }

    @Test
    public void TC_02_Login() {
        homePage = new HomePageFactory(driver);
        homePage.clickToLoginLink();
        loginPage = new LoginPageFactory(driver);
        loginPage.enterToEmailTextbox(email);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();
        homePage = new HomePageFactory(driver);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void TC_03_MyAccount() {
        homePage.clickToMyAccountLink();
        customerInfoPage = new CustomerInfoPageFactory(driver);
        Assert.assertTrue(customerInfoPage.isMaleDisplayed());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(customerInfoPage.getDayDropdownSelectedValue(), day);
        Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedValue(), month);
        Assert.assertEquals(customerInfoPage.getYearDropdownSelectedValue(), year);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), email);
        Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(), company);

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
