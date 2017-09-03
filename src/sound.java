import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class sound{

    private String note;
    public String location;
    private Clip clip;
    private boolean is_playing=false;

    public sound(String note){
        this.setNote(note);
        this.location = "/resources/notes/" + note + ".wav";
    }

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public void makeWav(){
	try{
		AudioInputStream audio = AudioSystem.getAudioInputStream(new File(System.getProperty("user.dir")+this.location));
		audio = new AudioInputStream(audio,audio.getFormat(),audio.getFrameLength()/2);
		AudioSystem.write(audio,
                AudioFileFormat.Type.WAVE,
                new File(System.getProperty("user.dir")+"/arpeggio.wav"));
	}catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
    }
    catch (IOException e) {
            e.printStackTrace();
    	}
	}
	
	private void createClip() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(System.getProperty("user.dir")+"/arpeggio.wav"));
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

	public void play() {
	    createClip();
	    is_playing=true;
	    clip.loop(clip.LOOP_CONTINUOUSLY);
	}

	public boolean isPlaying(){
	    return is_playing;
	}

	public void stop(){
	    is_playing=false;
	    clip.stop();
	}
}