import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class Demo7 {
    
    public static void main(String[] args) {
        
        //when needed Local date time to sql date time
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        Date utilDate = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date utilDate2 = Date.from(now.atDate(today).atZone(ZoneId.systemDefault()).toInstant());

        java.sql.Date sqlDate = java.sql.Date.valueOf(today);
        Time time = java.sql.Time.valueOf(now);
        Timestamp timestamp = java.sql.Timestamp.valueOf(LocalDateTime.now());

        System.out.println(utilDate);
        System.out.println(utilDate2);
        System.out.println(sqlDate);
        System.out.println(time);
        System.out.println(timestamp);
    }
}
