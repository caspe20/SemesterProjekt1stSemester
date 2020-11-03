public class UpgradePath extends Upgrade {
    public Upgrade[] upgrades;
    public String pathName;
    public int currentLevel;
    private int currentProduction;

    public int getCurrentProduction() {
        return currentProduction;
    }

    public void upgrade(){

    }

    public double getUpgradePrice(){
        return 10;
    }

    public String getUpgradeName() {
        return upgrades[currentLevel].getUpgradeName();
    }

    public String getNameOfNextUpgrade(){
        return upgrades[currentLevel+1].getUpgradeName();
    }

    public static void main(String[] args) {
        Upgrade level1 = new Upgrade();

        Upgrade[] kosmetik = new Upgrade[2];

    }

}
