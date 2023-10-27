import java.io.*;
public class Demo1{
    public static void main(String[] args) {
        File file = new File("readme.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            int read = 0;
            while((read = fis.read()) != -1){
                System.out.print((char)read);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}