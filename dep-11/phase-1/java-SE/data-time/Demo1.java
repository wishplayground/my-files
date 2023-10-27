import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class Demo1{
    public static void main(String[] args) {
        //local date time means date time relative to local computer

        //java.util.date
        //java.sql.Date, java.sql.Time, java.sql.TimeStamp
        //Calender
        // when meet above old date time convert to below and then manipulate 

        //Since java 8 new one and is easy
        //Local date, Local Time, LocalDateTime

        Date utilDate = new Date();
        System.out.println(utilDate);//shows date and time and time zone. represent in same instance

        Date utilDate2 = Calendar.getInstance().getTime();
        System.out.println(utilDate2);

        LocalDate localDate1 = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();     //convert to instant
        LocalTime localTime = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();;
        LocalDateTime localDateTime = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();;
        System.out.println(localDate1);
        System.out.println(localTime);
        System.out.println(localDateTime);


    }
}