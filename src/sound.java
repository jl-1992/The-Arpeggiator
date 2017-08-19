import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class sound{

    private Clip clip;
    private String note;

    public sound(String note){
        this.note = note;
    }

private void SoundEffect(URL url) {
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
    } catch (UnsupportedAudioFileException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (LineUnavailableException e) {
        e.printStackTrace();
    }
}

public void playSound() {

    String path = "/resources/notes/" + note + ".wav";
    URL url = getClass().getResource(path); //finds file
    SoundEffect(url); //loads sound
    clip.start();
}

}