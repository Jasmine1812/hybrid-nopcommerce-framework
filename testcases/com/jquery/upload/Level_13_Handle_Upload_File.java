package com.jquery.upload;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePageJQueryObject;
import pageObjects.jquery.PageGeneratorJQuery;
import pageObjects.jquery.UploadPage;

import java.io.File;

public class Level_13_Handle_Upload_File extends BaseTest {
    private WebDriver driver;
    String image1 = "image01.jpg";
    String image2 = "image02.jpg";
    String image3 = "image03.jpg";
    private UploadPage uploadPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        uploadPage = PageGeneratorJQuery.geUploadPage(driver);
    }

    @Test
    public void TC_01_Single_Upload_File(){
        uploadPage.uploadMultipleFiles(driver,image1);
        uploadPage.sleepInSeconds(2);

        uploadPage.uploadMultipleFiles(driver,image2);
        uploadPage.sleepInSeconds(2);

        uploadPage.uploadMultipleFiles(driver,image3);
        uploadPage.sleepInSeconds(2);

        Assert.assertTrue(uploadPage.isFileLoadedSuccess(image1));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(image2));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(image3));

        uploadPage.clickStartButtonOnEachFile();

        Assert.assertTrue(uploadPage.isFileUploadedSuccess(image1));
        Assert.assertTrue(uploadPage.isFileUploadedSuccess(image2));
        Assert.assertTrue(uploadPage.isFileUploadedSuccess(image3));




    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
