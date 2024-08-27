package com.saucedemo;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.saucedemo.LoginPageObject;
import pageObjects.saucedemo.PageGeneratorSauce;
import pageObjects.saucedemo.ProductsPageObject;

public class Level_31_Sort_ASC_DESC extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private ProductsPageObject productsPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGeneratorSauce.getLoginPage(driver);
        productsPage = loginPage.loginToPage("standard_user", "secret_sauce");


    }

    @Test
    public void TC_01_Sort_Name_Ascending() {
        productsPage.selectSortDropdown("Name (A to Z)");
        Assert.assertTrue(productsPage.isProductNameSortByAscending());
    }

    @Test
    public void TC_02_Sort_Name_Descending() {
        productsPage.selectSortDropdown("Name (Z to A)");
        Assert.assertTrue(productsPage.isProductNameSortByDescending());
    }

    @Test
    public void TC_03_Sort_Price_Ascending() {
        productsPage.selectSortDropdown("Price (low to high)");
        Assert.assertTrue(productsPage.isProductPriceSortAscending());
    }

    @Test
    public void TC_04_Sort_Price_Descending() {
        productsPage.selectSortDropdown("Price (high to low)");
        Assert.assertTrue(productsPage.isProductPriceSortDescending());
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
