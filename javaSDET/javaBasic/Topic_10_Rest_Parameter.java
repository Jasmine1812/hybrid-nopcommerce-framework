package javaBasic;

import org.testng.annotations.Test;

public class Topic_10_Rest_Parameter {
    private String topMenu = "//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
    private String menu = "//ul[@class='%s']//a[contains(text(),'%s')]";


    @Test
    public void TC_01(){
        dyamicLocator1Parameter(topMenu, "Computers");
        dyamicLocator1Parameter(topMenu, "Electronics");
        dyamicLocator2Parameter(menu, "top-menu notmobile", "Computers" );
    }

    public void dyamicLocator1Parameter(String locatorValue,String parameter){
        System.out.println(String.format(locatorValue, parameter));
    }
    public void dyamicLocator2Parameter(String locatorValue,String menuType, String parameter){
        System.out.println(String.format(locatorValue, menuType,  parameter));
    }
}
