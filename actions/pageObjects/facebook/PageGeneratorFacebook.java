package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

public class PageGeneratorFacebook {

    public static HomePageFacebookObject getHomePageFacebook(WebDriver driver){ return new HomePageFacebookObject(driver);

    }
}
