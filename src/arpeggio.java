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

    public arpeggio(){
        arr.add(new sound("C4"));
        arr.add(new sound("E4"));
        arr.add(new sound("G4"));
        arr.add(new sound("C5"));
    }

	public void makeWAV(){
        try{
        AudioInputStream first=null;
		for(int i=0; i<arr.size(); ++i){
            if(i==0){
                first = AudioSystem.getAudioInputStream(new File(System.getProperty("user.dir")+arr.get(i).location));
            }
            else{
	            AudioInputStream second = AudioSystem.getAudioInputStream(new File(System.getProperty("user.dir")+arr.get(i).location));
                                 first = new AudioInputStream(
                                                 new SequenceInputStream(first,second),
                                                 first.getFormat(),
                                                 first.getFrameLength() + second.getFrameLength());
                
            }
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
    clip.start();
}

}
