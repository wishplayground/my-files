public class Excersice1 {
    public static void main(String[] args) {
        int id1 = 001;
        String name1 = "Kasun";
        String address1 = "colombo";

        int id2 = 002;
        String name2 = "Maleesha";
        String address2 = "kalutara";

        String color = "\033[35;1m";
        String reset = "\033[30;0m";

        System.out.println("+-------+----------+----------+");
          System.out.printf("|   %1$sID%2$s  |   %1$sNAME%2$s   |  %1$sADDRESS%2$s |\n",color,reset );
          System.out.print("+-------+----------+----------+\n");
          System.out.printf("|   %s   |   %s  |  %s |\n",id1,name1,address1);
          System.out.printf("|   %s   | %s | %s |\n",id2,name2,address2);
          System.out.println("+-------+----------+----------+");
        //System.out.printf("id =%s id1, name =%s name1, address =%s address1",id1,name1,address1);
    }
}
