public class test {
    //private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        byte myByte = ~0;
        int myInt = myByte >> 31 - myByte;
        System.out.println(Integer.toBinaryString(myInt).concat("   " + myInt));
        myInt = myInt <<1;
        System.out.println(Integer.toBinaryString(myInt).concat("   " + myInt));
        
    }
}
