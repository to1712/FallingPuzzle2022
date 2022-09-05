package fallingpuzzle;


import java.io.File;
import java.nio.file.Paths;

import fallingpuzzle.controller.FPGameController;
import fallingpuzzle.model.Music;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class FPapplication extends Application {

	
	public FPapplication() {}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			//Music music = new Music();
			//music.music(true);
			Parent root= FXMLLoader.load(getClass().getResource("/View/FPHome.fxml"));
			Scene home= new Scene(root);
			primaryStage.setScene(home);
			primaryStage.setResizable(false);
			primaryStage.setTitle("IGPE'S Project");
			primaryStage.show();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
