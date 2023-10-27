import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class ServerApp{
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9900);
        System.out.println("Server is running");

        while (true) {
            System.out.println("Waiting for connection");
            Socket localSocket = serverSocket.accept();
            System.out.println("Connection Established " + localSocket);
            
            new Thread(() ->{
                try {
                    File file = new File("Uploads", UUID.randomUUID().toString());
                    file.createNewFile();
                    FileOutputStream fos = new FileOutputStream(file);
                    BufferedOutputStream bos = new BufferedOutputStream(fos);


                    InputStream is = localSocket.getInputStream();
                    BufferedInputStream bis = new BufferedInputStream(is);
                    int read = -1;
                    byte[] buffer = new byte[1024];

                    while((read = bis.read(buffer))!= -1){
                        bos.write(buffer,0,read);
                    }
                    bis.close();
                    System.out.println("File Uploaded");


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            
        }
    }
}