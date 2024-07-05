package com.nopcommerce.cookies;


import commons.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.PageGenerator;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

import java.time.Duration;
import java.util.Set;

public class Common_Register extends BaseTest {

    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;

    public static String firstName, lastName, day, month, year, email, company, password, confirmPassword;

    public static Set<Cookie> cookies;
    @Parameters({"browser" })
    @BeforeTest
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
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), ".Your registration completed");
        cookies = registerPage.getBrowserCookies();
        System.out.println(cookies);
    }





}
