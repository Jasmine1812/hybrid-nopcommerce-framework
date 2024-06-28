package com.nopcommerce.users;


import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_III_Inheritance extends BasePage {

    WebDriver driver;

    public Level_02_BasePage_III_Inheritance(WebDriver driver) {
        super(driver);
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        ;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


    }

    @Test
    public void TC_01_Register() {

        waitForElementClickable("//a[@class='ico-register']");
        clickToElement("//a[@class='ico-register']");

        //Đăng ký 1 tài khoản
        sendkeyToElement("//input[@id='FirstName']", "Jasmine");
        waitForElementClickable("//input[@id='gender-male']");
        clickToElement("//input[@id='gender-male']");
        sendkeyToElement("//input[@id='LastName']", "Tran");
        selectItemInDropdown("//select[@name='DateOfBirthDay']", "10");
        selectItemInDropdown("//select[@name='DateOfBirthMonth']", "May");
        selectItemInDropdown("//select[@name='DateOfBirthYear']", "1999");
        sendkeyToElement("//input[@id='Email']", "james" + getRandom() + "@gmail.com");
        sendkeyToElement("//input[@id='Company']", "NEXTG");
        sendkeyToElement("//input[@id='Password']", "abcde12345-");
        sendkeyToElement("//input[@id='ConfirmPassword']", "abcde12345-");
        waitForElementClickable("//button[@id='register-button']");
        clickToElement("//button[@id='register-button']");

        //Get Email vừa đăng ký

        Assert.assertEquals(getElementText("//div[@class='result']"), "Your registration completed");
        waitForElementClickable("//a[contains(@class,'register-continue-button')]");
        clickToElement("//a[contains(@class,'register-continue-button')]");
        waitForElementClickable("//a[@class='ico-account']");
        clickToElement("//a[@class='ico-account']");
        System.out.println(getElementAttribute("//input[@id='Email']", "value"));

        //Logout
        clickToElement("//a[@class='ico-logout']");


    }

    @Test
    public void TC_02_Login() {
        waitForElementClickable("//a[@class='ico-login']");
        clickToElement("//a[@class='ico-login']");
        sendkeyToElement("//input[@id='Email']", "james59547@gmail.com");
        sendkeyToElement("//input[@id='Password']", "abcde12345-");
        waitForElementClickable("//button[contains(@class,'login-button')]");
        clickToElement("//button[contains(@class,'login-button')]");
        sleepInSeconds(2);
        Assert.assertTrue(isElementDisplayed("//a[@class='ico-account']"));


    }

    @Test
    public void TC_03_MyAccount() {
        waitForElementClickable("//a[@class='ico-account']");
        clickToElement("//a[@class='ico-account']");
        Assert.assertTrue(isElementSelected("//input[@id='gender-male']"));
        Assert.assertEquals(getElementAttribute("//input[@id='FirstName']", "value"), "Jasmine");
        Assert.assertEquals(getElementAttribute("//input[@id='LastName']", "value"), "Tran");
        Assert.assertEquals(getSelectedItemInDropdown("//select[@name='DateOfBirthDay']"), "10");
        Assert.assertEquals(getSelectedItemInDropdown("//select[@name='DateOfBirthMonth']"), "May");
        Assert.assertEquals(getSelectedItemInDropdown("//select[@name='DateOfBirthYear']"), "1999");
        Assert.assertEquals(getElementAttribute("//input[@id='Email']", "value"), "james59547@gmail.com");
        Assert.assertEquals(getElementAttribute("//input[@id='Company']", "value"), "NEXTG");

    }

    public int getRandom() {
        Random random = new Random();
        return random.nextInt(99999);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
