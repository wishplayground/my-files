import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteFileDemo {

    public static void main(String[] args) {

        File file = new File("/home/wishva/Desktop/dep11");
        boolean deleted = file.delete();
        System.out.println(deleted ? "Folder deleted" : "Folder does not exist");

        File fileRef2 = new File("/home/wishva/Desktop/ijse");
        deleted = fileRef2.delete();
        System.out.println(deleted ? "Folder deleted" : "Folder does not exist");

        File fileRef3 = new File("/home/wishva/Desktop/born-to-code");
        deleted = fileRef2.delete();//folder can't delete because it contains files inside
        System.out.println(deleted ? "Folder deleted" : "Folder can't delete");

        Path pathRef = Paths.get("/home/wishva/Desktop/born-to-code");
        try {
            Files.delete(pathRef);
        } catch (DirectoryNotEmptyException e){
            System.out.println("Folder can't be deleted when in contains files");
        } catch (IOException e) {
            System.out.println("Exception ekak awoo");
            e.printStackTrace();
        }

    }
}
