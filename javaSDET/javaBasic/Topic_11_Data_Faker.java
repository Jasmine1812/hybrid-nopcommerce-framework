package javaBasic;

import net.datafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

public class Topic_11_Data_Faker {
    Faker faker = new Faker(new Locale("vi"));
    @Test
    public void TC_01(){
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.country().name());
        System.out.println(faker.cat().name());
    }
}
