package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePage {

    WebDriver driver;
    WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

    public void getUrl(String url) {
        driver.get(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void back() {
        driver.navigate().back();
    }

    public void forward() {
        driver.navigate().forward();
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    //Alert
    public void waitAlertPresence() {
        explicitWait.until(ExpectedConditions.alertIsPresent());

    }

    public void cancelAlert(Alert alert) {
        alert.dismiss();
    }

    public String getTextAlert(Alert alert) {
        return alert.getText();
    }

    public void sendKeyToAlert(Alert alert, String sendText) {
        alert.sendKeys(sendText);
    }

    //Windows

    public String getWindowHandle(){
        return driver.getWindowHandle();
    }

    public void switchWindowByID(String idCurrentPage){
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs){
            if (id.equals(idCurrentPage)){
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchWindowByTitle(String titlePage){
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs){
            driver.switchTo().window(id);
            if (driver.getTitle().equals(titlePage)){
                break;
            }

        }
    }

    public void closeAllWindowsWithoutParent(String parentID){
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs){
            if (!id.equals(parentID)){
                driver.switchTo().window(id);
                driver.close();
            }
        }
    }


}
