import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo18 {
    public static void main(String[] args) {
        writeFile1();
        writeFile2();

    }

    private static void writeFile2() {
        File file = new File("something.txt");
        try {
            file.createNewFile();
            
            //try with resources and these resources close automatically after end of executing try block
            try(FileInputStream fis = new FileInputStream(file)){
                BufferedInputStream bis = new BufferedInputStream(fis);
                String content = "This about to try - Resource Statement";
                bis.read(content.getBytes());
                System.out.println("Saved");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile1(){
        File file = new File("something.txt");
        try {
            file.createNewFile();
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);

            try{
                String content = "This about to try - Resource Statement";
                bis.read(content.getBytes());
                System.out.println("Saved");
            }finally{
                bis.close();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
