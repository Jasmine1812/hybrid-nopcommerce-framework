package commons;

import java.util.Random;

public class BaseTest {
    protected int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(99999);
    }
}
