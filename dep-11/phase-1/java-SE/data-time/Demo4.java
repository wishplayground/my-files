import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Demo4 {
    public static void main(String[] args) {
        //Range between days
        LocalDate bdayDate = LocalDate.of(1998, 7, 9);
        LocalDate now = LocalDate.of(2023, 10, 16);

        Period rangPeriod = Period.between(bdayDate, now);
        System.out.print(rangPeriod.getYears() + " ");
        System.out.print(rangPeriod.getMonths() +" ");
        System.out.println(rangPeriod.getDays());
        System.out.println();
        System.out.println(ChronoUnit.MONTHS.between(bdayDate, now));
        System.out.println(ChronoUnit.WEEKS.between(bdayDate, now) );
    }
}
