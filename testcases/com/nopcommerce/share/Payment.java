package com.nopcommerce.share;


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

public class Payment extends BaseTest {

    private WebDriver driver;
    private HomePageObject homePage;
    private UserLoginPageObject loginPage;



    @Parameters({"browser" })
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGenerator.getHomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        homePage.clickToHeaderLinkByText("Log in");
        loginPage = PageGenerator.getUserLoginPage(driver);
        loginPage.enterToEmailTextbox(Common_Register.email);
        loginPage.enterToPasswordTextbox(Common_Register.password);
        loginPage.clickToButtonByText("Log in");
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
        System.out.println("Email on Payment page: " + Common_Register.email);
        System.out.println("Pass on Payment page: " + Common_Register.password);
    }


    @Test
    public void Payment_01() {
    }

    @Test
    public void Payment_02() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
