public class Upgrade {
    private String upgradeName;
    private double upgradePrice;
    private double productionSpeed;

    public Upgrade(String upgradeName, double upgradePrice, double productionSpeed) {
        this.upgradeName = upgradeName;
        this.upgradePrice = upgradePrice;
        this.productionSpeed = productionSpeed;
    }

    public String getUpgradeName() {
        return upgradeName;
    }

}


