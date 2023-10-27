package lk.ijse.dep11;

import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MainSceneController {

    public AnchorPane root;


    public Spinner<Integer> spnCount;


    public void initialize(){
        spnCount.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,2));

        Button btnGenerate = new Button("Generate Subjects");
        root.getChildren().add(btnGenerate);
        btnGenerate.setLayoutX(320);
        btnGenerate.setLayoutY(97);

        VBox vBox = new VBox();
        vBox.setLayoutX(50);
        vBox.setLayoutY(400);
        vBox.setSpacing(15);
        root.getChildren().add(vBox);

        btnGenerate.setOnAction(e ->{
            vBox.getChildren().clear();
            for (int i = 0; i < spnCount.getValue(); i++) {
                System.out.println("created");
                TextField textField = new TextField();
                vBox.getChildren().add(textField);

            }
        });

    }
}
