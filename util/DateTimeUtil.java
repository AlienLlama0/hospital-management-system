package util;
import java.time.LocalDateTime;

// https://www.w3schools.com/java/java_date.asp
public class DateTimeUtil {
    public static String dateTimeNow(){
        return ""+LocalDateTime.now();
    }
}
