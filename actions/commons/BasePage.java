package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PageGenerator;
import pageObjects.user.sidebar.*;
import pageUIs.users.BasePageUI;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

//    public static BasePage getBasePage() {
//        return new BasePage();
//    }

    public void openPageUrl(String url) {
        driver.get(url);
    }

    public String getDynamicLocator(String locator, String... restParams) {
        return String.format(locator, (Object[]) restParams);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getPageURL() {
        return driver.getCurrentUrl();
    }

    public String getPageSourceCode() {
        return driver.getPageSource();
    }

    public void backToPage() {
        driver.navigate().back();
    }

    public void forwardToPage() {
        driver.navigate().forward();
    }

    public void refreshCurrentPage() {
        driver.navigate().refresh();
    }

    //Alert
    public Alert waitAlertPresence() {
        return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.alertIsPresent());
    }

    public void cancelAlert() {
        waitAlertPresence().dismiss();
    }

    public String getTextAlert() {
        return waitAlertPresence().getText();
    }

    public void sendKeyToAlert(String sendText) {
        waitAlertPresence().sendKeys(sendText);
    }

    //Windows

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public void switchWindowByID(String idCurrentPage) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs) {
            if (!id.equals(idCurrentPage)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchWindowByTitle(String titlePage) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs) {
            driver.switchTo().window(id);
            if (driver.getTitle().equals(titlePage)) {
                break;
            }

        }
    }

    public void closeAllWindowsWithoutParent(String parentID) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    public WebElement getElement(String locator) {
        return driver.findElement(getByLocator(locator));
    }

    public List<WebElement> getListElement(String locator) {
        return driver.findElements(getByLocator(locator));
    }

    public List<WebElement> getListElement(String locator, String... restParams) {
        return driver.findElements(getByLocator(getDynamicLocator(locator, restParams)));
    }

    public int getListElementSize(String locator) {
        return getListElement(locator).size();
    }

    public int getListElementSize(String locator, String... restParams) {
        return getListElement(locator, restParams).size();
    }

    public By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public void clickToElement(String locator) {
        getElement(locator).click();
    }

    public void clickToElement(WebElement element) {
        element.click();
    }

    public void clickToElement(String locator, String... restParams) {
        getElement(getDynamicLocator(locator, restParams)).click();
    }

    public void sendkeyToElement(String locator, String keysToSend) {
        getElement(locator).clear();
        getElement(locator).sendKeys(keysToSend);
    }

    public void sendkeyToElement(String locator, String keysToSend, String... restParams) {
        getElement(getDynamicLocator(locator, restParams)).clear();
        getElement(getDynamicLocator(locator, restParams)).sendKeys(keysToSend);
    }

    public void selectItemInDropdown(String locator, String textItem) {
        new Select(getElement(locator)).selectByVisibleText(textItem);
    }

    public void selectItemInDropdown(String locator, String textItem, String... restParams) {
        new Select(getElement(getDynamicLocator(locator, restParams))).selectByVisibleText(textItem);
    }

    public String getSelectedItemInDropdown(String locator) {
        return new Select(getElement(locator)).getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(String locator) {
        return new Select(getElement(locator)).isMultiple();
    }

    public void selectItemInCustomDropdown(String parentLocator, String childItemLocator, String expectedItem) {
        getElement(parentLocator).click();
        sleepInSeconds(2);

        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).
                until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));
        sleepInSeconds(2);

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                item.click();
                break;
            }
        }

    }

    public String getElementAttribute(String locator, String attributeName) {
        return getElement(locator).getAttribute(attributeName);
    }

    public String getElementAttribute(String locator, String attributeName, String... restParams) {
        return getElement(getDynamicLocator(locator, restParams)).getAttribute(attributeName);
    }

    public String getElementText(String locator) {
        return getElement(locator).getText();
    }

    public String getElementText(String locator, String... restParams) {
        return getElement(getDynamicLocator(locator, restParams)).getText();
    }

    public String getCssValue(String locator, String propertyName) {
        return getElement(locator).getCssValue(propertyName);
    }

    public String getHexaColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public int getListElementNumber(String locator) {
        return getListElement(locator).size();
    }

    public void checkToCheckboxRadio(String locator) {
        if (!getElement(locator).isSelected()) {
            getElement(locator).click();
        }
    }

    public void uncheckToCheckbox(String locator) {
        if (getElement(locator).isSelected()) {
            getElement(locator).click();
        }
    }

    public boolean isElementDisplayed(String locator) {
        return getElement(locator).isDisplayed();
    }

    public boolean isElementDisplayed(String locator, String... restParams) {
        return getElement(getDynamicLocator(locator, restParams)).isDisplayed();
    }

    public boolean isElementSelected(String locator) {
        return getElement(locator).isSelected();
    }

    public boolean isElementSelected(String locator, String... restParams) {
        return getElement(getDynamicLocator(locator, restParams)).isSelected();
    }

    public boolean isElementEnabled(String locator) {
        return getElement(locator).isEnabled();
    }

    public void sleepInSeconds(long timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void switchToIframe(String locator) {
        driver.switchTo().frame(getElement(locator));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void doubleClickToElement(String locator) {
        new Actions(driver).doubleClick(getElement(locator)).perform();
    }

    public void hoverMouseToElement(String locator) {
        new Actions(driver).moveToElement(getElement(locator)).perform();
    }

    public void clickAndHoldToElement(String locator) {
        new Actions(driver).clickAndHold(getElement(locator)).perform();
    }

    public void releaseLeftMouse() {
        new Actions(driver).release();
    }

    public void rightClick(String locator) {
        new Actions(driver).contextClick(getElement(locator)).perform();
    }

    public void dragAndDrop(String locatorSource, String locatorTarget) {
        new Actions(driver).dragAndDrop(getElement(locatorSource), getElement(locatorTarget)).perform();
    }

    public void scrollToElement(String locator) {
        new Actions(driver).scrollToElement(getElement(locator)).perform();
    }

    public void pressKeyToElement(String locator, Keys keys) {
        new Actions(driver).sendKeys(getElement(locator), keys).perform();
    }

    public void uploadSendkeyOneFile(String locator, String path) {
        sendkeyToElement(locator, path);
    }

    public Object executeJavascriptToBrowser(String javaScript) {
        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }

    public Object executeJavascriptToElement(String locator, String javaScript) {
        return ((JavascriptExecutor) driver).executeScript(javaScript, getElement(locator));
    }

    public void scrollToBottomPageByJS() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void scrollToElementByJS(String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void hightlightElement(String locator, String hightlightStyle) {
        String originalStyle = getElement(locator).getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", getElement(locator), hightlightStyle);
        sleepInSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", getElement(locator), originalStyle);
    }

    public void removeAttributeOfElement(String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
    }

    public boolean checkImageLoaded(String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
    }

    public boolean verifyTextInInnerText(String textExpected) {
        String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public String getElementValidationMessage(String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

    public boolean waitToJQueryAndJSLoadedSuccess() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                return (Boolean) ((JavascriptExecutor) driver).executeScript("return (window.jQuery!=null)&&(jQuery.active===0);");
            }
        };
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public void checkCheckboxByJS(String locator) {
        if (!getElement(locator).isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(locator));
        }
    }

    public void uncheckCheckboxByJS(String locator) {
        if (getElement(locator).isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(locator));
        }
    }

    public void waitForElementVisible(String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementVisible(String locator, String... restParams) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, restParams))));
    }

    public void waitForElementPresence(String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementSelected(String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }


    public void waitForElementClickable(String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(element));
    }


    public void waitForElementClickable(String locator, String... restParams) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locator, restParams))));
    }

    public void waitForElementInvisible(String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    // only user with Level_07_Switch_Page_Object
    public AddressPageObject openAddressPage() {
        waitForElementVisible(BasePageUI.ADDRESSES_LINK);
        clickToElement(BasePageUI.ADDRESSES_LINK);
        return PageGenerator.getAddressPage(driver);
    }

    public OrdersPageObject openOrdersPage() {
        waitForElementVisible(BasePageUI.ORDERS_LINK);
        clickToElement(BasePageUI.ORDERS_LINK);
        return PageGenerator.getOrdersPage(driver);
    }

    public DownloadablePageObject openDownloadPage() {
        waitForElementVisible(BasePageUI.DOWNLOADABLE_PRODUCTS_LINK);
        clickToElement(BasePageUI.DOWNLOADABLE_PRODUCTS_LINK);
        return PageGenerator.getDownloadPage(driver);
    }

    public BackInStockPageObject openBackInStockPage() {
        waitForElementVisible(BasePageUI.BACK_IN_STOCK_LINK);
        clickToElement(BasePageUI.BACK_IN_STOCK_LINK);
        return PageGenerator.getBackInStockPage(driver);
    }

    public RewardPointsPageObject openRewardPointsPage() {
        waitForElementVisible( BasePageUI.REWARD_POINTS_LINK);
        clickToElement( BasePageUI.REWARD_POINTS_LINK);
        return PageGenerator.getRewardPointsPage(driver);
    }

    public ChangePasswordPageObject openChangePasswordPage() {
        waitForElementVisible( BasePageUI.CHANGE_PASSWORD_LINK);
        clickToElement(BasePageUI.CHANGE_PASSWORD_LINK);
        return PageGenerator.getChangePasswordPage(driver);
    }

    public MyProductReviewPageObject openMyProductReviewPage() {
        waitForElementVisible(BasePageUI.MY_PRODUCT_REVIEW_LINK);
        clickToElement(BasePageUI.MY_PRODUCT_REVIEW_LINK);
        return PageGenerator.getMyProductReviewPage(driver);
    }

    public CustomerInfoPageObject openCustomerInforPage() {
        waitForElementVisible( BasePageUI.CUSTOMER_INFOR_LINK);
        clickToElement(BasePageUI.CUSTOMER_INFOR_LINK);
        return PageGenerator.getCustomerInfoPageObject(driver);
    }

//    public Boolean isPageLoadedSuccess(WebDriver driver) {
//        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply() {
//                return (Boolean) jsExecutor.executeScript("return (window.jQuery!=null)&&(jQuery.active===0);");
//            }
//        };
//        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply() {
//                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
//            }
//        };
//        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
//
//    }

        public Boolean isPageLoadedSuccess() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                return (Boolean) jsExecutor.executeScript("return (window.jQuery!=null)&&(jQuery.active===0);");
            }
        };
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);

    }



    public By getByLocator(String locatorValue) {
        By by = null;
        if (locatorValue.startsWith("Xpath=") || locatorValue.startsWith("xpath=") || locatorValue.startsWith("XPATH=") || locatorValue.startsWith("XPath=")) {
            by = By.xpath(locatorValue.substring(6));
        } else if (locatorValue.startsWith("ID=") || locatorValue.startsWith("Id=") || locatorValue.startsWith("id=")) {
            by = By.id(locatorValue.substring(3));
        } else if (locatorValue.startsWith("class=") || locatorValue.startsWith("Class=") || locatorValue.startsWith("CLass=")) {
            by = By.className(locatorValue.substring(6));
        } else if (locatorValue.startsWith("css=") || locatorValue.startsWith("CSS=") || locatorValue.startsWith("Css=")) {
            by = By.cssSelector(locatorValue.substring(4));
        } else if (locatorValue.startsWith("Name=") || locatorValue.startsWith("NAME=") || locatorValue.startsWith("name=")) {
            by = By.name(locatorValue.substring(5));
        } else if (locatorValue.startsWith("tagName=") || locatorValue.startsWith("TagName=") || locatorValue.startsWith("Tagname=") || locatorValue.startsWith("tagname=")) {
            by = By.tagName(locatorValue.substring(8));
        } else {
            throw new RuntimeException("Locator type is not valid");
        }
        return by;
    }

    public void uploadMultipleFiles(String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";
        for (String file : fileNames) {
            fullFileName = fullFileName + filePath + file + "\n";
        }
        fullFileName = fullFileName.trim();
        getElement(BasePageUI.UPLOAD_FILE).sendKeys(fullFileName);
    }


    private long longTimeout = GlobalConstants.LONG_TIMEOUT;


}
