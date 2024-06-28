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
        basePage = new BasePage(driver);
        driver.get("https://demo.nopcommerce.com/");        ;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Register() {

        basePage.waitForElementClickable("//a[@class='ico-register']");
        basePage.clickToElement("//a[@class='ico-register']");

        //Đăng ký 1 tài khoản
        basePage.sendkeyToElement("//input[@id='FirstName']", "Jasmine" );
        basePage.waitForElementClickable("//input[@id='gender-male']");
        basePage.clickToElement("//input[@id='gender-male']");
        basePage.sendkeyToElement("//input[@id='LastName']", "Tran" );
        basePage.selectItemInDropdown("//select[@name='DateOfBirthDay']", "10");
        basePage.selectItemInDropdown("//select[@name='DateOfBirthMonth']", "May");
        basePage.selectItemInDropdown("//select[@name='DateOfBirthYear']", "1999");
        basePage.sendkeyToElement("//input[@id='Email']", "james" + getRandom() + "@gmail.com" );
        basePage.sendkeyToElement("//input[@id='Company']", "NEXTG" );
        basePage.sendkeyToElement("//input[@id='Password']", "abcde12345-");
        basePage.sendkeyToElement("//input[@id='ConfirmPassword']", "abcde12345-");
        basePage.waitForElementClickable("//button[@id='register-button']");
        basePage.clickToElement("//button[@id='register-button']");

        //Get Email vừa đăng ký

        Assert.assertEquals(basePage.getElementText("//div[@class='result']"), "Your registration completed");
        basePage.waitForElementClickable("//a[contains(@class,'register-continue-button')]");
        basePage.clickToElement("//a[contains(@class,'register-continue-button')]");
        basePage.waitForElementClickable("//a[@class='ico-account']");
        basePage.clickToElement("//a[@class='ico-account']");
        System.out.println(basePage.getElementAttribute("//input[@id='Email']", "value"));

        //Logout
        basePage.clickToElement("//a[@class='ico-logout']");



    }

    @Test
    public void TC_02_Login() {
        basePage.waitForElementClickable("//a[@class='ico-login']");
        basePage.clickToElement("//a[@class='ico-login']");
        basePage.sendkeyToElement("//input[@id='Email']", "james59547@gmail.com");
        basePage.sendkeyToElement("//input[@id='Password']", "abcde12345-");
        basePage.waitForElementClickable("//button[contains(@class,'login-button')]");
        basePage.clickToElement("//button[contains(@class,'login-button')]");
        basePage.sleepInSeconds(2);
        Assert.assertTrue(basePage.isElementDisplayed("//a[@class='ico-account']"));


    }

    @Test
    public void TC_03_MyAccount(){
        basePage.waitForElementClickable("//a[@class='ico-account']");
        basePage.clickToElement("//a[@class='ico-account']");
        Assert.assertTrue(basePage.isElementSelected("//input[@id='gender-male']"));
        Assert.assertEquals(basePage.getElementAttribute("//input[@id='FirstName']", "value"),"Jasmine");
        Assert.assertEquals(basePage.getElementAttribute("//input[@id='LastName']", "value"),"Tran");
        Assert.assertEquals(basePage.getSelectedItemInDropdown("//select[@name='DateOfBirthDay']"),"10");
        Assert.assertEquals(basePage.getSelectedItemInDropdown("//select[@name='DateOfBirthMonth']"),"May");
        Assert.assertEquals(basePage.getSelectedItemInDropdown("//select[@name='DateOfBirthYear']"),"1999");
        Assert.assertEquals(basePage.getElementAttribute("//input[@id='Email']", "value"),"james59547@gmail.com");
        Assert.assertEquals(basePage.getElementAttribute("//input[@id='Company']", "value"),"NEXTG");

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
