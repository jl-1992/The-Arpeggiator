import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class noteLayer {
	private int layer;
	public String string;
	public String fret;
	public String note;
	Box nb;
	
	public noteLayer(int layer){
		this.layer=layer;
		String[] strings = {"E_high", "B", "G", "D", "A", "E_low"};
		nb = Box.createHorizontalBox();
		nb.add(new JLabel("Note " + (this.layer+1) + ":"));
		nb.add(Box.createHorizontalStrut(25));
		nb.add(new JLabel("String:"));
		JComboBox<String> stringBox = new JComboBox<String>(strings);
		stringBox.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	JComboBox combo = (JComboBox) e.getSource();
    		string = (String) combo.getSelectedItem();
    		note = string + "_" + fret;
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
    		fret= (String) combo.getSelectedItem();
    		note = string + "_" + fret;
        }
    	});
		fret= (String) fretBox.getSelectedItem();
    	nb.add(fretBox);
    	note = string + "_" + fret;
	}
}
