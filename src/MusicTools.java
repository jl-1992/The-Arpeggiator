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
		JButton arp = new JButton("The-Arpeggiator");
		arp.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	arpeggiator frame = new arpeggiator();
	        }
	    	});
		panel.add(arp);
	}

	public static void main(String[] args){
		MusicTools m = new MusicTools();
	}
	
}
