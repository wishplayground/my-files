import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFileDemo {

    public static void main(String[] args) {

        File fileRef = new File("/home/wishva/Desktop/born-to-code");

        if(fileRef.isDirectory()){
            File[] fileList = fileRef.listFiles();
            for (File file: fileList) {
                System.out.println(file);

            }
        }
        System.out.println("---------------------------------");
        Path pathRef = Paths.get("/home/wishva/Desktop/born-to-code");
        if(Files.isDirectory(pathRef)){
            try {
                DirectoryStream<Path> paths = Files.newDirectoryStream(pathRef);
                for (Path path : paths) {
                    System.out.println(path);
                }
            } catch (IOException e) {
                System.out.println("Exception ekak awoo");
                e.printStackTrace();
            }


        }
    }
}
