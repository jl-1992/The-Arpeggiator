import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

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
	String[] note_list = new String[1];
	int layer=0;
	ArrayList<noteLayer> noteLayerList = new ArrayList<noteLayer>();

	Box hb = Box.createHorizontalBox();
	Box vb = Box.createVerticalBox();
	
	public create_own_arpeggio(){
		setTitle("Create-arpeggio");
		addbpmLabel();
		addBPMbox();
		add(hb, BorderLayout.NORTH);
		addPlayButton();
		addNoteLayer();
		addAddNoteBox();
		add(vb, BorderLayout.SOUTH);
		pack();
		setLocation(300,100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addCloseEvent();
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
		noteLayer n = new noteLayer(layer);
		vb.add(n.nb);
		noteLayerList.add(n);
		++layer;
	}
	
	void deleteNoteLayer(){
		--layer;
		noteLayer n = noteLayerList.get(layer);
		vb.remove(n.nb);
		noteLayerList.remove(layer);
	}
	
	void addAddNoteBox(){
		JButton add_note_box = new JButton("add note");
		add_note_box.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	//if(layer>0)
        		//addDeleteNoteBox();
        	add_note_box.setVisible(false);
        	addNoteLayer();
        	note_list = addNote(note_list);
        	addAddNoteBox();
        }
    	});
		vb.add(add_note_box);
	}
	
	void addDeleteNoteBox(){
		JButton delete_note_box = new JButton("delete note");
		delete_note_box.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	deleteNoteLayer();
        	if(layer==0){
        		delete_note_box.setVisible(false);
        		note_list=deleteNote(note_list);
        	}
        	else{
        		note_list = deleteNote(note_list);
        		addDeleteNoteBox();
        	}
        }
    	});
		vb.add(delete_note_box);
	}

	void addPlayButton(){
		JButton play = new JButton("play arpeggio");
		play.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	int i=0;
        	for(noteLayer n : noteLayerList){
        		note_list[i]= n.note;
        		++i;
        	}
        	scale.makeArpeggio(note_list,gnlist);
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
	
	String[] addNote(String[] gna){
		String[] arp = new String[gna.length+1];
		return arp;
	}
	
	String[] deleteNote(String[] gna){
		String[] arp = new String[gna.length-1];
		return arp;
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
