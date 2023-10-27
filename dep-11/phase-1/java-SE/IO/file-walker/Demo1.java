import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo1{
    public static void main(String[] args) {
        String filestr = "/home/wishva/Documents";
        Path pathRef = Paths.get(filestr);

        try {
            Files.walkFileTree(pathRef, new MyFileVisitor().);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

