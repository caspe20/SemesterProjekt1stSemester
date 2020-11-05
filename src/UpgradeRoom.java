public class UpgradeRoom extends Room {
    public UpgradePath upgradePathSpeed;
    public UpgradePath upgradePathQuantity;
    public int combinedProduction;

    public UpgradeRoom(String description, UpgradePath upgradePathSpeed, UpgradePath upgradePathQuantity) {
        super(description);
        this.upgradePathSpeed = upgradePathSpeed;
        this.upgradePathQuantity = upgradePathQuantity;
    }

    public UpgradeRoom(String description){
        super(description);
    }

    public void setCombinedProduction(){
        combinedProduction = upgradePathSpeed.getCurrentProduction() * upgradePathQuantity.getCurrentProduction();
    }
}
