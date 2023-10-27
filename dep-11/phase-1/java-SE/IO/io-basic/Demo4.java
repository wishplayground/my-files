import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo4 {
    // canbe use only for small size files
    public static void main(String[] args) {
        File file = new File("readme.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            long t1 = System.currentTimeMillis();
            FileInputStream fis = new FileInputStream(file);
            //byte[] buffer1 = new byte[(int)file.length()];
            byte[] buffer = new byte[fis.available()];
            buffer =  fis.readAllBytes();  //since java 9 we can use readAllBytes for small size file reading like KB range
            System.out.println(new String(buffer));
            long t2 = System.currentTimeMillis();
            System.out.println("Difference is " +(t2 - t1));
            fis.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}
