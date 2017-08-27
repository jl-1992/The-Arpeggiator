import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class create_own_arpeggio extends JFrame{
	
	arpeggio scale = new arpeggio();
	guitarNoteList gnlist = new guitarNoteList();
	bpmList blist = new bpmList();
	String bpm = "";
	String string = "";
	String fret="";
	
	JPanel panel = new JPanel();

	Box hb = Box.createHorizontalBox();
	
	public create_own_arpeggio(){
		setTitle("Create-arpeggio");
		addbpmLabel();
		addBPMbox();
		add(hb, BorderLayout.NORTH);
		addPlayButton();
		addNoteLayer();
		pack();
		setLocation(300,100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//addCloseEvent();
	}

	
	void addbpmLabel(){
		hb.add(new JLabel("Select BPM: "));
		hb.add(Box.createHorizontalStrut(20));
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
    	hb.add(bpmbox);
    	hb.add(Box.createHorizontalStrut(55));
	}

	void addNoteLayer(){
		String[] strings = {"E_high", "B", "G", "D", "A", "E_low"};
		Box nb = Box.createHorizontalBox();
		add(nb, BorderLayout.SOUTH);
		nb.add(new JLabel("Note 1:"));
		nb.add(Box.createHorizontalStrut(25));
		nb.add(new JLabel("String:"));
		JComboBox<String> stringBox = new JComboBox<String>(strings);
		stringBox.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	JComboBox combo = (JComboBox) e.getSource();
    		string = (String) combo.getSelectedItem();
        }
    	});
    	string = (String) stringBox.getSelectedItem();
    	nb.add(stringBox);
    	nb.add(new JLabel("Fret:"));
    	String[] frets = {"0", "1", "2", "3", "4", "5", "6", "7",
    					  "8", "9", "10", "11", "12", "13", "14",
    					  "15", "16", "17", "18", "19", "20", "21",
    					  "22", "23", "24"};
    	JComboBox<String> fretBox = new JComboBox<String>(frets);
		fretBox.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	JComboBox combo = (JComboBox) e.getSource();
    		fret = (String) combo.getSelectedItem();
        }
    	});
    	fret = (String) fretBox.getSelectedItem();
    	nb.add(fretBox);
	}

	void addPlayButton(){
		JButton play = new JButton("play arpeggio");
		play.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	//scale.makeArpeggio(list.scales.get(note + " " +key_type));
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
		hb.add(play);
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
