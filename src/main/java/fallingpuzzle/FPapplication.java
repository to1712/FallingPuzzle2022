package fallingpuzzle;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FPapplication extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root= FXMLLoader.load(getClass().getResource("/View/FPHome.fxml"));
			Scene home= new Scene(root);
			primaryStage.setScene(home);
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
