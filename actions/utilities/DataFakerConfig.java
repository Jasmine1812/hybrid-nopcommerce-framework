package utilities;

import net.datafaker.Faker;

import java.util.Locale;

public class DataFakerConfig {
    Faker faker = new Faker(new Locale("vi", "vi"));
    public static DataFakerConfig getFaker(){
        return new DataFakerConfig();
    }

    public String getFirstName(){
        return faker.name().firstName();
    }
    public String getLastName(){
        return faker.name().lastName();
    }
    public String getEmail(){
        return faker.internet().emailAddress();
    }
    public String getPassword(){
        return faker.internet().password(6,12,true);
    }

    public String getCompany() {
        return faker.company().name();
    }

    public String getDay() {
        return String.valueOf(faker.number().numberBetween(1,31));
    }

    public String getYear() {
        return String.valueOf(faker.number().numberBetween(1960,2005));
    }
}
