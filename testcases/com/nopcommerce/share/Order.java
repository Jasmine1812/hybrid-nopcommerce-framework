package com.nopcommerce.share;


import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.PageGenerator;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.sidebar.CustomerInfoPageObject;

import java.time.Duration;

public class Order extends BaseTest {

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
        System.out.println("Email on Order page: " + Common_Register.email);
        System.out.println("Pass on Order page: " + Common_Register.password);
    }



    @Test
    public void Order_01() {
    }

    @Test
    public void Order_02() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
