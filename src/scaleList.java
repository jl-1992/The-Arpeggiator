import java.util.HashMap;

public class scaleList{
	HashMap<String,String[]> scales = new HashMap<String,String[]>();

	public scaleList(){

		String[] e_major = {"E3", "G#3", "B3", "E4", "G#4", "B4"};
		String[] e_minor = {"E3", "G3", "B3", "E4", "G4", "B4"};
		String[] f_major = {"F3", "A3", "C4", "F4", "A4", "C5"};
		String[] f_minor = {"F3", "G#3", "C4", "F4", "G#4", "C5"};
		String[] f_sharp_major = {"F#3", "A#3", "C#4", "F#4", "A#4", "C#5"};
		String[] f_sharp_minor = {"F#3", "A3", "C#4", "F#4", "A4", "C#5"};
		String[] g_major = {"G3", "B3", "D4", "G4", "B4", "D5"};
		String[] g_minor = {"G3", "A#3", "D4", "G4", "A#4", "D5"};
		String[] g_sharp_major = {"G#3", "C4", "D#4", "G#4", "C5", "D#5"};
		String[] g_sharp_minor = {"G#3", "B3", "D#4", "G#4", "B4", "D#5"};
		String[] a_major = {"A3", "C#4", "E4", "A4", "C#5", "E5"};
		String[] a_minor = {"A3", "C4", "E4", "A4", "C5", "E5"};
		String[] a_sharp_major = {"A#3", "D4", "F4", "A#4", "D5", "F5"};
		String[] a_sharp_minor = {"A#3", "C#4", "F4", "A#4", "C#5", "F5"};
		String[] b_major = {"B3", "D#4", "F#4", "B4", "D#5", "F#5"};
		String[] b_minor = {"B3", "D4", "F#4", "B4", "D5", "F#5"};
		String[] c_major = {"C4", "E4", "G4", "C5", "E5", "G5"};
		String[] c_minor = {"C4", "D#4", "G4", "C5", "D#5", "G5"};
		String[] c_sharp_major = {"C#4", "F4", "G#4", "C#5", "F5", "G#5"};
		String[] c_sharp_minor = {"C#4", "E4", "G#4", "C#5", "E5", "G#5"};
		String[] d_major = {"D4", "F#4", "A4", "D5", "F#5", "A5"};
		String[] d_minor = {"D4", "F4", "A4", "D5", "F5", "A5"};
		String[] d_sharp_major = {"D#4", "G4", "A#4", "D#5", "G5", "A#5"};
		String[] d_sharp_minor = {"D#4", "F#4", "A#4", "D#5", "F#5", "A#5"};

		scales.put("A Major", a_major);
		scales.put("A Minor", a_minor);
		scales.put("A# Major", a_sharp_major);
		scales.put("A# Minor", a_sharp_minor);
		scales.put("B Major", b_major);
		scales.put("B Minor", b_minor);
		scales.put("C Major", c_major);
		scales.put("C Minor", c_minor);
		scales.put("C# Major", c_sharp_major);
		scales.put("C# Minor", c_sharp_minor);
		scales.put("D Major", d_major);
		scales.put("D Minor", d_minor);
		scales.put("D# Major", d_sharp_major);
		scales.put("D# Minor", d_sharp_minor);
		scales.put("E Major", e_major);
		scales.put("E Minor", e_minor);
		scales.put("F Major", f_major);
		scales.put("F Minor", f_minor);
		scales.put("F# Major", f_sharp_major);
		scales.put("F# Minor", f_sharp_minor);
		scales.put("G Major", g_major);
		scales.put("G Minor", g_minor);
		scales.put("G# Major", g_sharp_major);
		scales.put("G# Minor", g_sharp_minor);
	}
}