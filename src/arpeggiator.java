import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class arpeggiator extends JFrame{

	arpeggio scale = new arpeggio();
	scaleList list = new scaleList();
	bpmList blist = new bpmList();
	String note="";
	String key_type = "";
	String bpm = "";

	JPanel panel = new JPanel();

	public arpeggiator(){
		setTitle("The-Arpeggiator");
		setLayout(new FlowLayout());
		addbpmLabel();
		addBPMbox();
		addScaleLabel();
		addNoteBox();
		addKeyBox();
		addPlayButton();
		pack();
		setLocation(430,100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addCloseEvent();
	}

	void addbpmLabel(){
		add(panel);
		JLabel label = new JLabel("Select BPM: ");
		panel.add(label);
	}
	
	void addScaleLabel(){
		JLabel label = new JLabel("Select Scale: ");
		panel.add(label);
	}
	
	void addBPMbox(){
		String[] bpmlist = {"40","50", "65", "80", "90","105",
				"115","130","140","155","170","180","200",
				"210","220","235","245","260"};
		JComboBox<String> bpmbox = new JComboBox<String>(bpmlist);
		bpmbox.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	JComboBox combo = (JComboBox) e.getSource();
    		bpm = (String) combo.getSelectedItem();
    		scale.setValue(blist.bpmMap.get(bpm));
        }
    	});
    	bpm = (String) bpmbox.getSelectedItem();
    	scale.setValue(blist.bpmMap.get(bpm));
    	panel.add(bpmbox);
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
	
	void addCloseEvent(){
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				if(scale.isPlaying())
					scale.stop();
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
	}
}