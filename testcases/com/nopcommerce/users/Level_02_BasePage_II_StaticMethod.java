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

public class Level_02_BasePage_II_StaticMethod {

    WebDriver driver;
    BasePage basePage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        basePage = BasePage.getBasePage();
        driver.get("https://demo.nopcommerce.com/");        ;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Register() {

        basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//a[@class='ico-register']");

        //Đăng ký 1 tài khoản
        basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Jasmine" );
        basePage.waitForElementClickable(driver, "//input[@id='gender-male']");
        basePage.clickToElement(driver, "//input[@id='gender-male']");
        basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Tran" );
        basePage.selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "10");
        basePage.selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "May");
        basePage.selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
        basePage.sendkeyToElement(driver, "//input[@id='Email']", "james" + getRandom() + "@gmail.com" );
        basePage.sendkeyToElement(driver, "//input[@id='Company']", "NEXTG" );
        basePage.sendkeyToElement(driver, "//input[@id='Password']", "abcde12345-");
        basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "abcde12345-");
        basePage.waitForElementClickable(driver, "//button[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        //Get Email vừa đăng ký

        Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
        basePage.waitForElementClickable(driver, "//a[contains(@class,'register-continue-button')]");
        basePage.clickToElement(driver, "//a[contains(@class,'register-continue-button')]");
        basePage.waitForElementClickable(driver, "//a[@class='ico-account']");
        basePage.clickToElement(driver, "//a[@class='ico-account']");
        System.out.println(basePage.getElementAttribute(driver, "//input[@id='Email']", "value"));

        //Logout
        basePage.clickToElement(driver, "//a[@class='ico-logout']");



    }

    @Test
    public void TC_02_Login() {
        basePage.waitForElementClickable(driver, "//a[@class='ico-login']");
        basePage.clickToElement(driver, "//a[@class='ico-login']");
        basePage.sendkeyToElement(driver, "//input[@id='Email']", "james59547@gmail.com");
        basePage.sendkeyToElement(driver, "//input[@id='Password']", "abcde12345-");
        basePage.waitForElementClickable(driver, "//button[contains(@class,'login-button')]");
        basePage.clickToElement(driver, "//button[contains(@class,'login-button')]");
        basePage.sleepInSeconds(2);
        Assert.assertTrue(basePage.isElementDisplayed(driver, "//a[@class='ico-account']"));


    }

    @Test
    public void TC_03_MyAccount(){
        basePage.waitForElementClickable(driver, "//a[@class='ico-account']");
        basePage.clickToElement(driver, "//a[@class='ico-account']");
        Assert.assertTrue(basePage.isElementSelected(driver, "//input[@id='gender-male']"));
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='FirstName']", "value"),"Jasmine");
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='LastName']", "value"),"Tran");
        Assert.assertEquals(basePage.getSelectedItemInDropdown(driver,"//select[@name='DateOfBirthDay']"),"10");
        Assert.assertEquals(basePage.getSelectedItemInDropdown(driver,"//select[@name='DateOfBirthMonth']"),"May");
        Assert.assertEquals(basePage.getSelectedItemInDropdown(driver,"//select[@name='DateOfBirthYear']"),"1999");
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='Email']", "value"),"james59547@gmail.com");
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='Company']", "value"),"NEXTG");

    }

    public int getRandom(){
        Random random = new Random();
        return random.nextInt(99999);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
