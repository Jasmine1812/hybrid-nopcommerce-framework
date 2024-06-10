package javaBasic;

public class Topic_06_Array {
    public static void main(String[] args) {
        int a[] = {2, 5, 7, 2, 1, 14, 9, 3, 5};
        int x = 0;
        for (int i = 0; i < a.length; i++) {
            if (x < a[i]) {
                x = a[i];
            }
        }
        System.out.println(x);
        System.out.println(a[0] + a[a.length - 1]);
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0){
                System.out.println(a[i]);
            }
        }
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        System.out.println("Tong bang: " + sum);
        System.out.println("TBC: " + sum/a.length);
    }


}
