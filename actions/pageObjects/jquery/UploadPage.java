package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.UploadPageUI;

import java.util.List;

public class UploadPage extends BasePage {
    private WebDriver driver;
    public UploadPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isFileLoadedSuccess(String fileName) {
        waitForElementVisible(UploadPageUI.FILE_LOADED_BY_NAME, fileName);
        return isElementDisplayed(UploadPageUI.FILE_LOADED_BY_NAME, fileName);
    }

    public void clickStartButtonOnEachFile() {
        List<WebElement> startButton = getListElement(UploadPageUI.MULTIPLE_START_BUTTON);
        for (WebElement button: startButton){
            waitForElementClickable(button);
            clickToElement(button);
        }

    }

    public boolean isFileUploadedSuccess(String fileName) {
        waitForElementVisible(UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
        return isElementDisplayed(UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
    }
}
