package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

import java.io.File;

public class MainViewController {
    public AnchorPane rootmedia;
    public TextField txtAudiopath;
    public Button btnAudioBrows;
    public Button btnStopAudio;
    public Button btnPlayAudio;
    public TextField txtVideoPath;
    public Button btnBrowseVideo;
    public Button btnPlayVideo;
    public Button btnStopVideo;
    public MediaView mvmedia;

    MediaPlayer audioPlayer;
    MediaPlayer videoPlayer;
    //MP3 player
    public void btnAudioBrowsOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("MP3 files","*.mp3"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Wave files","*.wav"));

        File audioFile = fileChooser.showOpenDialog(rootmedia.getScene().getWindow());
        if(audioFile != null){
            txtAudiopath.setText(audioFile.getAbsolutePath());

            Media media = new Media(audioFile.toURI().toString());

            audioPlayer = new MediaPlayer(media);

        }else {
            txtAudiopath.clear();
        }
    }

    public void btnPlayAudioOnAction(ActionEvent event) {
        if(audioPlayer != null){
            audioPlayer.play();
        }
    }
    public void btnStopAudioOnAction(ActionEvent event) {
        if(audioPlayer != null){
            audioPlayer.stop();
        }
    }


    public void btnPlayVideoOnAction(ActionEvent event) {
        if(videoPlayer !=null){
            mvmedia.setMediaPlayer(videoPlayer);
            videoPlayer.play();

        }

    }

    public void btnStopVideoOnAction(ActionEvent event) {
        if(videoPlayer !=null){
            mvmedia.setMediaPlayer(videoPlayer);
            videoPlayer.stop();

        }
    }



    public void btnBrowseVideoOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Mp4 file","*.mp4"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("mkv file","*.mkv"));
        File videoFile = fileChooser.showOpenDialog(rootmedia.getScene().getWindow());

        if(videoFile != null){
            txtVideoPath.setText(videoFile.getAbsolutePath());
            Media videoMedia = new Media(videoFile.toURI().toString());
            videoPlayer = new MediaPlayer(videoMedia);
        }else {
            txtVideoPath.clear();
        }
    }
}
