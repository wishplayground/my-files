package lk.ijse.dep11;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileRead {
    public static void main(String[] args) throws FileNotFoundException {

        File fileRef1 = new File("/home/wishva/Desktop/Paths/io.txt");
        FileInputStream inputStreamFile = new FileInputStream(fileRef1);
        try {
            int read = 0;
            while ((read = inputStreamFile.read()) != -1){
                System.out.print((char) read);
            }
            inputStreamFile.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*Path pathRef = Paths.get("/home/wishva/Desktop/Paths/paths.txt");
        new FileInputStream(pathRef)*/

    }
}
