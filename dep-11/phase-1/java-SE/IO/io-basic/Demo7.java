import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Demo7 {
    public static void main(String[] args) {
        
        File file = new File("isometrica-main.psd");
        try {
            FileInputStream fis = new FileInputStream(file);

            /* try{
                byte[] signature = new byte[4];
                fis.read(signature);
                System.out.println(new String(signature));
            }catch(IOException e){
                e.printStackTrace();
            } */

            byte[] bytes = new byte[22];
            fis.read(bytes);
            byte[] h = new byte[4];
            byte[] w = new byte[4];
            int ind = 0;
            int[] hight = new int[4];
            for (int i = 14; i < 14 + h.length; i++,ind++) {
                hight[ind] = bytes[i] & 255;
            }
            int finalCons=0;
            for (int i : hight) {
                finalCons |= i;
            }
            System.out.println(finalCons);
            ind = 0;
            for (int i = 18; i < 18 +w.length; i++,ind++) {
                w[ind] = bytes[i];
            }

            System.out.println(Arrays.toString(h));
            System.out.println(Arrays.toString(w));
            System.out.println();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}
