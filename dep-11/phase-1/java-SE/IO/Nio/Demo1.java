import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo1{
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("something.txt");
        try(FileInputStream fis = new FileInputStream(file); BufferedInputStream bis = new BufferedInputStream(fis)){
            var buffer = new byte[1024];
            
            
        }
    }
}