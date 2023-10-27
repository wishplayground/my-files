package lk.ijse.dep11;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.util.ArrayList;

public class MainSceneController {
    public TextField txtFolderPath;
    public Button btnBrowse;
    public ProgressBar pbLoader;
    public TilePane tlpImageContainer;
    public AnchorPane Mainroot;

    public void initialize(){
        tlpImageContainer.prefWidthProperty().bind(Mainroot.widthProperty());
        tlpImageContainer.prefHeightProperty().bind(Mainroot.heightProperty());
    }

    public void btnBrowseOnAction(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select Image Directory");
        File imageFile = directoryChooser.showDialog(Mainroot.getScene().getWindow());
        if(imageFile == null){
            txtFolderPath.clear();


        }else {
            txtFolderPath.setText(imageFile.getAbsolutePath());

            File[] files = imageFile.listFiles();
            //Dynemic array
            ArrayList<File> imageFileList = new ArrayList<>();

            for (File file : files) {
                if(!file.isFile() || !isImageFile(file.getAbsolutePath())) continue;//file.isFile check is a file not a directory
                imageFileList.add(file);

            }
            pbLoader.setVisible(true);
            Platform.runLater(() ->{
                tlpImageContainer.getChildren().clear();
                int count = 0;
                for (File image : imageFileList) {
                    Image img= new Image(image.toURI().toString());
                    ImageView imageView = new ImageView(img);
                    imageView.setFitHeight(150);
                    imageView.setFitWidth(150);
                    tlpImageContainer.getChildren().add(imageView);
                    count++;

                    double progress = count/(imageFileList.size() * 1.0);
                    pbLoader.setProgress(progress);
                    pbLoader.setVisible(false);
                }
            });


        }
    }

    public boolean isImageFile(String filePath){
        String[] extensions = {".jpeg",".jpg",".png","gif",".bmp"};
        for (String extension : extensions) {
            if(filePath.endsWith(extension)) return true;
        }
        return false;
    }


}
