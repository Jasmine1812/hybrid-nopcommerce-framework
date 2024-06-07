package javaException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryCatchException {
    public static void main(String[] args) {

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("C://tes7t1.docx");
            outputStream.write(11);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        int number = 10;
//        try {
//            number = number/0;
//        } catch (ArithmeticException e){
//            System.out.println("chia cho 0");
//        }
//        System.out.println("Tuoi test");
//        try {
//            int array[] = new int[11];
//            array[12] = 30 / 1;
//        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e){
//            e.printStackTrace();
//        }


        }
    }
