import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class tuner extends JFrame{
	
	sound note = new sound("E4");
	Box vb = Box.createVerticalBox();
	guitarNoteList gnlist = new guitarNoteList();
	
	public tuner(){
		setTitle("Tuner");
		addStrings();
		addStopButton();
		add(vb);
		pack();
		setLocation(200,100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addCloseEvent();
	}
	
	public void addStrings(){
		String[] strings = {"E_low", "A", "D" ,"G", "B", "E_high"};
		
		for(int i=0; i < strings.length; ++i){
			Box box = Box.createHorizontalBox();
			box.add(new JLabel(strings[i]));
			if(strings[i].equals("E_low") || strings[i].equals("E_high")){
				box.add(Box.createHorizontalStrut(120));
			}
			else{
				box.add(Box.createHorizontalStrut(150));
			}
			box.add(addPlayButton(strings[i]));
			vb.add(box);
		}
	}
	
	public JButton addPlayButton(String s){
		JButton play = new JButton("play");
		play.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	if(note.isPlaying()==false){
        		note = new sound(gnlist.myMap.get(s+"_0"));
        		note.makeWav();
        		note.play(); 
        	}
        	else{
        		note.stop();
        		note = new sound(gnlist.myMap.get(s+"_0"));
        		note.makeWav();
            	note.play(); 
        	}
        }
    	});
		return play;
	}
	
	public void addStopButton(){
		JButton stop = new JButton("stop");
		stop.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	if(note.isPlaying()==true)
        		note.stop();
            }
        });
		Box box = Box.createHorizontalBox();
		box.add(stop);
		vb.add(box);
	}
	
	void addCloseEvent(){
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				if(note.isPlaying())
					note.stop();
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
	}
}
