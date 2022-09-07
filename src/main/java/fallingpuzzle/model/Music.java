package fallingpuzzle.model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music {
	public Media media;
	public MediaPlayer bm;
	
	
	public Music() {
		media = new Media(getClass().getResource("/music/backgroundMusic.mp3").toExternalForm());
		bm = new MediaPlayer(media);
		music(true);
	}
	
	public void music(boolean b) {
		if(b)
			bm.play();
		else 
			bm.stop();
		
	}
}
