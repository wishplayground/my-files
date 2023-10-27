package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainViewController {
    public AnchorPane mainroot;

    public ToggleButton tglDisability;
    public TextField txtSomthing;
    public Button btnFocus;
    public ToggleButton tglTooltip;
    public ToggleButton tglVisibility;
    public RadioButton rdbHand;
    public RadioButton rdbDefault;
    public Label lblOutput;
    public CheckBox cbBackGround;
    public ColorPicker cpBack;
    public CheckBox cbBoader;
    public Spinner<Integer> spThick;
    public ColorPicker cpBoader;
    public Rectangle shpRect;
    public Label lblTitle;
    public Label lblwidth;
    public Slider slrOpacity;
    public Label lblValue;

    public void initialize(){
        spThick.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,2,1));// SpinnerValueFactory.IntegerSpinnerValueFactory(min,max, initial value)
        Color colorRef = cpBack.getValue();
        lblTitle.setBackground(Background.fill(colorRef));

        cbBackGround.fire();
        cbBoader.fire();

        tglVisibility.setSelected(true);
        txtSomthing.focusedProperty().addListener(e ->{
            System.out.println(txtSomthing.isFocused() ? "Focus gained" : "Lost Focus");
        });
        tglTooltip.fire();//when starts triggers attached Action Listener
        rdbDefault.setSelected(true);

        //setcursor
        txtSomthing.setCursor(Cursor.MOVE);

        txtSomthing.textProperty().addListener(e ->{
            lblOutput.setText(String.format("Output %s ",txtSomthing.getText()));
        });
        spThick.valueProperty().addListener(e ->{
            changeBoader();
        });
        /*cpBack.setVisible(false);
        cpBoader.setVisible(false);
        spThick.setVisible(false);
        lblwidth.setVisible(false);*/

        //Slider
        slrOpacity.valueProperty().addListener(e -> {
            String opacity = String.format("Value: %.2f%%",slrOpacity.getValue());
            lblValue.setText(opacity);
            shpRect.setOpacity(slrOpacity.getValue()/100);
        });

    }
    public void tglDisabilityOnAction(ActionEvent event) {
        System.out.println(tglDisability.isSelected());
        txtSomthing.setDisable(tglDisability.isSelected());
        System.out.println("Is text something disabled" + txtSomthing.isDisabled() );

    }

    public void btnFocusOnAction(ActionEvent event) {
        txtSomthing.requestFocus();
        System.out.printf("Has txtsomething gained focus " + txtSomthing.isFocused());
    }

    public void tglTooltipOnAction(ActionEvent event) {
        if(tglTooltip.isSelected()){
            rdbDefault.setTooltip(new Tooltip("Default Cursor"));
            rdbHand.setTooltip(new Tooltip("Default Cursor"));
        }else {
            rdbDefault.setTooltip(null);
            rdbHand.setTooltip(null);
        }
        if(rdbDefault.getTooltip() != null) {
            System.out.println("What is the tool tip radio Default cursor" + rdbDefault.getTooltip().getText());
        }
    }

    public void tglVisibilityOnAction(ActionEvent event) {
        txtSomthing.setVisible(tglVisibility.isSelected());
    }

    public void rdbDefaultOnAction(ActionEvent event) {
        mainroot.setCursor(Cursor.DEFAULT);
    }

    public void rdbHandOnAction(ActionEvent event) {
        System.out.println("Existing Cursor is " + mainroot.getCursor());
        mainroot.setCursor(Cursor.TEXT);
        System.out.println("Existing Cursor is " + mainroot.getCursor());
    }

    public void cbBackGroundOnAction(ActionEvent event) {
        cpBack.setDisable(cbBackGround.isSelected());
        /*if(cbBackGround.isSelected()){
            cpBack.setVisible(true);
        }else {
            cpBack.setVisible(false);
        }*/
    }

    public void cpBackOnAction(ActionEvent event) {
        Color selectBackgroundColor = cpBack.getValue();
        shpRect.setFill(selectBackgroundColor);

    }

    public void cbBoaderOnAction(ActionEvent event) {
        if(cbBoader.isSelected()){
            cpBoader.setVisible(true);
            spThick.setVisible(true);
            lblwidth.setVisible(true);
        }else {
            cpBoader.setVisible(false);
            spThick.setVisible(false);
            lblwidth.setVisible(false);
        }
    }



    public void cpBoaderOnAction(ActionEvent event) {
        changeBoader();
    }

    void changeBoader(){
        shpRect.setStroke(cpBoader.getValue());
        shpRect.setStrokeWidth(spThick.getValue());

        //create boader for label
        Color boadercolor = cpBoader.getValue();//creae border color
        BorderStrokeStyle borderStrokeStyle = BorderStrokeStyle.SOLID;
        BorderStroke borderStrokeRef = new BorderStroke(boadercolor, borderStrokeStyle , new CornerRadii(5),new BorderWidths(spThick.getValue()) );//Create border stroke
        Border borderRef = new Border(borderStrokeRef);
        lblTitle.setBorder(borderRef);

        //crete boader by css
        String border = String.format("%dpx solid %s",spThick.getValue(),cpBoader.getValue().toString().substring(2));

        //another way
//        String borderStyle = String.format("-fx-border-width: %dpx; -fx-border-color: #%s;",spThick.getValue(), cpBoader.getValue().toString().substring(2));
//        lblTitle.setStyle(borderStyle);

    }
}
