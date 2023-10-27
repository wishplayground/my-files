package lk.ijse.dep11.controller;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainViewController {
    public ImageView imvView;
    public Button btnOpen;
    public Button btnSave;
    public AnchorPane root;
    public TextField txtLoad;
    public Button btnLoad;

    public void btnOpenOnAction(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jped", "*.bmp", "*.gif"));
        File imgFile = fileChooser.showOpenDialog(root.getScene().getWindow());
        if(imgFile == null){
            imvView.setImage(null);
            return;
        }
        //imvView.setImage(new Image(imgFile.toURI().toString()));
        BufferedImage bufImage = ImageIO.read(imgFile);
        WritableImage fxImage = SwingFXUtils.toFXImage(bufImage, null);
        imvView.setImage(fxImage);


    }

    public void btnSaveOnAction(ActionEvent event) {
        if (imvView.getImage() == null) return;
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("jpeg","*.jpeg"), new FileChooser.ExtensionFilter("jpg","*.jpg"),
                new FileChooser.ExtensionFilter("png","*.png"),
                new FileChooser.ExtensionFilter("gif","*.gif"));

        File saveFile = fileChooser.showSaveDialog(root.getScene().getWindow());
        String format = ".jpg";
        switch (fileChooser.getSelectedExtensionFilter().getExtensions().get(0)){
            case "*.jpg":
                format = "*.jpg";
                break;
            case "*.jpeg":
                format = "*.jpeg";
                break;
            case "*.png":
                format = "*.png";
                break;
            case "*.gif":
                format = "*.gif";
                break;
        }
        if (saveFile == null) return;
        Image image = imvView.getImage();
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
        new BufferedImage(bufferedImage,bufferedImage.getWidth(),bufferedImage.getHeight(),format.equals("*.jpeg") || format.equals("*.jpg")||)


        try {
            ImageIO.write(bufferedImage,format,saveFile);
            new Alert(Alert.AlertType.INFORMATION,"Image saved!").show();
        } catch (IOException e) {
            new Alert(Alert.AlertType.INFORMATION,"Image Not saved!").show();
            throw new RuntimeException(e);
        }


    }

    public void btnLoadOnAction(ActionEvent event) {
        if(txtLoad.getText().isEmpty()) txtLoad.requestFocus();txtLoad.selectAll();
        try {
            URL url = new URL(txtLoad.getText().strip());
            BufferedImage bufImg = ImageIO.read(url);
            WritableImage fxImage = SwingFXUtils.toFXImage(bufImg, null);
            imvView.setImage(fxImage);
        } catch (IOException e) {
            imvView.setImage(null);
            txtLoad.requestFocus();
            txtLoad.selectAll();
            new Alert(Alert.AlertType.ERROR,"Failed to fetch the image").show();
            throw new RuntimeException(e);


        }

    }
}
