public class Demo28 {
    public static void main(String[] args) {

        //String  =====> enum
        WeekDays day = WeekDays.valueOf("FRIDAY");
        System.out.println(day);

        //return array include constants
        WeekDays[] values = WeekDays.values();
        for (WeekDays aDay : values) {
            System.out.println(aDay);
        }

        day = WeekDays.WEDNESDAY;
        System.out.println(day.ordinal());// returns index of constant
        System.out.println(day.name()); //returns identifier of constant

        switch(day){
            case MONDAY:
                System.out.println("MONDAY");
                break;
            
            case TUESDAY:
            
        }

    }
}

enum WeekDays{
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;

}
