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

	arpeggio c_major = new arpeggio();

	void makePackFrame(){
		setTitle("C Major Arpeggio");
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
        	c_major.makeWAV();
            c_major.playArpeggio();
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