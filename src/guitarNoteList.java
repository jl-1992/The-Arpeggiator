import java.util.HashMap;

public class guitarNoteList {
	
	static final HashMap<guitar_note, sound> myMap = createMap();
    static HashMap<guitar_note, sound> createMap()
    {
        HashMap<guitar_note,sound> myMap = new HashMap<guitar_note,sound>();
        //low E-string
        myMap.put(new guitar_note(6,0), new sound("E2"));
        myMap.put(new guitar_note(6,1), new sound("F2"));
        myMap.put(new guitar_note(6,2), new sound("F#2"));
        myMap.put(new guitar_note(6,3), new sound("G2"));
        myMap.put(new guitar_note(6,4), new sound("G#2"));
        myMap.put(new guitar_note(6,5), new sound("A2"));
        myMap.put(new guitar_note(6,6), new sound("A#2"));
        myMap.put(new guitar_note(6,7), new sound("B2"));
        myMap.put(new guitar_note(6,8), new sound("C3"));
        myMap.put(new guitar_note(6,9), new sound("C#3"));
        myMap.put(new guitar_note(6,10), new sound("D3"));
        myMap.put(new guitar_note(6,11), new sound("D#3"));
        myMap.put(new guitar_note(6,12), new sound("E3"));
        myMap.put(new guitar_note(6,13), new sound("F3"));
        myMap.put(new guitar_note(6,14), new sound("F#3"));
        myMap.put(new guitar_note(6,15), new sound("G3"));
        myMap.put(new guitar_note(6,16), new sound("G#3"));
        myMap.put(new guitar_note(6,17), new sound("A3"));
        myMap.put(new guitar_note(6,18), new sound("A#3"));
        myMap.put(new guitar_note(6,19), new sound("B3"));
        myMap.put(new guitar_note(6,20), new sound("C4"));
        myMap.put(new guitar_note(6,21), new sound("C#4"));
        myMap.put(new guitar_note(6,22), new sound("D4"));
        myMap.put(new guitar_note(6,23), new sound("D#4"));
        myMap.put(new guitar_note(6,24), new sound("E4"));
        
        //A
        myMap.put(new guitar_note(5,0), new sound("A2"));
        myMap.put(new guitar_note(5,1), new sound("A#2"));
        myMap.put(new guitar_note(5,2), new sound("B2"));
        myMap.put(new guitar_note(5,3), new sound("C3"));
        myMap.put(new guitar_note(5,4), new sound("C#3"));
        myMap.put(new guitar_note(5,5), new sound("D3"));
        myMap.put(new guitar_note(5,6), new sound("D#3"));
        myMap.put(new guitar_note(5,7), new sound("E3"));
        myMap.put(new guitar_note(5,8), new sound("F3"));
        myMap.put(new guitar_note(5,9), new sound("F#3"));
        myMap.put(new guitar_note(5,10), new sound("G3"));
        myMap.put(new guitar_note(5,11), new sound("G#3"));
        myMap.put(new guitar_note(5,12), new sound("A3"));
        myMap.put(new guitar_note(5,13), new sound("A#3"));
        myMap.put(new guitar_note(5,14), new sound("B3"));
        myMap.put(new guitar_note(5,15), new sound("C4"));
        myMap.put(new guitar_note(5,16), new sound("C#4"));
        myMap.put(new guitar_note(5,17), new sound("D4"));
        myMap.put(new guitar_note(5,18), new sound("D#4"));
        myMap.put(new guitar_note(5,19), new sound("E4"));
        myMap.put(new guitar_note(5,20), new sound("F4"));
        myMap.put(new guitar_note(5,21), new sound("F#4"));
        myMap.put(new guitar_note(5,22), new sound("G4"));
        myMap.put(new guitar_note(5,23), new sound("G#4"));
        myMap.put(new guitar_note(5,24), new sound("A4"));
        
        //D
        myMap.put(new guitar_note(4,0), new sound("D3"));
        myMap.put(new guitar_note(4,1), new sound("D#3"));
        myMap.put(new guitar_note(4,2), new sound("E3"));
        myMap.put(new guitar_note(4,3), new sound("F3"));
        myMap.put(new guitar_note(4,4), new sound("F#3"));
        myMap.put(new guitar_note(4,5), new sound("G3"));
        myMap.put(new guitar_note(4,6), new sound("G#3"));
        myMap.put(new guitar_note(4,7), new sound("A3"));
        myMap.put(new guitar_note(4,8), new sound("A#3"));
        myMap.put(new guitar_note(4,9), new sound("B3"));
        myMap.put(new guitar_note(4,10), new sound("C4"));
        myMap.put(new guitar_note(4,11), new sound("C#4"));
        myMap.put(new guitar_note(4,12), new sound("D4"));
        myMap.put(new guitar_note(4,13), new sound("D#4"));
        myMap.put(new guitar_note(4,14), new sound("E4"));
        myMap.put(new guitar_note(4,15), new sound("F4"));
        myMap.put(new guitar_note(4,16), new sound("F#4"));
        myMap.put(new guitar_note(4,17), new sound("G4"));
        myMap.put(new guitar_note(4,18), new sound("G#4"));
        myMap.put(new guitar_note(4,19), new sound("A4"));
        myMap.put(new guitar_note(4,20), new sound("A#4"));
        myMap.put(new guitar_note(4,21), new sound("B4"));
        myMap.put(new guitar_note(4,22), new sound("C5"));
        myMap.put(new guitar_note(4,23), new sound("C#5"));
        myMap.put(new guitar_note(4,24), new sound("D5"));
        
        //G
        myMap.put(new guitar_note(3,0), new sound("G3"));
        myMap.put(new guitar_note(3,1), new sound("G#3"));
        myMap.put(new guitar_note(3,2), new sound("A3"));
        myMap.put(new guitar_note(3,3), new sound("A#3"));
        myMap.put(new guitar_note(3,4), new sound("B3"));
        myMap.put(new guitar_note(3,5), new sound("C4"));
        myMap.put(new guitar_note(3,6), new sound("C#4"));
        myMap.put(new guitar_note(3,7), new sound("D4"));
        myMap.put(new guitar_note(3,8), new sound("D#4"));
        myMap.put(new guitar_note(3,9), new sound("E4"));
        myMap.put(new guitar_note(3,10), new sound("F4"));
        myMap.put(new guitar_note(3,11), new sound("F#4"));
        myMap.put(new guitar_note(3,12), new sound("G4"));
        myMap.put(new guitar_note(3,13), new sound("G#4"));
        myMap.put(new guitar_note(3,14), new sound("A4"));
        myMap.put(new guitar_note(3,15), new sound("A#4"));
        myMap.put(new guitar_note(3,16), new sound("B4"));
        myMap.put(new guitar_note(3,17), new sound("C5"));
        myMap.put(new guitar_note(3,18), new sound("C#5"));
        myMap.put(new guitar_note(3,19), new sound("D5"));
        myMap.put(new guitar_note(3,20), new sound("D#5"));
        myMap.put(new guitar_note(3,21), new sound("E5"));
        myMap.put(new guitar_note(3,22), new sound("F5"));
        myMap.put(new guitar_note(3,23), new sound("F#5"));
        myMap.put(new guitar_note(3,24), new sound("G5"));
        
        //B
        myMap.put(new guitar_note(2,0), new sound("B3"));
        myMap.put(new guitar_note(2,1), new sound("C4"));
        myMap.put(new guitar_note(2,2), new sound("C#4"));
        myMap.put(new guitar_note(2,3), new sound("D4"));
        myMap.put(new guitar_note(2,4), new sound("D#4"));
        myMap.put(new guitar_note(2,5), new sound("E4"));
        myMap.put(new guitar_note(2,6), new sound("F4"));
        myMap.put(new guitar_note(2,7), new sound("F#4"));
        myMap.put(new guitar_note(2,8), new sound("G4"));
        myMap.put(new guitar_note(2,9), new sound("G#4"));
        myMap.put(new guitar_note(2,10), new sound("A4"));
        myMap.put(new guitar_note(2,11), new sound("A#4"));
        myMap.put(new guitar_note(2,12), new sound("B4"));
        myMap.put(new guitar_note(2,13), new sound("C5"));
        myMap.put(new guitar_note(2,14), new sound("C#5"));
        myMap.put(new guitar_note(2,15), new sound("D5"));
        myMap.put(new guitar_note(2,16), new sound("D#5"));
        myMap.put(new guitar_note(2,17), new sound("E5"));
        myMap.put(new guitar_note(2,18), new sound("F5"));
        myMap.put(new guitar_note(2,19), new sound("F#5"));
        myMap.put(new guitar_note(2,20), new sound("G5"));
        myMap.put(new guitar_note(2,21), new sound("G#5"));
        myMap.put(new guitar_note(2,22), new sound("A5"));
        myMap.put(new guitar_note(2,23), new sound("A#5"));
        myMap.put(new guitar_note(2,24), new sound("B5"));
        
       //high E-string
        myMap.put(new guitar_note(1,0), new sound("E4"));
        myMap.put(new guitar_note(1,1), new sound("F4"));
        myMap.put(new guitar_note(1,2), new sound("F#4"));
        myMap.put(new guitar_note(1,3), new sound("G4"));
        myMap.put(new guitar_note(1,4), new sound("G#4"));
        myMap.put(new guitar_note(1,5), new sound("A4"));
        myMap.put(new guitar_note(1,6), new sound("A#4"));
        myMap.put(new guitar_note(1,7), new sound("B4"));
        myMap.put(new guitar_note(1,8), new sound("C5"));
        myMap.put(new guitar_note(1,9), new sound("C#5"));
        myMap.put(new guitar_note(1,10), new sound("D5"));
        myMap.put(new guitar_note(1,11), new sound("D#5"));
        myMap.put(new guitar_note(1,12), new sound("E5"));
        myMap.put(new guitar_note(1,13), new sound("F5"));
        myMap.put(new guitar_note(1,14), new sound("F#5"));
        myMap.put(new guitar_note(1,15), new sound("G5"));
        myMap.put(new guitar_note(1,16), new sound("G#5"));
        myMap.put(new guitar_note(1,17), new sound("A5"));
        myMap.put(new guitar_note(1,18), new sound("A#5"));
        myMap.put(new guitar_note(1,19), new sound("B5"));
        myMap.put(new guitar_note(1,20), new sound("C6"));
        myMap.put(new guitar_note(1,21), new sound("C#6"));
        myMap.put(new guitar_note(1,22), new sound("D6"));
        myMap.put(new guitar_note(1,23), new sound("D#6"));
        myMap.put(new guitar_note(1,24), new sound("E6"));
        
        return myMap;
    }
}
