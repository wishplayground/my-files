import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo1{
    public static void main(String[] args) {
        
        File file = new File("readme.txt");
        if(!file.exists()){
            try {
                file.createNewFile();    
            } catch (IOException e) {
                e.printStackTrace();
            }finally{

            }
        }
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            try{
                int read = 0;
                 while(read !=-1){
                    read = fis.read();
                    System.out.print((char)read);
                }
                //System.out.println(read);
            }finally{
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}