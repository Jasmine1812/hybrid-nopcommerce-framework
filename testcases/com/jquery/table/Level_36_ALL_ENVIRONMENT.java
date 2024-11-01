package com.jquery.table;


import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.jquery.HomePageJQueryObject;
import pageObjects.jquery.PageGeneratorJQuery;

public class Level_36_ALL_ENVIRONMENT extends BaseTest {
    @Parameters({"browser", "server", "envName", "osName", "osVersion", "browserVersion", "portNumber"})
    @BeforeClass
    public void beforeClass(String browserName, String serverName, @Optional("local") String envName,@Optional("Window") String osName,@Optional("11") String osVersion,@Optional("latest") String browserVersion,@Optional("4444") String portNumber) {
        driver = getBrowserDriverAllEnvironment(browserName, serverName, envName, osName, osVersion, browserVersion, portNumber);
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

//    @Test
    public void TC_04_Icon_Button_Checkbox() {
        homePageJQuery.refreshCurrentPage();
        homePageJQuery.clickToRowActionByCountryName("Algeria", "edit");
        homePageJQuery.refreshCurrentPage();
        homePageJQuery.clickToRowActionByCountryName("Afghanistan", "remove");
    }

//    @Test
    public void TC_05_Get_All_Column_Values() {
        homePageJQuery.getAllPageValuesByColumnName("Country");
        homePageJQuery.getAllPageValuesByColumnName("Total");
    }

//    @Test
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
