public class Fish {
    private double fishInOcean;
    private double currentFishSouls;
    private double plasticInOcean;
    public UpgradeRoom[] upgradeRoom;

    public void simulateTimestep(int i) {

    }

    public boolean canAfford(double d) {
        if (currentFishSouls >= d) {
            return true;
        }else{
            return false;
        }
    }

}
