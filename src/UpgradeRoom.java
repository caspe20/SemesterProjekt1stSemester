public class UpgradeRoom extends Room {

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

    // Setters
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
