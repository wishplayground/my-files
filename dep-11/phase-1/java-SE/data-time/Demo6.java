import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class Demo6 {
    public static void main(String[] args) {
        
        LocalDateTime now = LocalDateTime.now();
        /* DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy/MM/dd hh-mm-ss");
        String format = pattern.format(now);
        System.out.println(format); */

        DateTimeFormatter pattern1 = DateTimeFormatter.ofPattern("yyyy LLLL dd (EE) hh-mm-ss");
        String format1 = pattern1.format(now);
        System.out.println(format1);

        TemporalAccessor parse = pattern1.parse(format1);
        LocalDate date = LocalDate.parse(format1,pattern1);
        LocalTime time = LocalTime.parse("12:16:56",DateTimeFormatter.ofPattern(format1));
        System.out.println(parse);
        System.out.println(date);
        //System.out.println(time);
    }
}
