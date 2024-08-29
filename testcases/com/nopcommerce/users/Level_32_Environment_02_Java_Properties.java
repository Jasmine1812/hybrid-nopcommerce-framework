
package com.nopcommerce.users;


import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.PropertiesConfig;

public class Level_32_Environment_02_Java_Properties extends BaseTest {

    private WebDriver driver;
    private PropertiesConfig propertiesConfig;


    @Parameters({"browser", "server"})
    @BeforeClass
    public void beforeClass(String browserName, String serverName) {
        propertiesConfig = PropertiesConfig.getPropertiesConfig(serverName);
        driver = getBrowserDriver(browserName, propertiesConfig.getApplicationUrl());
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
