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

public class Level_33_CLOUD_BROWSERSTACK extends BaseTest {
    @Parameters({"url", "osName", "osVersion", "browser", "browserVersion"})
    @BeforeClass
    public void beforeClass(String url, String osName, String osVersion, String browserName, String browserVersion) {
        driver = getBrowserDriver(url, osName, osVersion, browserName, browserVersion);
        homePageJQuery = PageGeneratorJQuery.getHomePageJQuery(driver);
    }

    @Test
    public void TC_01_Search() {
        homePageJQuery.inputToSearchTextboxByName("Females", "384187");
        homePageJQuery.inputToSearchTextboxByName("Country", "Afghanistan");
        homePageJQuery.inputToSearchTextboxByName("Males", "407124");
        homePageJQuery.inputToSearchTextboxByName("Total", "791312");
    }

     @Test
    public void TC_02_Paging() {
        homePageJQuery.refreshCurrentPage();
        homePageJQuery.clickToPagingByNumber("4");
        Assert.assertTrue(homePageJQuery.isPageActiveByNumber("4"));

        homePageJQuery.clickToPagingByNumber("10");
        Assert.assertTrue(homePageJQuery.isPageActiveByNumber("10"));
    }

    @Test
    public void TC_03_Displayed() {
        homePageJQuery.refreshCurrentPage();
        Assert.assertTrue(homePageJQuery.isCellValuesDisplayed("12253515", "AFRICA", "12599691", "24853148"));
    }

    @Test
    public void TC_04_Icon_Button_Checkbox() {
        homePageJQuery.refreshCurrentPage();
        homePageJQuery.clickToRowActionByCountryName("Algeria", "edit");
        homePageJQuery.refreshCurrentPage();
        homePageJQuery.clickToRowActionByCountryName("Afghanistan", "remove");
    }

    @Test
    public void TC_05_Get_All_Column_Values() {
        homePageJQuery.getAllPageValuesByColumnName("Country");
        homePageJQuery.getAllPageValuesByColumnName("Total");
    }

    @Test
    public void TC_06_Sendkey_Values() {
        homePageJQuery.openPageUrl("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        homePageJQuery.inputToTextBoxByColumnNameAndRowIndex("Company", "1", "1234");
        homePageJQuery.inputToTextBoxByColumnNameAndRowIndex("Contact Person", "2", "TuoiNT");
        homePageJQuery.selectToDropdownByColumnNameAndRowIndex("Country", "3", "Japan");

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private HomePageJQueryObject homePageJQuery;


}
