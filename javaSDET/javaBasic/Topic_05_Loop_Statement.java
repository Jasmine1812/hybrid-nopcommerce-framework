package javaBasic;

import java.util.Scanner;

public class Topic_05_Loop_Statement {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
//        int i = 1;
//        while (n > 0) {
//            i *= n;
//            n--;
//        }
        for (int i =1; n > 0; n --){
            i *= n;

            System.out.println(i);
        }

//        int m = scanner.nextInt();
//        while (n < m) {
//            if (n % 3 == 0 && n % 5 == 0) {
//                System.out.println(n);
//            }
//            n++;
//        }
//        while (n <= 100){
//            if (n%2 == 0){
//                System.out.println(n);
//            }
//            n++;
//        }
//        do {
//            if (n % 2 == 0) {
//                System.out.println(n);
//            }
//            n++;
//        } while (n <= 100);

//        Bai 1
//      int n = scanner.nextInt();
//      for (int i = 0; i <= n; i++){
//          System.out.print(i + " ");
//      }

//        Bai 2
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        if (a <= b){
//            for (int i = a; i <= b; i++){
//                System.out.print(i + " ");
//            }
//        } else {
//            for (int i = b; i <= a; i++){
//                System.out.print(i + " ");
//            }
//        }

    }
}
