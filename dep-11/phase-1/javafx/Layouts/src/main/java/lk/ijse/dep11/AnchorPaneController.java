package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class AnchorPaneController {
    public Button btnClick;
    public AnchorPane AnchorRoot;

    public void btnClickOnAction(ActionEvent event) {
        double x = Math.random() * AnchorRoot.getWidth();
        double y = Math.random() * AnchorRoot.getHeight();

        btnClick.setLayoutX(x);
        btnClick.setLayoutY(y);


    }
}
