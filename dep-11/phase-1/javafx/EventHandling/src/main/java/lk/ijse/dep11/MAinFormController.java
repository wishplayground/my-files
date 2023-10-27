package lk.ijse.dep11;

        import javafx.fxml.FXML;
        import javafx.scene.Cursor;
        import javafx.scene.control.Button;
        import javafx.scene.control.TextField;
        import javafx.scene.image.ImageView;
        import javafx.scene.layout.AnchorPane;

public class MAinFormController {

    public ImageView imgNic;
    @FXML
    private Button btnValidate;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtNic;


    public void initialize(){
        btnValidate.setOnMouseClicked(e -> {
            System.out.println("Click kala....!");
        });

        txtNic.setOnKeyPressed(e -> {
            System.out.println("Ebuwa");
        });
        txtNic.setOnKeyReleased(e ->{
            System.out.println("Issuwa");
        });
        root.setCursor(Cursor.NONE);
        root.setOnMouseMoved(e ->{
            imgNic.setLayoutX(e.getX() - imgNic.getFitWidth()/2);
            imgNic.setLayoutY(e.getY() - imgNic.getFitHeight()/2);
        });
    }

}
