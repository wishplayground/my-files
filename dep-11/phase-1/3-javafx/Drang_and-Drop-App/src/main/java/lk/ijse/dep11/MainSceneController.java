package lk.ijse.dep11;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

import javax.sound.midi.Soundbank;

public class MainSceneController {
    public Label lblDragMe;
    public Rectangle shpRect;
    double elmX;
    double elmY;
    double sceneX;
    double sceneY;

    public void lblDragMeOnMouseDragged(MouseEvent e) {

        //System.out.printf("X = %.2f     ScreenX = %.2f     SceneX = %.2f\n",e.getX(),e.getScreenX(),e.getSceneX());

        lblDragMe.setLayoutX(e.getSceneX() - elmX);
        lblDragMe.setLayoutY(e.getSceneY() - elmY);
        /*lblDragMe.setLayoutX(e.getScreenX());
        lblDragMe.setLayoutY(e.getScreenY());

        lblDragMe.setLayoutX(e.getX());
        lblDragMe.setLayoutY(e.getY());*/
    }

    public void lblDragMeOnMousePressed(MouseEvent e) {

        elmX = e.getY();
        elmY = e.getY();
        sceneX =lblDragMe.getLayoutX();
        sceneY = lblDragMe.getLayoutY();
    }


    public void lblDragMeOnMouseReleased(MouseEvent e) {

        double currentX = lblDragMe.getLayoutX();
        double currentY = lblDragMe.getLayoutY();
        if(currentX >= shpRect.getLayoutX() && currentX <= shpRect.getWidth() + shpRect.getLayoutX() - lblDragMe.getWidth() && currentY >= shpRect.getLayoutY() && currentY <= shpRect.getLayoutY() +shpRect.getHeight() - lblDragMe.getHeight()){
            lblDragMe.setLayoutX(e.getSceneX() - elmX);
            lblDragMe.setLayoutY(e.getSceneY() - elmY);
        }else {
            lblDragMe.setLayoutX(sceneX);
            lblDragMe.setLayoutY(sceneY);
        }


        /*lblDragMe.setLayoutX(sceneX);
        lblDragMe.setLayoutY(sceneY);*/
    }
}
