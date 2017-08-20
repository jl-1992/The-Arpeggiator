import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;

class app_frame extends JFrame{

	arpeggio scale = new arpeggio();
	HashMap<String,String[]> scales = new HashMap<String,String[]>();

	JPanel panel = new JPanel();

	void makeFrame(){
		setTitle("The-Arpeggiator");
		setLayout(new FlowLayout());
		addLabel();
		addBox();
		addPlayButton();
		pack();
		//setSize(500,500);
		setLocation(430,100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void addLabel(){
		add(panel);
		JLabel label = new JLabel("Select scale from dropdown list: ");
		panel.add(label);
	}

	void addBox(){
		String[] choices = {"G Major", "E Minor"};
		JComboBox<String> box = new JComboBox<String>(choices);
		box.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	JComboBox combo = (JComboBox) e.getSource();
    		String item = (String) combo.getSelectedItem();
    		scale.makeArpeggio(scales.get(item));
    		scale.makeWAV();
        }
    	});
    	String chosen = (String) box.getSelectedItem();
    	scale.makeArpeggio(scales.get(chosen));
    	scale.makeWAV();
		panel.add(box);
	}

	void addPlayButton(){
		JButton play = new JButton("play arpeggio");
		play.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	if(scale.isPlaying()==false){
            	scale.playArpeggio();
            	play.setText("stop");
            }
            else{
            	scale.stop();
            	play.setText("play arpeggio");
            }
        }
    	});
		panel.add(play);
	}	
}

public class JavaApp{

	public static void main(String[] args){
		app_frame frame = new app_frame();
		String[] s = {"G3", "B3", "D4", "G4", "B4", "D5"};
		String[] t = {"E3", "G3", "B3", "E4", "G4", "B4"};
		frame.scales.put("G Major", s);
		frame.scales.put("E Minor", t);
		frame.makeFrame();
	}
}