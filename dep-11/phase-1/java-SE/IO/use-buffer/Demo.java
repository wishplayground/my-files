import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo{
    public static void main(String[] args) throws IOException {
        
        File file = new File("dep11.txt");

        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);



        try{
            byte[] buf = new byte[1024];
            int read = -1;
            while((read = bis.read(buf))!= -1){
                System.out.println(read);
            }
            //bis.flush();
            
        }finally{
            bis.close();//when close the buffer it defaultly flushed
            fis.close();
        }
    }
}