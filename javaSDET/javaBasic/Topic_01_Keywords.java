package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_01_Keywords {

    //Có các hàm non-abstract
    //Không được chứa các hàm non-abstract

    public void clickToElement(){
        //Có phần thân (body)
    }

    //Dữ liệu nguyên thủy
    char c = 'a';
    byte bNumber = 10;
    short sNumber = 100;
    int iNumber = 1000;
    long lNumber = 10000;
    float fNumber = 15.7f;
    double dNumber = 45.22d;
    boolean bStatus= true;

    //void: ko cần trả về gì hết
    void clickToLoginButton(){

    }
    //Hàm cần trả về kiểu String : bắt buộc phải có return + chỉ return 1 lần
    String getText(){
        return "";
    }

    //Truy cập các hàm

    //Bất kì 1 class nào cũng truy cập đc vào biến này
    public String address = "138 Trần Bình - Mỹ Đình 2 - Nam Từ Liêm - HN";
    //Dùng cho đc cho các class kế thừa class này
    protected String city = "Hà Nội";
    //Chỉ trong class này dùng được
    private String phone = "01233";
    //Chỉ dùng được trong cùng package //Default
    String zipCode = "65000";

    WebDriver driver;
    // Biểu thức điều kiện
    public WebDriver getBrowserDriver (String browserName) {
        if (browserName.equals("firefox")){
            driver = new FirefoxDriver();
        } else if (browserName.equals("chrome")){
            driver = new ChromeDriver();
        } else {
            driver = new EdgeDriver();
        }

        switch (browserName){
            case "firefox":
                driver = new FirefoxDriver();
            case "chrome":
                driver= new ChromeDriver();
            default:
                driver = new EdgeDriver();
        }

        return driver;
    }
}
