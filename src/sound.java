public class sound{

    private String note;
    public String location;

    public sound(String note){
        this.note = note;
        this.location = "/resources/notes/" + note + ".wav";
    }
}