package com.nopcommerce.users;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_01_Repeat_Yourself {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");        ;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Register() {

        driver.findElement(By.cssSelector("a.ico-register")).click();

        //Đăng ký 1 tài khoản
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Jasmine");
        driver.findElement(By.cssSelector("input#gender-male")).click();
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("Tran");
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).selectByVisibleText("10");
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).selectByVisibleText("May");
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).selectByVisibleText("1999");
        driver.findElement(By.cssSelector("input#Email")).sendKeys("james" + getRandom() + "@gmail.com");
        driver.findElement(By.cssSelector("input#Company")).sendKeys("NEXTG");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("abcde12345-");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("abcde12345-");
        driver.findElement(By.cssSelector("button#register-button")).click();

        //Get Email vừa đăng ký

        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
        driver.findElement(By.cssSelector("a.register-continue-button")).click();
        driver.findElement(By.cssSelector("a.ico-account")).click();
        System.out.println(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"));

        //Logout

        driver.findElement(By.cssSelector("a.ico-logout")).click();


    }

    @Test
    public void TC_02_Login() {

        driver.findElement(By.cssSelector("a.ico-login")).click();
        driver.findElement(By.cssSelector("input#Email")).sendKeys("james80881@gmail.com");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("abcde12345-");
        driver.findElement(By.cssSelector("button.login-button")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("a.ico-account")).isDisplayed());

    }

    @Test
    public void TC_03_MyAccount(){
        driver.findElement(By.cssSelector("a.ico-account")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input#gender-male")).isSelected());
        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"),"Jasmine");
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"),"Tran");
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).getFirstSelectedOption().getText(),"10");
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).getFirstSelectedOption().getText(),"May");
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).getFirstSelectedOption().getText(),"1999");
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"),"james80881@gmail.com");
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"),"NEXTG");

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
