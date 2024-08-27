package pageObjects.saucedemo;

import commons.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.sauce.ProductsPageUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ProductsPageObject extends BaseElement {
    private WebDriver driver;

    public ProductsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isProductNameSortByAscending() {
        //B1: lay het Product Name luu lai
        List<WebElement> allProductNameText = getListElement(ProductsPageUI.PRODUCT_NAME_TEXT);

        List<String> actualProductName = new ArrayList<String>();
        for (WebElement productName : allProductNameText) {
            actualProductName.add(productName.getText());
        }
        logArrayList(actualProductName);

        //B2: Clone data tu b1 ra thanh du lieu moi
        List<String> expectProductName = new ArrayList<String>();
        for (String name : actualProductName) {
            expectProductName.add(name);
        }
        //B3: Cho sort du lieu o buoc 2
        Collections.sort(expectProductName);
        logArrayList(expectProductName);

        //B4: Verify du lieu truoc va sau sort
        return actualProductName.equals(expectProductName);
    }

    public void selectSortDropdown(String sort) {
        waitForElementClickable(ProductsPageUI.PRODUCT_SORT_DROPDOWN);
        selectItemInDropdown(ProductsPageUI.PRODUCT_SORT_DROPDOWN, sort);
    }

    public void logArrayList(List<String> products) {
        System.out.println("=============================");
        for (String product : products) {
            System.out.println(product);
        }
    }

    public boolean isProductNameSortByDescending() {
        List<WebElement> allProductNameText = getListElement(ProductsPageUI.PRODUCT_NAME_TEXT);

        List<String> actualProductName = allProductNameText.stream().map(n -> n.getText()).collect(Collectors.toList());
        List<String> expectproductName = new ArrayList<String>(actualProductName);
        Collections.sort(expectproductName);
        Collections.reverse(expectproductName);
        return actualProductName.equals(expectproductName);
    }

    public boolean isProductPriceSortAscending() {
        List<WebElement> allProduct = getListElement(ProductsPageUI.PRODUCT_PRICE_TEXT);
        List<Float> actualProductPrice = new ArrayList<Float>();
        for (WebElement name:allProduct){
            actualProductPrice.add(Float.valueOf(name.getText().replace("$","")));
        }
        List<Float> expectProductPrice = new ArrayList<Float>(actualProductPrice);
        Collections.sort(expectProductPrice);
        return actualProductPrice.equals(expectProductPrice);
    }

    public boolean isProductPriceSortDescending() {
        List<WebElement> allProduct = getListElement(ProductsPageUI.PRODUCT_PRICE_TEXT);
        List<Float> actualProductPrice = new ArrayList<Float>();
        for (WebElement name:allProduct){
            actualProductPrice.add(Float.valueOf(name.getText().replace("$","")));
        }
        List<Float> expectProductPrice = new ArrayList<Float>(actualProductPrice);
        Collections.sort(expectProductPrice);
        Collections.reverse(expectProductPrice);
        return actualProductPrice.equals(expectProductPrice);
    }

    public Date convertStringToDate(String dateInString){
        dateInString = dateInString.replace(",","");
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy");
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public boolean isDataDateSortedAscending(String locator){
        ArrayList<Date> actualList = new ArrayList<Date>();
        List<WebElement> elementList = driver.findElements(By.xpath(locator));
        for (WebElement element: elementList){
            actualList.add(convertStringToDate(element.getText()));
        }
        ArrayList<Date> sortedList = new ArrayList<Date>();
        for (Date child: actualList){
            sortedList.add(child);
        }
        Collections.sort(sortedList);
        return sortedList.equals(actualList);
}
}
