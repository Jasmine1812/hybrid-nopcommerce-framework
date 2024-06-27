//package com.nopcommerce.users;
//
//import com.relevantcodes.extentreports.LogStatus;
//import commons.BaseTest;
//import commons.GlobalConstants;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//import pageObjects.PageGenerator;
//import pageObjects.admin.AdminDashboardPageObject;
//import pageObjects.admin.AdminLoginPageObject;
//import pageObjects.user.HomePageObject;
//import pageObjects.user.RegisterPageObject;
//import reportConfig.ExtentManager;
//
//import java.lang.reflect.Method;
//
//public class Level_17_ExtentReportV2 extends BaseTest {
//    @Parameters({"browser"})
//    @BeforeClass
//    public void beforeClass(String browserName) {
//        driver = getBrowserDriver(browserName, userUrl);
//        homePage = PageGenerator.getHomePage(driver);
//
//        firstName = "Tran";
//        lastName = "Thi";
//        day = "10";
//        month = "May";
//        year = "1994";
//        email = "jasmine" + generateRandomNumber() + "@gmail.com";
//        company = "NEXTG";
//        password = "abcde12345-";
//        confirmPassword = "abcde12345-";
//    }
//
//    @Test
//    public void TC_01_Register_User_To_Admin(Method method) {
//        ExtentManager.startTest(method.getName(), "TC_01_Register_User_To_Admin");
//        ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 1: verify Register link is not displayed");
//        Assert.assertTrue(homePage.isRegisterLinkDisplayed());
//        ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 2: Click to Register link");
//        registerPage = homePage.clickRegisterLink();
//        ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 3: Click to Gender Male Radio");
//        registerPage.clickToGenderMaleRadio();
//        ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 4: Click to Register button");
//        registerPage.clickToRegisterButton();
//        ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 5: Verify error message at First Name textbox");
//        verifyEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");
//        ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 6: Verify error message at Last Name textbox");
//        Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required.");
//    }
//
//    @Test
//    public void TC_02(Method method){
//        ExtentManager.startTest(method.getName(), "TC_02");
//        ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 7: Enter to First Name Textbox: " + firstName);
//        registerPage.enterToFirstNameTextbox(firstName);
//        ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 8: Enter to Last Name Textbox: " + lastName);
//        registerPage.enterToLastNameTextbox(lastName);
//        ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 9: Enter to Day dropdown: " + day);
//        registerPage.selectDayDropdown(day);
//        ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 10: Enter to Month dropdown: " + month);
//        registerPage.selectMonthDropdown(month);
//        ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 11: Enter to Year dropdown: " + year);
//        registerPage.selectYearDropdown(year);
//        ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 12: Enter to Email textbox: " + email);
//        registerPage.enterToMailTextbox(email);
//        ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 13: Enter to Company textbox: " + company);
//        registerPage.enterToCompanyNameTextbox(company);
//        ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 14: Enter to Password textbox: " + password);
//        registerPage.enterToPasswordTextbox(password);
//        ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 15: Enter to confirm password textbox: " + confirmPassword);
//        registerPage.enterToConfirmPasswordTextbox(confirmPassword);
//        ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 16: Click to Register button");
//        registerPage.clickToRegisterButton();
//        ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 17: Verify success message is displayed");
//        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");
//        homePage = registerPage.clickToLogoutLink();
//
//    }
//
//
//    @AfterClass
//    public void afterClass() {
//        driver.quit();
//    }
//
//    private WebDriver driver;
//    private HomePageObject homePage;
//    private RegisterPageObject registerPage;
//
//
//    private String firstName, lastName, day, month, year, email, company, password, confirmPassword;
//    private String adminUrl = GlobalConstants.DEV_ADMIN_URL;
//    private String userUrl = GlobalConstants.DEV_USER_URL;
//
//    private AdminDashboardPageObject adminDashboardPage;
//    private AdminLoginPageObject adminLoginPage;
//}
