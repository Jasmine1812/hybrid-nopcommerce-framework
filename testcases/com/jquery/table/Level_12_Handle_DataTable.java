package com.jquery.table;


import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.sidebar.*;

public class Level_12_Handle_DataTable extends BaseTest {
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
    }

    @Test
    public void TC_01_Register_User_To_Admin() {
    }

    @Test
    public void TC_02_Admin_To_User() {
    }

    @Test
    public void TC_03_MyAccount() {

    }

    @Test
    public void TC_04_Switch_Page() {

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;



}
