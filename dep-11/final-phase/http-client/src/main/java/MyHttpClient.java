import java.io.*;
import java.net.Socket;

public class MyHttpClient {
    public static void main(String[] args) {
        try{
            Socket remoteSocket = new Socket("172.93.133.117", 80);
            System.out.println("Connected to apache web server");
            new Thread(()->{
                try {
                    InputStream inputStream = remoteSocket.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                    String line;
                    while ((line = bufferedReader.readLine()) != null){
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();

            OutputStream outputStream = remoteSocket.getOutputStream();
            //Apache web server do not accept every message it requires a format
            //No response from server
            //outputStream.write("Hello appache".getBytes());

            //Bad request
            /*outputStream.write("GET / HTTP/1.1".getBytes());
            outputStream.write("HOST: localhost".getBytes());
            outputStream.write("\n\n".getBytes());*/

            outputStream.write("GET /new/1.png HTTP/1.1\r\n".getBytes());
            outputStream.write("HOST: ijse.lk\r\n".getBytes());
            outputStream.write("\r\n".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
