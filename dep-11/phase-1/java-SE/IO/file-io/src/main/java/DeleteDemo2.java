import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;

public class DeleteDemo2 {

    public static void main(String[] args) {
        File fileRef = new File("/home/wishva/Desktop/born-to-code");
        if(fileRef.isDirectory()){
            File[] files = fileRef.listFiles();
            for (File file : files) {
                file.delete();
            }
            fileRef.delete();
        }

        Path pathRef = Paths.get("/home/wishva/Desktop/New Folder");
        if(Files.isDirectory(pathRef)){
            try {
                DirectoryStream<Path> paths = Files.newDirectoryStream(pathRef);
                for (Path path : paths) {
                    Files.delete(path);
                    System.out.println(path + "   Deleted");
                }
                System.out.println(pathRef + " is Deleted");
                Files.delete(pathRef);
            } catch (FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Exception");
                e.printStackTrace();
            }
        }
    }
}
