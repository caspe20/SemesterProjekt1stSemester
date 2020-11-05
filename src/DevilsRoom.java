public class DevilsRoom extends Room{
    private TurnCounter turncounter;

    public DevilsRoom(String description,TurnCounter turncounter) {
        super(description);
        this.turncounter = turncounter;
    }
    @Override
    public String getLongDescription() {
        String s = "You are " + description + ".\n";
        s = s + turncounter.getYear() + ".\n";
        s = s + getExitString() + "\n";
        return s;
    }
}
