package com.nopcommerce.cookies;


import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;

import java.time.Duration;

public class Order extends BaseTest {

    private WebDriver driver;
    private HomePageObject homePage;
    private UserLoginPageObject loginPage;


    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGenerator.getHomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        loginPage = homePage.clickToLoginLink();
        loginPage.setCookies(Common_Register.cookies);
        loginPage.sleepInSeconds(5);
        loginPage.refreshCurrentPage();
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }


    @Test
    public void Order_01() {
    }

    @Test
    public void Order_02() {
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
