package lk.ijse.dep11;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class MainFormCntroller {
    public AnchorPane root;
    public Button btnFadeIn;
    public Button btnFadeOut;
    public Circle shapeFade;
    public Spinner<Integer> txtRotate;
    public Button btnRotate;
    public Rectangle shapeRotate;
    public Spinner<Double> txtScale;
    public Button btnScale;
    public Circle shapeScale;
    public ComboBox<String> cmbTrans;
    public Button btnTrnas;
    public Rectangle ShapeTrans;
    public Button btnFill;
    public Circle shapeFill;
    public ColorPicker clrFrom;
    public ColorPicker clrTo;
    public Rectangle ShapeStroke;
    public Button btnStroke;
    public ColorPicker clrStrokefrom;
    public ColorPicker clrStrokeTo;


    public void initialize(){
        txtRotate.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-360,360));
        txtRotate.getValueFactory().setValue(45);

        //min,Max initial value,step
        txtScale.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(-0.5,2,1.3,0.1));
        txtScale.getValueFactory().setValue(2.0);

        cmbTrans.getItems().add("SlideIn Left");
        cmbTrans.getItems().add("SlideIn Right");
        cmbTrans.getItems().add("SlideIn Up");
        cmbTrans.getItems().add("SlideIn Down");
        cmbTrans.getItems().add("SlideOut Left");
        cmbTrans.getItems().add("SlideOut Right");
        cmbTrans.getItems().add("SlideOut Up");
        cmbTrans.getItems().add("SlideOut Down");

    }


    //Fade In (Hide ->  Show)
    //Fade In (Show ->  Hide)
    public void btnFadeInAction(ActionEvent actionEvent) {
        FadeTransition fadeOut = new  FadeTransition(Duration.millis(1000),shapeFade);//duration in milli seconde and fading etity
        fadeOut.setFromValue(0);
        fadeOut.setToValue(1);
        fadeOut.playFromStart();
    }

    public void btnFadeOutAction(ActionEvent actionEvent) {
        FadeTransition fadeOut = new  FadeTransition(Duration.millis(500),shapeFade);//duration in milli seconde and fading etity
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.playFromStart();
    }

    public void btnRotateOnAction(ActionEvent actionEvent) {

        RotateTransition rotate = new RotateTransition(Duration.millis(500),shapeRotate);

        rotate.getFromAngle();
        rotate.setToAngle(txtRotate.getValue());
        rotate.playFromStart();
    }

    public void btnScaleOnAction(ActionEvent actionEvent) {

        ScaleTransition scale = new ScaleTransition(Duration.millis(500), shapeScale);
        scale.setFromX(0);
        scale.setFromY(0);
        scale.setToX(txtScale.getValue());
        scale.setToY(txtScale.getValue());
        scale.playFromStart();
    }

    public void BtnTransOnAction(ActionEvent actionEvent) {

        //layoutX="79.0" layoutY="129.0"
        TranslateTransition translate = new TranslateTransition(Duration.millis(500),ShapeTrans);

        ShapeTrans.setLayoutX(79.0);
        ShapeTrans.setLayoutY(129.0);

        switch (cmbTrans.getValue()){
            case "SlideIn Left":
                translate.setFromX(-250);
                translate.setToX(0);
                break;

            case "SlideIn Right":
                translate.setFromX(250);
                translate.setToX(0);
                break;

            case "SlideIn Up":
                translate.setFromY(-250);
                translate.setToX(0);
                break;

            case "SlideIn Down":
                translate.setFromY(250);
                translate.setToY(0);
                break;

            case "SlideOut Left":
                translate.setFromX(0);
                translate.setToX(-250);
                break;

            case "SlideOut Right":
                translate.setFromX(0);
                translate.setToX(250);
                break;


            case "SlideOut Up":
                translate.setFromY(0);
                translate.setToY(-250);
                break;

            case "SlideOut Down":
                translate.setFromY(0);
                translate.setToY(250);
                break;
        }
        translate.playFromStart();
    }

    public void btnFillOnAction(ActionEvent actionEvent) {

        FillTransition fill = new FillTransition(Duration.millis(2500),shapeFill);

        fill.setFromValue(clrFrom.getValue());
        fill.setToValue(clrTo.getValue());
        fill.playFromStart();
    }

    public void btnStrokOnAction(ActionEvent actionEvent) {

        StrokeTransition stroke = new StrokeTransition(Duration.millis(2500),ShapeStroke);

        stroke.setFromValue(clrStrokefrom.getValue());
        stroke.setToValue(clrStrokeTo.getValue());
        stroke.playFromStart();
    }
}
