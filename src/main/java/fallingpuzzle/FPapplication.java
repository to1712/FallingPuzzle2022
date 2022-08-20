package fallingpuzzle;


import fallingpuzzle.controller.scene.FPMainMenuController;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FPapplication extends javafx.application.Application  {
	
	private static Stage primaryStage;
	
	//@Override
    public void start(Stage primaryStage) throws Exception {
    	FPapplication.primaryStage = primaryStage;
    	primaryStage.setScene( FPMainMenuController.getScene() );
        primaryStage.setResizable(false);
        primaryStage.setTitle("IGPE'S Project");
        primaryStage.setWidth(Settings.WINDOW_Y_SIZE);
        primaryStage.setHeight(Settings.WINDOW_X_SIZE);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        //primaryStage.draw();
    }
    
   public static void main(String[] args) {
        launch(args);
    }
   
   public static void setScene( Scene scene ) {
		if( primaryStage == null ) return;
		primaryStage.setScene( scene );
	}

}