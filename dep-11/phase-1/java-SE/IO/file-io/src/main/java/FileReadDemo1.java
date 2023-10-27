import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReadDemo1 {
    public static void main(String[] args) throws FileNotFoundException {
        File fileRef = new File("/home/wishva/Desktop/execelent/something.txt");
        FileInputStream inputStream = new FileInputStream(fileRef);
        System.out.println(fileRef.exists());
        try {
            int read = 0;
            int total =0;
            while (read != -1){
                read = inputStream.read();//number of bytes read
                System.out.print(Integer.toBinaryString(read));
                total++;
            }
            System.out.println("Total bytes read = " + total);


            inputStream.close();
        } catch (IOException e) {
            System.out.println("Failed to complete reading Process");
            e.printStackTrace();
        }
    }
}
