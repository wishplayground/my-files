import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) {
        File file = new File("someting.txt");
        try (var fis = new FileReader(file)){
            //byte[] buffer =  new byte[1024];
            int read = -1;
            char[] buffer = new char[1024];
            while((read = fis.read(buffer)) !=-1){
                System.out.print(new String(buffer,0,read));
            }
            System.out.println();

        }catch(IOException e){

        }
    }
}
