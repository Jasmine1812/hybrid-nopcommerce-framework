package javaBasic;

import org.testng.annotations.Test;

import java.io.File;

public class Topic_08_String {

    @Test
    public void TC_01() {
        String filePath = System.getProperty("user.dir") + File.separator + "uploadFiles" + File.separator + "image01.jpg";
        System.out.println(filePath);
        String studentName = new String("Nguyen Thi Tuoi 10/04/1991");
        char newStudentName[] = studentName.toCharArray();
        int count = 0;
        for (char i : newStudentName) {
            if (i >= 'A' && i <= 'Z'){
                count++;
            }
        }
        System.out.println(count);

        int countLow = 0;
        for (char i : newStudentName) {
            if (i >= 'a' && i <= 'z'){
                countLow++;
            }
        }
        System.out.println(countLow);

        int countNumber = 0;
        for (char i : newStudentName) {
            if (i >= '0' && i <= '9'){
                countNumber++;
            }
        }
        System.out.println(countNumber);
//        String accountName = "Jasmine Nguyen 11 22 33 44";
//        int number = 1122;
//        String stringNumber = String.valueOf(number);
//        System.out.println(stringNumber);
//
//        String a = "112";
//        int newA = Integer.parseInt(a);

//        System.out.println(studenName.trim());
//        String[] newStudent = studenName.split(" ");
//        System.out.println(newStudent[0]);
//        int index = studenName.indexOf("Th");
//        System.out.println(index);
//        String sub = studenName.substring(7,12);
//        System.out.println(sub);
//        String newString = studenName.replace(" Thi ", " Hong ");
//        System.out.println(newString);
//        System.out.println("Do dai chuoi: " + studenName.length());
//        char partAccountName = accountName.charAt(3);
//        System.out.println(partAccountName);
//        System.out.println("Noi chuoi: " + accountName.concat(studenName));
//        System.out.println(studenName.equals(accountName));
//        System.out.println(studenName.equalsIgnoreCase(accountName));
//        System.out.println(studenName.startsWith("Ng"));
//        System.out.println(studenName.endsWith("ab"));
//        System.out.println(studenName.contains("Tu"));


    }

    @Test
    public void TC_02(){
        String string = "Automation Testing 345 Tutorials Online 789";
        char newChar[] = string.toCharArray();
        int countA = 0;
        for (char i : newChar){
            if (i == 'a'){
                countA++;
            }
        }
        System.out.println(countA);
        System.out.println(string.contains("Testing"));

    }
}
