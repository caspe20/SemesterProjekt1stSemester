public class TurnCounter {
    public int CurrentTurn = 0;
    public int CurrentYear = 0;

    public TurnCounter(int currentYear,int currentTurn) {
        this.CurrentTurn = currentTurn;
        this.CurrentYear = currentYear;
    }

    public void SimulateTurn(int time) {
        CurrentTurn+=time;
    }
    public String getYear() {
        return "The current year is yr " +(CurrentTurn+CurrentYear);
    }
}
