import java.io.*;
import java.util.Arrays;
public class Demo2{
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
            byte[] buffer = new byte[1024];//read 1KB at a time.if content lower than 1 KB it for rest of the bite aray it outputs 0
            int read= 0;
            while((read = fis.read(buffer)) != -1){
                System.out.print(new String(buffer,0,read)); //convert string only readed bytes
            }
            long t2 = System.currentTimeMillis();
            System.out.println("Difference is " +(t2 - t1));
            fis.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}