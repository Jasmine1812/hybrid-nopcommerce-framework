package com.nopcommerce.users;

import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

public class Level_15_Log extends BaseTest {
    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName, userUrl);
        homePage = PageGenerator.getHomePage(driver);

        firstName = "Tran";
        lastName = "Thi";
        day = "10";
        month = "May";
        year = "1994";
        email = "jasmine" + generateRandomNumber() + "@gmail.com";
        company = "NEXTG";
        password = "abcde12345-";
        confirmPassword = "abcde12345-";
    }

    @Test
    public void TC_01_Register_User_To_Admin() {
        log.info("Register - Step 1: verify Register link is not displayed");
        verifyFalse(homePage.isRegisterLinkDisplayed());
        log.info("Register - Step 2: Click to Register link");
        registerPage = homePage.clickRegisterLink();
        log.info("Register - Step 3: Click to Gender Male Radio");
        registerPage.clickToGenderMaleRadio();
        log.info("Register - Step 4: Click to Register button");
        registerPage.clickToRegisterButton();
        log.info("Register - Step 5: Verify error message at First Name textbox");
        verifyEquals(registerPage.getFirstNameErrorMessageText(),"First name is required");
        log.info("Register - Step 6: Verify error message at Last Name textbox");
        verifyEquals(registerPage.getLastNameErrorMessageText(),"Last name is required.");
        log.info("Register - Step 7: Enter to First Name Textbox: " + firstName);
        registerPage.enterToFirstNameTextbox(firstName);
        log.info("Register - Step 8: Enter to Last Name Textbox: " + lastName);
        registerPage.enterToLastNameTextbox(lastName);
        log.info("Register - Step 9: Enter to Day dropdown: " + day);
        registerPage.selectDayDropdown(day);
        log.info("Register - Step 10: Enter to Month dropdown: " + month);
        registerPage.selectMonthDropdown(month);
        log.info("Register - Step 11: Enter to Year dropdown: " + year);
        registerPage.selectYearDropdown(year);
        log.info("Register - Step 12: Enter to Email textbox: " + email);
        registerPage.enterToMailTextbox(email);
        log.info("Register - Step 13: Enter to Company textbox: " + company);
        registerPage.enterToCompanyNameTextbox(company);
        log.info("Register - Step 14: Enter to Password textbox: " + password);
        registerPage.enterToPasswordTextbox(password);
        log.info("Register - Step 15: Enter to confirm password textbox: " + confirmPassword);
        registerPage.enterToConfirmPasswordTextbox(confirmPassword);
        log.info("Register - Step 16: Click to Register button");
        registerPage.clickToRegisterButton();
        log.info("Register - Step 17: Verify success message is displayed");
        verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");
        homePage = registerPage.clickToLogoutLink();


    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;



    private String firstName, lastName, day, month, year, email, company, password, confirmPassword;
    private String adminUrl = GlobalConstants.DEV_ADMIN_URL;
    private String userUrl = GlobalConstants.DEV_USER_URL;

    private AdminDashboardPageObject adminDashboardPage;
    private AdminLoginPageObject adminLoginPage;
}
