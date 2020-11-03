public class UpgradePath {

    // Attributes
    public Upgrade[] upgradePath;
    private String pathName;
    private int currentLevel;
    private int currentProduction;

    // Constructors
    public void UpgradePath(Upgrade[] upgradePath, String pathName) {
        this.upgradePath = upgradePath;
        this.pathName = pathName;
    }

    // Setters
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void setCurrentProduction(int currentProduction) {
        this.currentProduction = currentProduction;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }


    // Getters
    public Upgrade[] getUpgradePath() {
        return upgradePath;
    }

    public String getPathName() {
        return pathName;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getCurrentProduction() {
        return currentProduction;
    }

}
