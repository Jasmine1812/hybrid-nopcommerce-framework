package javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class Topic_02_Loop { //final: Không cho class khác kế thừa nó

    //final ko cho phép gán giá trị mới
    final String PI = "3.14";

    //Hàm static không cần khởi tạo vẫn dùng được, vẫn gọi đc
    public static void clickToButton(){
    }
    //Hàm final k cho phép overide
    public final void clickToElement(){

    }

    public static void main(String[] args){

        Topic_02_Loop.clickToButton();
        Topic_02_Loop topic = new Topic_02_Loop();
        topic.clickToElement();


        System.out.println("For: ");
        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                System.out.println("i trong if: " + i);
            }
            System.out.println(i);
        }

        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                System.out.println("i trong if có break: " + i);
                break;
            }
            System.out.println(i);
        }

        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                continue;
            }
            System.out.println("continue" + i);
        }

        System.out.println("While: ");
        int i = 1;
        while (i < 10){ //Kiểm tra trước
            System.out.println(i); //Action
            i++;
        }

        System.out.println("Do-While");
        i = 1;
        do {
            System.out.println(i); //Thực thi trước
            i++;
        } while (i < 10); //Kiểm tra sau
    }

    public boolean isElementDisplayed(){
        WebDriver driver = new FirefoxDriver();
        WebElement element = driver.findElement(By.cssSelector(""));
        boolean status= false;
        try {
            status = element.isDisplayed();
        } catch (NoSuchElementException exception){
            exception.printStackTrace();
            throw new RuntimeException();
        } finally {
            //Step bắt buộc phải chạy sau try catch
        }

        return status;
    }


}
