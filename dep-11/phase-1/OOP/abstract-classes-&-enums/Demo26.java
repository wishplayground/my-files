public class Demo26 {
    public static void main(String[] args) {
        Months month = Months.feb;
        month.print();

        /* System.out.println(month.feb);
        System.out.println(month.id);
        System.out.println(month.name); */
        //MonthsClone mon = MonthsClone.jan;
        // System.out.println(MonthsClone.jan);
        
    }
}

enum Months{ // cannot extends further
    jan(1, "January"),feb(2,"February"),mar(3,"March"),apr(4,"April"),may(5,"may"),june(6, "June");
    int index;
    String name;

    Months(int index,String name){
        
        this.index = index;
        this.name = name;
    }

    public void print(){
        System.out.printf("month = %s - %s",index,name);
    }

    /*public static void myMethod2(){
        
    }
    public static void main(String[] args) {
        
    } */

    
}

/* class MonthsClone{
    //constructor execute each time when initilizing stage
    public static final MonthsClone jan = new MonthsClone();
    public static final MonthsClone feb = new MonthsClone();
    public static final MonthsClone mar = new MonthsClone();
    public static final MonthsClone apr = new MonthsClone();
    public static final MonthsClone may = new MonthsClone();

    private String fildName;
    private static int count;

    {
        fildName = MonthsClone.class.getDeclaredFields()[count++].getName();
    }
    private MonthsClone(){
        System.out.println("Months clone constructor");
    }

    @Override
    public String toString(){
        return  fildName;
    }
} */
