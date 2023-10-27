package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainSceneController {
    public ToggleButton tglVisibility;
    public ToggleButton tglDisability;
    public ToggleButton tglTooltip;
    public Button btnFocus;
    public RadioButton rbDefault;
    public RadioButton rbHand;
    public TextField txtsomthing;
    public Label lblOutput;
    public CheckBox chkBackground;
    public ColorPicker clrBackground;
    public CheckBox chkBorderWidth;
    public Spinner<Integer> spnBorderWidth;
    public Rectangle shpRect;
    public Slider slrOpacity;
    public Label lblValue;
    public ColorPicker clrBorder;
    public Label lblWidth;
    public AnchorPane root;

    public void initialize(){
        spnBorderWidth.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,1));
        tglTooltip.fire();
        chkBackground.setSelected(false);
        chkBackground.fire();
        chkBorderWidth.setSelected(false);
        chkBorderWidth.fire();
        rbDefault.setSelected(true);
        spnBorderWidth.valueProperty().addListener(e ->{
            shpRect.setStrokeWidth(spnBorderWidth.getValue());
        });

    }

    public void chkBorderWidthOnAction(ActionEvent event) {
        clrBorder.setVisible(chkBorderWidth.isSelected());
        spnBorderWidth.setVisible(chkBorderWidth.isSelected());
        lblWidth.setVisible(chkBorderWidth.isSelected());
    }

    public void clrBackgroundOnAction(ActionEvent event) {
        shpRect.setFill(clrBackground.getValue());
    }

    public void chkBackgroundOnAction(ActionEvent event) {
        clrBackground.setVisible(chkBackground.isSelected());
    }

    public void rbHandOnAction(ActionEvent event) {
        chkBackground.setCursor(Cursor.HAND);
        chkBorderWidth.setCursor(Cursor.HAND);
    }

    public void rbDefaultOnAction(ActionEvent event) {
        root.setCursor(Cursor.DEFAULT);
    }

    public void btnFocusOnAction(ActionEvent event) {
        txtsomthing.requestFocus();
    }

    public void tglTooltipOnAction(ActionEvent event) {
        if(tglTooltip.isSelected()){
            rbDefault.setTooltip(new Tooltip("Default Cursor"));
            rbHand.setTooltip(new Tooltip("Hand Cursor"));
        }else {
            rbDefault.setTooltip(null);
            rbHand.setTooltip(null);
        }
    }

    public void tglDisabilityOnAction(ActionEvent event) {
        txtsomthing.setDisable(tglDisability.isSelected());
    }

    public void tglVisibilityOnAction(ActionEvent event) {
        txtsomthing.setVisible(tglVisibility.isSelected());
    }

    public void clrBorderOnAction(ActionEvent event) {
        //Color color = clrBorder.getValue();
        shpRect.setStroke(clrBorder.getValue());
    }
}
