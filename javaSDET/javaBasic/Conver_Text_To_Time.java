package javaBasic;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Conver_Text_To_Time {

    @Test
    public void Conver_Second_Into_hhmmss() {
        float second1 = Float.valueOf("4344.0");
        int seconds = (int) second1;
        Duration dur = Duration.ofSeconds(seconds);
        if (dur.toHours()>9) {
            String formatted = String.format("%02d:%02d:%02d", dur.toHours(), dur.toMinutesPart(), dur.toSecondsPart());
            System.out.println(formatted);
        } else if (dur.toHours()>0 &&  dur.toHours() <=9){
            String formatted = String.format("%d:%02d:%02d", dur.toHours(), dur.toMinutesPart(), dur.toSecondsPart());
            System.out.println(formatted);
        } else if (dur.toHours()<=0 ){
            String formatted = String.format("%02d:%02d",  dur.toMinutesPart(), dur.toSecondsPart());
            System.out.println(formatted);
        }

    }
}
