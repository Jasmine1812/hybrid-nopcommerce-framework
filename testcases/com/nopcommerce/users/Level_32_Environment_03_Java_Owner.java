
package com.nopcommerce.users;


import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.Environment;
import utilities.PropertiesConfig;

public class Level_32_Environment_03_Java_Owner extends BaseTest {

    private WebDriver driver;
    private PropertiesConfig propertiesConfig;
    private Environment environment;


    @Parameters({"browser", "server"})
    @BeforeClass
    public void beforeClass(String browserName, String serverName) {
        ConfigFactory.setProperty("env", serverName);
        environment = ConfigFactory.create(Environment.class);
        driver = getBrowserDriver(browserName, environment.appUrl());

        System.out.println("App Url: " + environment.appUrl());
        System.out.println("App Username: " + environment.appUsername());
        System.out.println("App Password: " + environment.appPassword());
        System.out.println("DB Url: " + environment.dbUrl());
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
