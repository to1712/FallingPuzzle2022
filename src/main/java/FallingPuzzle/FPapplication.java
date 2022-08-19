package FallingPuzzle;


import FallingPuzzle.FPapplication;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FPapplication extends Application  {
	
	//@Override
    public void start(Stage primaryStage) throws Exception {
        //Game game = new Game();
    	//Scene scene=new Scene()
    	//primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setWidth(500);
        primaryStage.setHeight(400);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        //primaryStage.draw();
    }
   public static void main(String[] args) {
        launch(args);
    }

}