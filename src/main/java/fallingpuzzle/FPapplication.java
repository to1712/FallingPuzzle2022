package fallingpuzzle;


import fallingpuzzle.controller.scene.FPMainMenuController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FPapplication extends Application  {
	
	//@Override
    public void start(Stage primaryStage) throws Exception {
        //Game game = new Game();
    	primaryStage.setScene( FPMainMenuController.getScene() );
        primaryStage.setResizable(false);
        primaryStage.setWidth(606);
        primaryStage.setHeight(772);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        //primaryStage.draw();
    }
   public static void main(String[] args) {
        launch(args);
    }

}