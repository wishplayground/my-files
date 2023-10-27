import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateDirectoryDemo {

    public static void main(String[] args) {



        File file = new File("/home/wishva/Desktop/mydir");
        boolean created = file.mkdir();//create directory
        System.out.println(created ? "Folder created" : "Folder already Exist");

        Path path = Paths.get("/home/wishva/Desktop/ijse"); //point file
        try {
            Files.createDirectory(path);//this is a risky method     //create directory
            System.out.println("Directory Created");
        }catch (FileAlreadyExistsException e){
            System.out.println("Directory already exist");
        } catch (IOException e) {
            System.out.println("IO awaaa....");
            e.printStackTrace();
        }

    }
}
