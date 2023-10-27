import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Demo3 {
    public static void main(String[] args) {
        

        LocalDate now = LocalDate.now();
        LocalTime now2 = LocalTime.now();
        LocalDateTime now3 = LocalDateTime.now();

        System.out.println(now);
        System.out.println(now2);
        System.out.println(now3);

        LocalDate date = LocalDate.of(2023,9,20);
        LocalTime time = LocalTime.of(15, 20, 42);
        LocalDateTime dateTime = LocalDateTime.of(2023, 5, 25, 19, 51, 23);

        System.out.println("========================");
        //plusxxxx ,  minusxxxx
        LocalDate plusDays = now.plusDays(10);
        System.out.println(plusDays);

        LocalDate plusYears = now.plusYears(4);
        System.out.println(plusYears);

    }
}
