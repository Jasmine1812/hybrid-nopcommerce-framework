package javaBasic;

import java.util.Scanner;

public class Topic_04_Condition_Exercise_Switch_Case {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String phepToan = scanner.nextLine();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        switch (phepToan) {
            case "+":
                System.out.println(a + b);
                break;
            case "x":
                System.out.println(a * b);
                break;
            default:
                System.out.println("khong co phep toan nay");
                break;
        }
//        int n = scanner.nextInt();
//        switch (n) {
//            case 1:
//                System.out.println("one");
//                break;
//            case 2:
//                System.out.println("two");
//                break;
//            case 4:
//                System.out.println("four");
//                break;
//            case 5:
//                System.out.println("five");
//                break;
//            case 6:
//                System.out.println("six");
//                break;
//            case 7:
//                System.out.println("seven");
//                break;
//            case 8:
//                System.out.println("eight");
//                break;
//            default:
//                System.out.println("So ban nhap chua dung yeu cau");

//
//        int month = scanner.nextInt();
//        switch (month){
//            case 1:
//            case 3:
//            case 5:
//            case 7:
//            case 8:
//            case 10:
//            case 12:
//                System.out.println("thang co 31 ngay");
//                break;
//            case 2:
//                System.out.println("thang co 28 hoac 29 ngay");
//                break;
//            case 4:
//            case 6:
//            case 9:
//            case 11:
//                System.out.println("thang co 30 ngay");
//                break;
//            default:
//                System.out.println("Thang ko hop le");
//                break;
//        }
    }
}
