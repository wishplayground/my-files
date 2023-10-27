import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Demo4 {
    public static void main(String[] args) {
        /* File file = new File("something2.txt");
        try(var fos = new FileOutputStream(file); var bos = new BufferedOutputStream(fos)) {
            file.createNewFile();

            String content = "This is Content to write";
            bos.write(content.getBytes());
            bos.flush();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } */

        File file = new File("something2.txt");
        try(var fos = new FileWriter(file); var bos = new BufferedWriter(fos)) {
            file.createNewFile();
            String content = "This is Content to write";
            bos.write(content);
            bos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
