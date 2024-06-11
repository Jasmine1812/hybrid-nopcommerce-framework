package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorJQuery {
    public static HomePageJQueryObject getHomePageJQuery(WebDriver driver){
        return new HomePageJQueryObject(driver);
    }
}
