package lk.ijse.dep11;

import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainViewController {
    public Slider slrRed;
    public Slider slrGreen;
    public Slider slrBlue;
    public Slider slrAqua;
    public Rectangle shpRectangle;
    public TextField txtred;
    public TextField txtgreen;
    public TextField txtblue;
    public TextField txtAqua;

    //set value to a text

    public void initialize(){
        //double redValue, greenValue, blueValue, aquValue;
        slrRed.valueProperty().addListener(e ->{
            txtred.setText(String.format("%.0f",slrRed.getValue()));
            changeColor();

        });

        slrGreen.valueProperty().addListener(e ->{
            txtgreen.setText(String.format("%.0f",slrGreen.getValue()));
            changeColor();
        });

        slrBlue.valueProperty().addListener(e ->{
            txtblue.setText(String.format("%.0f",slrBlue.getValue()));
            changeColor();
        });
        slrAqua.valueProperty().addListener(e ->{
            txtAqua.setText(String.format("%.2f",slrAqua.getValue()));
            changeColor();
        });


    }
    public void changeColor(){
        int blue = Integer.parseInt(txtblue.getText());
        int red = Integer.parseInt(txtred.getText());
        int green = Integer.parseInt(txtgreen.getText());
        double aqua = Double.parseDouble(txtAqua.getText());

        shpRectangle.setFill(Color.rgb(red,green,blue,aqua));
    }

}
