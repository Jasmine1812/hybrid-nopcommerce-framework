package javaBasic;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Topic_09_Dynamic_Locator {

    @Test
    public void TC_01() {
        String locatorValue = "Xpath=//input[@id='email']";
        System.out.println(getByLocator(locatorValue));
        locatorValue = "Id=email";
        System.out.println(getByLocator(locatorValue));
        locatorValue = "Name=firstname";
        System.out.println(getByLocator(locatorValue));
        locatorValue = "Css=input[id='email']";
        System.out.println(getByLocator(locatorValue));
        locatorValue = "Class=age";
        System.out.println(getByLocator(locatorValue));
        locatorValue = "tagname=input";
        System.out.println(getByLocator(locatorValue));
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


}
