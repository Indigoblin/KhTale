package Tools;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

public class Music {
    private static final String MAIN_MENU_THEME = "src/Asset/Music/kingdom-hearts-dearly-beloved-8-bit.mp3";
    private static final String SPLATOON = "src/Asset/Music/spicyCalamariInkantation.mp3";
    private static MediaPlayer mediaPlayer;
    private static double volume = 0.1;

    public static void startMainMenuMusic() {
        if( mediaPlayer != null ) mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(new Media(Paths.get(MAIN_MENU_THEME).toUri().toString()));
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }

    public static void startSplatoonLevelMusic(){
        mediaPlayer = new MediaPlayer(new Media(Paths.get(SPLATOON).toUri().toString()));
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }

    public static void stopMusic(){
        mediaPlayer.stop();
    }

    public static void setVolume(double volume) {
        Music.volume = volume;
        if(mediaPlayer!=null) mediaPlayer.setVolume(volume);
    }
}