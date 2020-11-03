public class Upgrade {

    // Attributes
    private String upgradeName;
    private double upgradePrice;
    private double productionSpeed;

    // Constructors
    public Upgrade(String upgradeName, double upgradePrice, double productionSpeed) {
        this.upgradeName = upgradeName;
        this.upgradePrice = upgradePrice;
        this.productionSpeed = productionSpeed;
    }

    // Getters
    public String getUpgradeName() {
        return upgradeName;
    }

    public double getUpgradePrice() {
        return upgradePrice;
    }

    public double getProductionSpeed() {
        return productionSpeed;
    }

}


