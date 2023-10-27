package lk.ijse.dep11;

import javax.imageio.IIOException;
import java.io.*;

public class FileWrite {
    public static void main(String[] args) throws FileNotFoundException {
        File fileSrc = new File("/home/wishva/Desktop/Paths/io.txt");
        File fileTar = new File("/home/wishva/Desktop/Paths/paths.txt");

        FileInputStream fis = new FileInputStream(fileSrc);
        FileOutputStream fos = new FileOutputStream(fileTar);

        try {
            int read = 0;
            while((read = fis.read()) != -1){
                fos.write(read);
            }
            fis.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
