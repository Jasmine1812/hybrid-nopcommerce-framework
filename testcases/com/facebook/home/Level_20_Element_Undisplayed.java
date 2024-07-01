package com.facebook.home;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.HomePageFacebookObject;
import pageObjects.facebook.PageGeneratorFacebook;

public class Level_20_Element_Undisplayed extends BaseTest {
    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePageFacebook = PageGeneratorFacebook.getHomePageFacebook(driver);
    }

    @Test
    public void Home_01_Element_Displayed() {
        homePageFacebook.clickToCreateNewAccountButton();
        verifyTrue(homePageFacebook.isEmailTextboxDisplayed());
        verifyTrue(homePageFacebook.isFirstNameTextboxDisplayed());
        verifyTrue(homePageFacebook.isLastNameTextboxDisplayed());
        verifyTrue(homePageFacebook.isPasswordTextboxDisplayed());
        homePageFacebook.enterToEmailTextbox("tuoi@gmail.com");
        verifyTrue(homePageFacebook.isConfirmEmailTextboxDisplayed());
    }

    @Test
    public void Home_02_Element_Undisplayed_In_HTML() {
        homePageFacebook.enterToEmailTextbox("");
        verifyTrue(homePageFacebook.isConfirmEmailTextboxDisplayed());
    }

    @Test
    public void Home_03_Element_Undisplayed_Not_In_HTML() {
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private HomePageFacebookObject homePageFacebook;
}
