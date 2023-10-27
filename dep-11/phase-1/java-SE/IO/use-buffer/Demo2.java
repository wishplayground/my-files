import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        
        String msg = "This is DEp11 we are born to code!! HEll yeah!!!";
        File file = new File("readme.txt");

        FileOutputStream fis = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fis);
        try{
            byte[] b = msg.getBytes();
            bos.write(b);
            bos.flush();
        }finally{
            fis.close();
            bos.close();
        }
    }
}
