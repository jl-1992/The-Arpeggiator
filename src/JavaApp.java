import java.util.ArrayList;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

class app_frame extends JFrame{

	arpeggio g_major = new arpeggio();

	void makePackFrame(){
		setTitle("G Major Arpeggio");
		setLayout(new FlowLayout());
		addButton();
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void addButton(){
		JButton play = new JButton("play arpeggio");
		play.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	if(g_major.isPlaying()==false){
        		g_major.makeWAV();
            	g_major.playArpeggio();
            	play.setText("stop");
            }
            else{
            	g_major.stop();
            	play.setText("play arepeggio");
            }
        }
    	});
		add(play);
	}	
}

public class JavaApp{

	public static void main(String[] args){

		app_frame frame = new app_frame();
		frame.makePackFrame();

	}
}