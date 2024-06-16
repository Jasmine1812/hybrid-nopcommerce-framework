package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorJQuery {
    public static HomePageJQueryObject getHomePageJQuery(WebDriver driver){
        return new HomePageJQueryObject(driver);
    }
    public static UploadPage geUploadPage(WebDriver driver){
        return new UploadPage(driver);
    }
}
