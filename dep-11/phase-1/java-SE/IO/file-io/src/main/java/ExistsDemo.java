import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExistsDemo {
    public static void main(String[] args) {
        //Using File
        File file = new File("/home/wishva/Desktop/abc.txt");//ctrl + l to select directory address from files
        System.out.println(file.exists());

        //Using Path
        Path path = Paths.get("/home/wishva/Desktop/abc.txt");
        System.out.println(Files.exists(path));


    }
}
