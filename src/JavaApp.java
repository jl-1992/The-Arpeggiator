import javax.swing.JFrame;
import java.awt.FlowLayout;

class app_frame extends JFrame{
	
	void makePackFrame(){
		setTitle("C Major Notes");
		setLayout(new FlowLayout());
		setButton();
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void setButton(){
		add(new sound_button("C4"));
		add(new sound_button("E4"));
		add(new sound_button("G4"));
		add(new sound_button("C5"));
	}	
}

public class JavaApp{
	public static void main(String[] args){

		app_frame a1 = new app_frame();
		a1.makePackFrame();
	}
}