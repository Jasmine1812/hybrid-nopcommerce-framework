package PageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePageFactory {


    public static BasePageFactory getBasePage() {
        return new BasePageFactory();
    }


    public void clickToElement(WebDriver driver, WebElement element) {
        element.click();
    }

    public void sendkeyToElement(WebDriver driver, WebElement element, String keysToSend) {
        element.clear();
        element.sendKeys(keysToSend);
    }

    public void selectItemInDropdown(WebDriver driver, WebElement element, String textItem) {
        new Select(element).selectByVisibleText(textItem);
    }

    public String getSelectedItemInDropdown(WebDriver driver, WebElement element) {
        return new Select(element).getFirstSelectedOption().getText();
    }


    public String getElementAttribute(WebDriver driver, WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    public String getElementText(WebDriver driver, WebElement element) {
        return element.getText();
    }


    public void checkToCheckboxRadio(WebDriver driver, WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }


    public boolean isElementDisplayed(WebDriver driver, WebElement element) {
        return element.isDisplayed();
    }

    public boolean isElementSelected(WebDriver driver, WebElement element) {
        return element.isSelected();
    }

    public boolean isElementEnabled(WebDriver driver, WebElement element) {
        return element.isEnabled();
    }


    public void waitForElementVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
    }


    public void waitForElementSelected(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeSelected(element));
    }


    public void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
    }


}
