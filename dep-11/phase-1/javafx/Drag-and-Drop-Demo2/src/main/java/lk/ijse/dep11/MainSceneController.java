package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;

public class MainSceneController {
    public AnchorPane rootPane;
    public TextField txtTodo;
    public ListView<String> lvTodo;
    public ListView<String> lvCompleted;

    public void initialize(){

    }

    public void txtTodoOnAction(ActionEvent event) {
        String task = txtTodo.getText();
        if(task.strip().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Task Cannot be Empty").show();
            txtTodo.requestFocus();
            txtTodo.selectAll();
            return;
        } else if (isDuplicate(task)) {
            txtTodo.selectAll();
            txtTodo.requestFocus();
            return;
        }
        lvTodo.getItems().add(task);
        txtTodo.clear();
        txtTodo.requestFocus();
    }

    public boolean isDuplicate(String task){
        if(lvTodo.getItems().contains(task)) {
            new Alert(Alert.AlertType.ERROR,"Already Exixsting task").show();
            return true;
        }
        return false;
    }

    public void lvTodoOnDragDetected(MouseEvent e) {
        //get drag item in clip board and set start dragging
        Dragboard dragboard = lvTodo.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent cp = new ClipboardContent();
        cp.putString(lvTodo.getSelectionModel().getSelectedItem());
        dragboard.setContent(cp);
    }

    public void lvCompletedOnDragDropped(DragEvent e) {
        //recieve drag item
        String str = e.getDragboard().getString();
        lvCompleted.getItems().add(str);
        lvTodo.getItems().remove(str);
        System.out.println("Dropped");
        //lvCompleted.drop
    }

    public void lvCompletedOnDragOver(DragEvent e) {
        //dragged item detection
        e.acceptTransferModes(TransferMode.MOVE);
        //System.out.println("Drag Over");
    }
}
