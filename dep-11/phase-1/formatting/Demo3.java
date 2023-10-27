public class Demo3 {
    public static void main(String[] args){
        int id1 = 24, id2 = 67;
        double avgnum1 = 67.19745, avgnum2 = 88.97621;
        String nid = "ID", nName = "Name",mrks = "Marks",mystr = "Kasun tharanga", str2 = "Dhanushka wishvanath";

        System.out.println("+-------+--------------------+--------+");
        System.out.printf("|%-7s|%-20s|%-8s|\n",nid,nName,mrks);
        System.out.printf("|STU-%03d|%-20s|%- 8.2f|\n",id1,mystr,avgnum1);
        System.out.printf("|STU-%03d|%-20s|%- 8.2f|\n",id2,str2,avgnum2);
    }
}
