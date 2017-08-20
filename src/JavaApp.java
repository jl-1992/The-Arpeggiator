import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class app_frame extends JFrame{

	arpeggio scale = new arpeggio();
	scaleList list = new scaleList();
	String note="";
	String key_type = "";

	JPanel panel = new JPanel();

	void makeFrame(){
		setTitle("The-Arpeggiator");
		setLayout(new FlowLayout());
		addLabel();
		addNoteBox();
		addKeyBox();
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

	void addNoteBox(){
		String[] notes = {"A", "A#", "B", "C", "C#",
						  "D", "D#", "E", "F", "F#", "G"};
		JComboBox<String> notebox = new JComboBox<String>(notes);
		notebox.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	JComboBox combo = (JComboBox) e.getSource();
    		note = (String) combo.getSelectedItem();
        }
    	});
    	note = (String) notebox.getSelectedItem();
    	panel.add(notebox);
	}

	void addKeyBox(){
		String[] choices = {"Major", "Minor"};
		JComboBox<String> box = new JComboBox<String>(choices);
		box.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	JComboBox combo = (JComboBox) e.getSource();
    		key_type = (String) combo.getSelectedItem();
    		scale.makeArpeggio(list.scales.get(note+" "+key_type));
    		scale.makeWAV();
        }
    	});
    	key_type = (String) box.getSelectedItem();
		panel.add(box);
	}

	void addPlayButton(){
		JButton play = new JButton("play arpeggio");
		play.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	scale.makeArpeggio(list.scales.get(note + " " +key_type));
    		scale.makeWAV();
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
		frame.makeFrame();
	}
}