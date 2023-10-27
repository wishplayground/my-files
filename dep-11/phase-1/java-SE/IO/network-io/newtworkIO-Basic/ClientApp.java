import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientApp {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost",5050);
        System.out.println("Connected to the server");
        while(true){
            System.out.print("Enter a message: ");
            String msg = scanner.nextLine();
            socket.getOutputStream().write(msg.getBytes());

        }
        
    }
}
