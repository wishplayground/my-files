package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;

public class MAinSceneControler {
    public TextField txtBrows;
    public Button btnBrowse;
    public ImageView imvScreen;
    public AnchorPane rootmain;

    public void btnBrowseOnAction(ActionEvent event) {

        FileChooser fileChooser = new FileChooser(); //open files window

        //chode file extention
        /*fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files","*.txt"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files","*.pdf"));
*/
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.jpeg","*.jpg","*.png","*.bmp","*.gif"));

        //filechooser.setInitialDirectory("path name")
        fileChooser.setTitle("Select am Image File");
        File imageFile =  fileChooser.showOpenDialog(rootmain.getScene().getWindow()); //return openfile address

        //showSaveDialog
        //ShowOpenDialog
        //showOpenMultipleDialog

        if(imageFile !=null){
            txtBrows.setText(imageFile.getAbsolutePath());
            Image image = new Image(imageFile.toURI().toString());
            imvScreen.setImage(image);
        }else {
            txtBrows.clear();
            imvScreen.setImage(null);
        }
    }
}
