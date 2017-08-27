import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MusicTools extends JFrame{
	
	JPanel panel = new JPanel();
	
	public MusicTools()
	{
		setTitle("Music-Tools");
		addPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		addLabel();
		addArpeggiator();
		addCreateOwn();
		pack();
		setLocation(430,100);
		//setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void addLabel() {
		JLabel lbl = new JLabel("Please select a music tool:");
		panel.add(lbl);
	}
	
	private void addPanel(){
		add(panel);
	}
	
	private void addArpeggiator(){
		JButton arp = new JButton("Practice Arpeggio Sweeps");
		arp.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	new arpeggiator();
	        }
	    	});
		panel.add(arp);
	}
	
	private void addCreateOwn(){
		JButton arp = new JButton("Create Own Arpeggio");
		arp.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	new create_own_arpeggio();
	        }
	    	});
		panel.add(arp);
	}

	public static void main(String[] args){
		new MusicTools();
	}
	
}
