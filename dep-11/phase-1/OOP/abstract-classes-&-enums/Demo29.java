import java.io.*;
import java.util.Scanner;


public class Demo29 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        do{
            String msg;
            do {
                System.out.print("Enter your message: ");
                msg = SCANNER.nextLine();
            } while (msg.isBlank());

            System.out.println();
            System.out.println("1. File");
            System.out.println("2. Console");
            int option;
            do {
                System.out.print("Where do you want to write your message? ");
                option = SCANNER.nextInt(); SCANNER.nextLine();
            } while (option < 1 || option > 2);

            MyWriter writer;

            if (option == 1){
                String filename;
                do {
                    System.out.print("Enter a file name: ");
                    filename = SCANNER.nextLine();
                }while (filename.isBlank());
                writer = new MyFileWriter(filename);
            } else {
                System.out.println("1. RED");
                System.out.println("2. GREEN");
                System.out.println("3. YELLOW");
                System.out.println("4. BLUE");
                int colorOption;
                do {
                    System.out.print("Enter your color option: ");
                    colorOption = SCANNER.nextInt(); SCANNER.nextLine();
                } while (colorOption < 1 || colorOption > 4);
                String[] colors = {"RED", "GREEN", "YELLOW", "BLUE"};
                Color color = Color.valueOf(colors[colorOption - 1]);
                writer = new MyConsoleWriter(color);
            }

            writer.write(msg);
            System.out.println();
        }while (true);
    }
  
}

//Colors
enum Color{
    RED("\033[1;31m"),GREEN("\033[1;32m"),YELLOW("\033[1;33m"),BLUE("\033[1;34m");

    String code;
    Color(String code){
        this.code = code;
    }

    public String getColorCode(){
        return code;
    }
    
}

//Abstract class
abstract class MyWriter{

    public abstract void write(String msg);
}

//MyFile Writer
class MyFileWriter extends MyWriter{
    private File file;
    public MyFileWriter(String fileName){
        this.file = new File(fileName);

    }
    @Override
    public void write(String msg){

        try {
            FileOutputStream fos = new FileOutputStream(file);
            //write byte chunk
            byte[] myByte = msg.getBytes();
            fos.write(myByte);
            /* for (char letter : msg.toCharArray()) {
                fos.write(letter); 
            } */
            System.out.println("File written Successfully");
            fos.close();

        } catch (IOException e) {
            try {
                file.createNewFile();
            } catch (IOException e1) {
                System.out.println("File could not created");
            }
        }
    }

}

//MyConsole Writer
class MyConsoleWriter extends MyWriter{
    private Color color;
    public MyConsoleWriter(Color color){
        this.color = color;
    }

    public void write(String msg){

        System.out.print(color.getColorCode());
        for (char letter: msg.toCharArray()) {
            System.out.print(letter);
            try {
                Thread.sleep(200);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }       
        }
        System.out.print("\033[0m");
        //System.out.printf("%s%s%s","\033",color.getColorCode(),msg,"\033[0m");
    }
}


