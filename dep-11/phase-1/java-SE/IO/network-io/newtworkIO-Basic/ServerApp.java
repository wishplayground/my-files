import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp{
    public static void main(String[] args) throws IOException {
        //server appication
        ServerSocket serverSocket = new ServerSocket(5050);
        System.out.println("Server is Up and Running 5050");
        while (true) {
            System.out.println("Waiting for an Incoming connection");
            Socket localSocket = serverSocket.accept();//access responce and create another socket and divert serversocket to this socket
            System.out.println("Awaaa awaaaa" + localSocket);
            new Thread(() -> {
                try{
                    InputStream is = localSocket.getInputStream();
                    byte[] buffer = new byte[1024];
                    int read = -1;
                    while((read = is.read(buffer)) != -1 ){
                        System.out.println(new String(buffer,0,read));
                    }

                }catch(Exception e) {
                    e.printStackTrace();;
                }
            }).start();
            
        }
        
    }
}