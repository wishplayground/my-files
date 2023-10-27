import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientApp {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("192.168.8.101", 9090);//first create client socket
        System.out.println("Connected to server");
        File file = new File("trans.gif");

        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);

        byte[] buffer = new byte[1024];
        int read = -1;
        while((read = bis.read(buffer)) != -1){
            socket.getOutputStream().write(buffer);
        }
        System.out.println("File Successfully uploaded");
        bis.close();
    }
}
