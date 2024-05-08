package javaOOP;

public class Cat extends Annimals {
    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println(cat.annimalAge);
        cat.annimalAge = 6;
        cat.annimalColor = "Red";
    }
}
