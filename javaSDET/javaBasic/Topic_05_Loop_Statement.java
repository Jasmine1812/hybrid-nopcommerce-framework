package javaBasic;

import java.util.Scanner;

public class Topic_05_Loop_Statement {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Bai 7
//        int n = scanner.nextInt();
//        for (int i = 0; i < n; i++) {
//            i == i+ *i;
//        }

        //Bai 6
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i = a; i <= b; i++){
            if (i%3 == 0){
                System.out.print(i);
            }
        }
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
