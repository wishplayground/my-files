import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo6 {
    public static void main(String[] args) {
        //suitable far small size files
        String msg = "Input Output Basic shbdjfs  ksfnksnjfs fskd fnsdkfns fk nsk fskf ksnf kjdnsfkjnsdf";

        File file = new File("readme2.txt");
        
        try {
            if(!file.exists()) file.createNewFile();
            byte[] bytes = msg.getBytes();
            FileOutputStream  fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.close();
        } catch (IOException e) {
        
            e.printStackTrace();
        } finally{
            
        }   

    }
}
