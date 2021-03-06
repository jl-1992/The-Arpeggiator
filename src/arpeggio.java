import java.util.ArrayList;
import java.io.IOException;

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
    private Clip clip;
    private int value=12;
    private boolean is_playing = false;

    public void makeArpeggio(String[] s){
        arr.clear();
        for(int i=0; i<s.length; ++i)
            arr.add(new sound(s[i]));
    }
    
    public void makeArpeggio(String[] gna, guitarNoteList l){
        arr.clear();
        for(int i=0; i<gna.length; ++i){
            arr.add(new sound(l.myMap.get(gna[i])));
        }
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
        }
        catch (UnsupportedAudioFileException e) {
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

public void playArpeggio() {
    createClip();
    is_playing=true;
    clip.loop(clip.LOOP_CONTINUOUSLY);
}

public boolean isPlaying(){
    return is_playing;
}

public void setValue(int v){
	value=v;
}

public void stop(){
    is_playing=false;
    clip.stop();
}

}
