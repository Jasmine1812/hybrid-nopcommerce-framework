package com.jquery.table;


import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePageJQueryObject;
import pageObjects.jquery.PageGeneratorJQuery;

public class Level_12_Handle_DataTable extends BaseTest {
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePageJQuery = PageGeneratorJQuery.getHomePageJQuery(driver);
    }

    @Test
    public void TC_01_Search() {
        homePageJQuery.inputToSearchTextboxByName("Females", "384187");
        homePageJQuery.inputToSearchTextboxByName( "Country", "Afghanistan");
        homePageJQuery.inputToSearchTextboxByName( "Males", "407124");
        homePageJQuery.inputToSearchTextboxByName( "Total", "791312");
    }

    @Test
    public void TC_02_Paging() {
        homePageJQuery.refreshCurrentPage(driver);
        homePageJQuery.clickToPagingByNumber( "4");
        Assert.assertTrue(homePageJQuery.isPageActiveByNumber( "4"));

        homePageJQuery.clickToPagingByNumber( "10");
        Assert.assertTrue(homePageJQuery.isPageActiveByNumber( "10"));
    }

    @Test
    public void TC_03_Displayed() {
        homePageJQuery.refreshCurrentPage(driver);
        Assert.assertTrue(homePageJQuery.isCellValuesDisplayed("12253515", "AFRICA", "12599691", "24853148"));
    }

    @Test
    public void TC_04_Icon_Button_Checkbox() {
        homePageJQuery.refreshCurrentPage(driver);
        homePageJQuery.clickToRowActionByCountryName("Algeria", "edit");
        homePageJQuery.refreshCurrentPage(driver);
        homePageJQuery.clickToRowActionByCountryName("Afghanistan", "remove");

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private HomePageJQueryObject homePageJQuery;


}
