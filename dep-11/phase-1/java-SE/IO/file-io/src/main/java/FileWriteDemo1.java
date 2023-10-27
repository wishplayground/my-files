import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriteDemo1 {
    public static void main(String[] args) throws FileNotFoundException {
        File fileRef = new File("/home/wishva/Desktop/dep11.txt");
        //first create empty file
        try {
            fileRef.createNewFile();
        } catch (IOException e) {
            System.out.println("Failed to create the file");
            e.printStackTrace();
            return;
        }

        FileOutputStream fileOutputStream = new FileOutputStream(fileRef);

        try {
            String str = "Hello this is my fist experience with byte streams\nThis is first attempt";
            //convert string to byte
            byte[] bytes = str.getBytes();
            for (byte b : bytes) {
                fileOutputStream.write(b);
            }
            System.out.println("Write completed");
            fileOutputStream.close();//must add at the end of stream
        } catch (IOException e) {
            System.out.println("Failed to write the file");
            e.printStackTrace();
            return;
        }



    }
}
