public class Demo23{
    public static void main(String[] args) {
        
        byte myByte1 = 0b0000_0101;
        byte myByte2 = 0b0000_0011;

        byte myresult1 = (byte)(myByte1 & myByte2 );
        System.out.println(myresult1);
    }
}