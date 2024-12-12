package config;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.IOException;
import java.io.InputStream;

public class ChristmasSong extends Thread {
    @Override
    public void run() {
        try (InputStream inputStream = getClass().getResourceAsStream("/sound/Christmas_song.mp3")) {
            Player player = new Player(inputStream);
            player.play();
        } catch (JavaLayerException e) {
            System.out.println("Error while playing MP3 file: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
