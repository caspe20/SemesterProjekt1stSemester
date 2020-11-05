public class UpgradeRoom extends Room {

    // Attributes
    private UpgradePath upgradePathSpeed;
    private UpgradePath upgradePathQuantity;
    private double combinedProduction;

    // Constructors
    public UpgradeRoom(String description, UpgradePath upgradePathSpeed, UpgradePath upgradePathQuantity) {
        super(description);
        this.upgradePathSpeed = upgradePathSpeed;
        this.upgradePathQuantity = upgradePathQuantity;
    }

    public void setCombinedProduction() {
        combinedProduction = upgradePathSpeed.currentProduction * upgradePathQuantity.currentProduction;
    }

    // This functions returns what the estimated production will be if you upgrade a certain path a certain amount;
    public double estimateSpeedIfUpgrade(int speed,int quantity) {
        return upgradePathSpeed.upgrades[upgradePathSpeed.getLevel()+speed].productionSpeed * upgradePathQuantity.upgrades[upgradePathSpeed.getLevel()+quantity].productionSpeed;
    }

    @Override
    public String getLongDescription() {
        String s = "You are " + description + ".\n";
        s = s + "--- Upgrade 1 --- \n";
        s = s + upgradePathSpeed.getUpgradeName(0) + " --> " + upgradePathSpeed.getUpgradeName(1) + "\n";
        s = s + upgradePathSpeed.getUpgradeCoefficient(0) + " --> " + upgradePathSpeed.getUpgradeCoefficient(1) + "\n";
        s = s + upgradePathSpeed.getUpgradePrice(0) + " Fish souls\n";
        s = s + "--- Upgrade 2 --- \n";
        s = s + upgradePathQuantity.getUpgradeName(0) + " --> " + upgradePathQuantity.getUpgradeName(1) + "\n";
        s = s + upgradePathQuantity.getUpgradeCoefficient(0) + " --> " + upgradePathQuantity.getUpgradeCoefficient(1) + "\n";
        s = s + upgradePathQuantity.getUpgradePrice(0) + " Fish souls\n";
        return s;
    }
}
