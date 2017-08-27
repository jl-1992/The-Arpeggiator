public class sound{

    private String note;
    public String location;

    public sound(String note){
        this.setNote(note);
        this.location = "/resources/notes/" + note + ".wav";
    }

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}