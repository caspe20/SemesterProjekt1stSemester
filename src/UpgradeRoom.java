public class UpgradeRoom extends Room {
    public UpgradePath upgradePathSpeed;
    public UpgradePath upgradePathQuantity;
    public int combinedProduction;

    // Attributes
    private UpgradePath upgradePathSpeed;
    private UpgradePath upgradePathQuantity;
    private int combinedProduction;

    // Constructors
    public UpgradeRoom(String description, UpgradePath upgradePathSpeed, UpgradePath upgradePathQuantity) {
        super(description);
        this.upgradePathSpeed = upgradePathSpeed;
        this.upgradePathQuantity = upgradePathQuantity;
    }

    public UpgradeRoom(String description) {
        super(description);
    }

    public void setCombinedProduction() {
        combinedProduction = upgradePathSpeed.getCurrentProduction() * upgradePathQuantity.getCurrentProduction();
    }

    // Getters
    public int getCombinedProduction() {
        return combinedProduction;
    }

    public UpgradePath getUpgradePathSpeed() {
        return upgradePathSpeed;
    }

    public UpgradePath getUpgradePathQuantity() {
        return upgradePathQuantity;
    }

}
