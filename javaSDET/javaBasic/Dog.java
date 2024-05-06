package javaBasic;

public class Dog extends Annimal {
    String annimalName; //Biến Global

    public Dog(String annimalName) {
        super(annimalName); //Gọi tới Constructor của lớp cha Annimal
        this.annimalName = annimalName;
    }


    @Override
    public void sleep() {
        System.out.println("");
    }
    //Thể hiện tính chất kế thừa trong OOP (Inhieritance)
}
