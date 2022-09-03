package fallingpuzzle;


import java.io.File;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class FPapplication extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			music();
			Parent root= FXMLLoader.load(getClass().getResource("/View/FPHome.fxml"));
			Scene home= new Scene(root);
			primaryStage.setScene(home);
			primaryStage.show();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	MediaPlayer bm;
	
	public void music() {
		//String path = "/FallingPuzzle2022/src/main/resources/Music/backgroundMusic.mp3";
		Media media = new Media(getClass().getResource("/music/backgroundMusic.mp3").toExternalForm());
		bm = new MediaPlayer(media);
		bm.play();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
