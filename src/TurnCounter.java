public class TurnCounter {
    public int CurrentTurn = 0;
    public void SimulateTurn(int time) {
        CurrentTurn+=time;
    }
}
