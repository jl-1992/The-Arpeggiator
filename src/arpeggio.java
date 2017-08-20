import java.util.ArrayList;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.File;
import java.io.SequenceInputStream;

public class arpeggio{

	private ArrayList<sound> arr = new ArrayList<sound>();
    private URL url=null;
    private Clip clip;
    //change value for faster arpeggio. higher value = faster arpeggio.
    private int value=12;
    private boolean is_playing = false;

    public arpeggio(){
        arr.add(new sound("G3"));
        arr.add(new sound("B3"));
        arr.add(new sound("D4"));
        arr.add(new sound("G4"));
        arr.add(new sound("B4"));
        arr.add(new sound("D5"));
    }

	public void makeWAV(){
        try{
        AudioInputStream first=null;

		for(int i=0; i<arr.size(); ++i){
            if(i==0){
                first = AudioSystem.getAudioInputStream(new File(System.getProperty("user.dir")+arr.get(i).location));
                first = new AudioInputStream(first,first.getFormat(),first.getFrameLength()/value);
            }
            else{
	            AudioInputStream second = AudioSystem.getAudioInputStream(new File(System.getProperty("user.dir")+arr.get(i).location));
                second = new AudioInputStream(second,second.getFormat(),second.getFrameLength()/value); 
                                 first = new AudioInputStream(
                                                 new SequenceInputStream(first,second),
                                                 first.getFormat(),
                                                 first.getFrameLength() + second.getFrameLength());
                
            }
		}
        for(int j=arr.size()-1; j>=0;--j){
            AudioInputStream second = AudioSystem.getAudioInputStream(new File(System.getProperty("user.dir")+arr.get(j).location));
                second = new AudioInputStream(second,second.getFormat(),second.getFrameLength()/value); 
                                 first = new AudioInputStream(
                                                 new SequenceInputStream(first,second),
                                                 first.getFormat(),
                                                 first.getFrameLength() + second.getFrameLength());
        }
        AudioSystem.write(first,
                          AudioFileFormat.Type.WAVE,
                          new File(System.getProperty("user.dir")+"/arpeggio.wav"));
        url = getClass().getResource("/arpeggio.wav");
        }
        catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
        }
        catch (IOException e) {
                e.printStackTrace();
        }
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

public void playArpeggio() {
    SoundEffect(url);
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
