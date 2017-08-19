import java.util.ArrayList;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class app_frame extends JFrame{
	
	public ArrayList<sound> arpeggio = new ArrayList<sound>();
	
	void makeChord(){
		arpeggio.add(new sound("C4"));
		arpeggio.add(new sound("E4"));
		arpeggio.add(new sound("G4"));
		arpeggio.add(new sound("C5"));
	}

	void makePackFrame(){
		setTitle("C Major Chord");
		setLayout(new FlowLayout());
		addButton();
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void playSounds(ArrayList<sound> arr){
			for(sound s : arr){
				s.playSound();
			}
		}

	void addButton(){
		JButton play = new JButton("play arpeggio");
		play.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            playSounds(arpeggio);
        }
    });
		add(play);
	}	
}

public class JavaApp{

	public static void main(String[] args){

		app_frame frame = new app_frame();
		frame.makeChord();
		frame.makePackFrame();

	}
}