import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo3 {
    public static void main(String[] args) throws IOException {
        File file = new File("something2.txt");
        file.createNewFile();

        try( var fileWrite = new FileOutputStream(file); var bos = new BufferedOutputStream(fileWrite)){
            String content = "fskjnskksvbskbvksnsdknkjndskjv";
            
            bos.write(content.getBytes());
        }

        
    }
}
