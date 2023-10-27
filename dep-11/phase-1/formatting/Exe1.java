public class Exe1 {
    public static void main(String[] args) {

        int id1 = 12, id2 = 13, id3 = 15;
        String name1 = "Kasun sampath", name2 = "mathusha", name3 = "binura";
        double avgmrks1 = 68.1646, avgmarks2 = 75.46646, avgmarks3 = 86.38721;
        
        String line = "+%6s+%1$15s+%1$8s+\n", record ="|SK-%03d|%-15s|%8.2f|\n" ; //fla "-" alight text to left


        System.out.printf(line,"");
        System.out.printf(record,id1,name1,avgmrks1);
        System.out.printf(line,"");
        System.out.printf(record,id2,name2,avgmarks2);


    }
}
