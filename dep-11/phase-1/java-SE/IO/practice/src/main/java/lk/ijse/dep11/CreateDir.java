package lk.ijse.dep11;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateDir {
    public static void main(String[] args) {

        File fileRef = new File("/home/wishva/Desktop/BC");
        boolean create =  fileRef.mkdir();
        System.out.println(create ? "File created" : "File Already Exist");

        Path pathRef = Paths.get("/home/wishva/Desktop/Paths");
        try {
            Files.createDirectory(pathRef);
        } catch (FileAlreadyExistsException e){
            System.out.println("File already exist");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path pathRef2 = Paths.get("/home/wishva/Desktop/Paths/paths.txt");
        try {
            Files.createFile(pathRef2);
        }catch (FileAlreadyExistsException e){
            System.out.println("File Already Exist");
        } catch (IOException e) {
            e.printStackTrace();
        }

        File fileRef2 = new File("/home/wishva/Desktop/Paths/io.txt");
        try {
            boolean newFile = fileRef2.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
