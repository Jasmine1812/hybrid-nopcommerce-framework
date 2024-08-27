package pageObjects.saucedemo;

import org.openqa.selenium.WebDriver;

public class PageGeneratorSauce {
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }
    public static ProductsPageObject getProductsPage(WebDriver driver){
        return new ProductsPageObject(driver);
    }
}
