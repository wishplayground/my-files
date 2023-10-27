package lk.ijse.dep11;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class ServerApplication {
    private static String message="";
    private static final List<Socket> clientList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5050);
        try{
            while (true) {
                System.out.println("Waiting for connection");
                Socket clientSocket = serverSocket.accept();
                clientList.add(clientSocket);
                System.out.println("Client connected : " + clientSocket);
                new Thread(()->{
                    try {
                        InputStream inputStream;
                        while (true) {
                            inputStream = clientSocket.getInputStream();
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                            while (true) {
                                byte[] buffer = new byte[1024];
                                int read = bufferedInputStream.read(buffer);
                                if (read == -1) throw new EOFException();
                                message += new String(buffer, 0, read) + "\n";
                                notifyClient(message);
                            }
                        }
                    }catch (EOFException e) {
                        clientList.remove(clientSocket);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            serverSocket.close();
        }

    }
    public static void notifyClient(String message){
        new Thread(()->{
            for (Socket socket : clientList) {
                try {
                    OutputStream os = socket.getOutputStream();
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(os);
                    bufferedOutputStream.write(message.getBytes());
                    bufferedOutputStream.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        }).start();

    }
}
