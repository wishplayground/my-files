package lk.ijse.dep11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;

public class Deletedir {
    public static void main(String[] args) {
        File fileRef1 = new File("/home/wishva/Desktop/Paths/io.txt");
        boolean deleted = fileRef1.delete();
        System.out.println(deleted ? "File Deleted" : "File not found");

        Path pathRef1 = Paths.get("/home/wishva/Desktop/Paths/abc.txt");
        try {
            Files.delete(pathRef1);
        } catch (NoSuchFileException e){
            System.out.println("File not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
