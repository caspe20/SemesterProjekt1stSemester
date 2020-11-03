public class UpgradeRoom {
    public UpgradePath upgradePathSpeed;
    public UpgradePath upgradePathQuantity;
    public int combinedProduction;

    public void setCombinedProduction(){
        combinedProduction = upgradePathSpeed.getCurrentProduction() * upgradePathQuantity.getCurrentProduction();
    }
}
