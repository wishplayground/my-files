package lk.ijse.dep11;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Exist {

    public static void main(String[] args) {
        File fileRef = new File("/home/wishva/Desktop/A");

        Path pathRef = Paths.get("/home/wishva/Desktop/BC");
        System.out.println(fileRef.exists());
        System.out.println(Files.exists(pathRef));
    }
}
