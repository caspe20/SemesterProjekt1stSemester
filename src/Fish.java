public class Fish {

    /* OBS! Following methods hos not yet been written:
    - simulateTimestep(int)
    - buy(int): boolean
    - simulateTime(int)

    I have divided the "canAfford(int): boolean"-method in to two
    methods: One representing Speed Upgrade and the other one
    representing Quantity Upgrade

    /Simon

     */


    // Attributes
    private double fishInOcean;
    private double currentFishSouls;
    private double plasticInOcean;
    private UpgradeRoom[] upgradeRoom;
    private int currentRoomNumber;


    // Setters
    public void setFishInOcean(double fishInOcean) {
        this.fishInOcean = fishInOcean;
    }

    public void setCurrentFishSouls(double currentFishSouls) {
        this.currentFishSouls = currentFishSouls;
    }

    public void setPlasticInOcean(double plasticInOcean) {
        this.plasticInOcean = plasticInOcean;
    }

    public void setCurrentRoomNumber(int currentRoomNumber) {
        this.currentRoomNumber = currentRoomNumber;
    }


    // Getters
    public double getFishInOcean() {
        return fishInOcean;
    }

    public double getCurrentFishSouls() {
        return currentFishSouls;
    }

    public double getPlasticInOcean() {
        return plasticInOcean;
    }

    public int getCurrentRoomNumber() {
        return currentRoomNumber;
    }

    // Methods
    public void addPlastic(double additionalPlastic) {
        setPlasticInOcean(getPlasticInOcean()+additionalPlastic);
    }

    public boolean canAffordSpeedUpgrade() {
        return currentFishSouls > upgradeRoom[currentRoomNumber].
                getUpgradePathSpeed().
                getUpgradePath()[upgradeRoom[currentRoomNumber].getUpgradePathSpeed().getCurrentLevel()+1].
                getUpgradePrice();
    }

    public boolean canAffordQuantityUpgrade() {
        return currentFishSouls > upgradeRoom[currentRoomNumber].
                getUpgradePathQuantity().
                getUpgradePath()[upgradeRoom[currentRoomNumber].getUpgradePathQuantity().getCurrentLevel()+1].
                getUpgradePrice();
    }


}
