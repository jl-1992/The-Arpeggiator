import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;

public class sound_button extends JButton{

    private Clip clip;
    private String note;

    public sound_button(String note) {
        this.note=note;
        this.setText(note);
        this.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            playTheSound();
        }
    });
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

public void playTheSound() {

    String path = "/resources/notes/" + note + ".wav";
    URL url = getClass().getResource(path);
    SoundEffect(url);//this method will load the sound

    if (clip.isRunning())
        clip.stop();   // Stop the player if it is still running
    clip.setFramePosition(0); // rewind to the beginning
    clip.start();     // Start playing
    }

}