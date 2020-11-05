public class UpgradePath {

    // Attributes
    public Upgrade[] upgrades;
    private String pathName;
    private int currentLevel = 0;
    public double currentProduction;

    // Constructors
    public UpgradePath(String pathName, Upgrade[] upgrades) {
        this.upgrades = upgrades;
        this.pathName = pathName;
        CalculateCurrentProduction();
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void CalculateCurrentProduction() {
        currentProduction = upgrades[currentLevel].productionSpeed;
    }

    public boolean PerformUpgrade() {
        if (currentLevel < upgrades.length) {
            if (GameStats.currentFishSouls >= upgrades[currentLevel + 1].upgradePrice) {
                GameStats.currentFishSouls += upgrades[currentLevel + 1].upgradePrice;
                currentLevel++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public String getUpgradeInfo() {
        if (currentLevel < upgrades.length) {
            String s = upgrades[currentLevel].upgradeName + " >>> " + upgrades[currentLevel + 1].upgradeName + "\n";
            s = s + "Price " + upgrades[currentLevel].upgradePrice + " Fish Souls \n";
            s = s + upgrades[currentLevel].productionSpeed + " plastic/yr >>> "
                    + upgrades[currentLevel + 1].productionSpeed + " plastic/yr\n";
            return s;
        } else {
            String s = upgrades[currentLevel].upgradeName + "\n" + upgrades[currentLevel].productionSpeed
                    + " plastic/yr";
            return s;
        }
    }

    public String getUpgradeName(int offset) {
        if (currentLevel + offset < upgrades.length) {
            return upgrades[currentLevel + offset].upgradeName;
        }
        return "";
    }

    public double getUpgradePrice(int offset) {
        if (currentLevel + offset < upgrades.length) {
            return upgrades[currentLevel + offset].upgradePrice;
        }
        return -1;
    }

    public double getUpgradeCoefficient(int offset) {
        if (currentLevel + offset < upgrades.length) {
            return upgrades[currentLevel + offset].productionSpeed;
        }
        return -1;
    }

    public int getLevel() {
        return currentLevel;
    }

}
