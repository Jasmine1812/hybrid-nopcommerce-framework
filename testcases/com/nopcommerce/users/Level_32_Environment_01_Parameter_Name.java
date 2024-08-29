
package com.nopcommerce.users;


import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Level_32_Environment_01_Parameter_Name extends BaseTest {

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
