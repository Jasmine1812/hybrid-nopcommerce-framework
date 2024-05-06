package javaBasic;

public abstract class Annimal {
    //Thể hiện tính trừu tượng trong OOP (Abstract)

    //Có các hàm non-abstract và abstract

    //abstract
    public abstract void sleep();

    //non-abtract
    public void eat(){
        //Có phần thân
        System.out.println("eating...");
    }
    //Constructor
    public Annimal(String annimalName){
        System.out.println("");
    }
}
