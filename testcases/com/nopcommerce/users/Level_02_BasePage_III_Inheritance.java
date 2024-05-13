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

        waitForElementClickable(driver, "//a[@class='ico-register']");
        clickToElement(driver, "//a[@class='ico-register']");

        //Đăng ký 1 tài khoản
        sendkeyToElement(driver, "//input[@id='FirstName']", "Jasmine");
        waitForElementClickable(driver, "//input[@id='gender-male']");
        clickToElement(driver, "//input[@id='gender-male']");
        sendkeyToElement(driver, "//input[@id='LastName']", "Tran");
        selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "10");
        selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "May");
        selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
        sendkeyToElement(driver, "//input[@id='Email']", "james" + getRandom() + "@gmail.com");
        sendkeyToElement(driver, "//input[@id='Company']", "NEXTG");
        sendkeyToElement(driver, "//input[@id='Password']", "abcde12345-");
        sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "abcde12345-");
        waitForElementClickable(driver, "//button[@id='register-button']");
        clickToElement(driver, "//button[@id='register-button']");

        //Get Email vừa đăng ký

        Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
        waitForElementClickable(driver, "//a[contains(@class,'register-continue-button')]");
        clickToElement(driver, "//a[contains(@class,'register-continue-button')]");
        waitForElementClickable(driver, "//a[@class='ico-account']");
        clickToElement(driver, "//a[@class='ico-account']");
        System.out.println(getElementAttribute(driver, "//input[@id='Email']", "value"));

        //Logout
        clickToElement(driver, "//a[@class='ico-logout']");


    }

    @Test
    public void TC_02_Login() {
        waitForElementClickable(driver, "//a[@class='ico-login']");
        clickToElement(driver, "//a[@class='ico-login']");
        sendkeyToElement(driver, "//input[@id='Email']", "james59547@gmail.com");
        sendkeyToElement(driver, "//input[@id='Password']", "abcde12345-");
        waitForElementClickable(driver, "//button[contains(@class,'login-button')]");
        clickToElement(driver, "//button[contains(@class,'login-button')]");
        sleepInSeconds(2);
        Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account']"));


    }

    @Test
    public void TC_03_MyAccount() {
        waitForElementClickable(driver, "//a[@class='ico-account']");
        clickToElement(driver, "//a[@class='ico-account']");
        Assert.assertTrue(isElementSelected(driver, "//input[@id='gender-male']"));
        Assert.assertEquals(getElementAttribute(driver, "//input[@id='FirstName']", "value"), "Jasmine");
        Assert.assertEquals(getElementAttribute(driver, "//input[@id='LastName']", "value"), "Tran");
        Assert.assertEquals(getSelectedItemInDropdown(driver, "//select[@name='DateOfBirthDay']"), "10");
        Assert.assertEquals(getSelectedItemInDropdown(driver, "//select[@name='DateOfBirthMonth']"), "May");
        Assert.assertEquals(getSelectedItemInDropdown(driver, "//select[@name='DateOfBirthYear']"), "1999");
        Assert.assertEquals(getElementAttribute(driver, "//input[@id='Email']", "value"), "james59547@gmail.com");
        Assert.assertEquals(getElementAttribute(driver, "//input[@id='Company']", "value"), "NEXTG");

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
