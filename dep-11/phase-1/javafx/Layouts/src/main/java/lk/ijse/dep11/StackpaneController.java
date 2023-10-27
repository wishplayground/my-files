package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class StackpaneController {
    public Circle shapecircle;
    public Arc shpArc;
    public Rectangle shpRectangle;
    public Button btntoFront;

    public void btnTofrontOnAction(ActionEvent event) {
        shapecircle.toFront();
    }
}
