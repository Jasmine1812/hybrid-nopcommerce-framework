
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

public class Level_32_Handle_Multiple_Server extends BaseTest {

    private WebDriver driver;





    @Parameters({"browser","server"})
    @BeforeClass
    public void beforeClass(String browserName, String serverName) {
        driver = getBrowserEnvironment(browserName, serverName);
    }

    @Test
    public void TC_01_Register() {


    }

    @Test
    public void TC_02_Login() {
    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
