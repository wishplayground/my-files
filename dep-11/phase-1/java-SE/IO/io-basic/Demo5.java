import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo5 {
    public static void main(String[] args) {
        
        String msg = "Input Output Basic";

        File file = new File("readme2.txt");
        
        try {
            if(!file.exists()) file.createNewFile();
            byte[] bytes = msg.getBytes();
            FileOutputStream  fos = new FileOutputStream(file);
            for (byte b : bytes) {
                fos.write(b);
            }
            fos.close();
        } catch (IOException e) {
        
            e.printStackTrace();
        } finally{
            
        }   

    }
}
