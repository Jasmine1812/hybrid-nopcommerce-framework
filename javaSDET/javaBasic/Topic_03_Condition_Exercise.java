package javaBasic;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_03_Condition_Exercise {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a >= b) {
            System.out.println(a + " lon hon hoac bang " + b);
        } else {
            System.out.println(b + " lon hon " + a);
        }

        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();

        if (firstName.equals(secondName)){
            System.out.println("Ten giong nhau");
        } else System.out.println("Khac nhau");
    }

//    @Test
//    public void Test_01() {
//        int n = scanner.nextInt();
//        if (n % 2 == 0) {
//            System.out.println(n + " la so chan");
//        } else {
//            System.out.println(n + " la so le");
//        }
//    }
//
//    @Test
//    public void Test_02() {
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        if (a >= b) {
//            System.out.println(a + " lon hon hoac bang "+ b);
//        } else {
//            System.out.println(b + " lon hon "+ a);
//        }
//    }
}
