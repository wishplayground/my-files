import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Demo5 {
    public static void main(String[] args) {
        
        LocalTime past = LocalTime.of(17, 12, 23);
        LocalTime now = LocalTime.now();

        Duration between = Duration.between(past, now);
        System.out.println(between.toMillis());
        System.out.println(between.toNanos());

        System.out.println();
        System.out.println(ChronoUnit.MINUTES.between(past, now));
    }
}
