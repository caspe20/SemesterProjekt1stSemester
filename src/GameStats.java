import java.util.ArrayList;

public class GameStats {
    private static long fishInOcean = 3500000000l;
    public static long currentFishSouls = 0;
    private static long plasticInOcean = 0;
    private static long plasticProduction = 0;
    public static ArrayList<UpgradeRoom> upgradeRoom = new ArrayList<>();
    public static int CurrentTurn = 0;
    public static final int CurrentYear = 2000;

    public static void SimulateTurn(int yr) {
        CurrentTurn+=yr;
        for (int y = 0; y < yr;y++) {
            FetchPlasticProduction();
            UpdatePlastic();
            UpdateFish();
        }
    }
    public static String getYear() {
        return "The Current year is "+(CurrentYear+CurrentTurn);
    }

    public static void FetchPlasticProduction() {
        plasticProduction = 0;
        for (int i = 0; i < upgradeRoom.size();i++) {
            upgradeRoom.get(i).setCombinedProduction();
            plasticProduction += upgradeRoom.get(i).getCombinedProduction();
        }
    }

    public static String ShowResourceStats() {
        return "Your Current Fish souls: "+currentFishSouls+"\nFish in ocean: "+fishInOcean+"\nPlastic in Ocean: "+plasticInOcean+"\nPlastic produced pr year: "+plasticProduction;
    }
    private static void UpdatePlastic() {
        plasticInOcean += plasticProduction;
    }
    private static void UpdateFish() {
        currentFishSouls += plasticInOcean;
        fishInOcean -= plasticInOcean;
        if (fishInOcean <= 0) {
            fishInOcean = 0;
            // YOU WIN
        }
    }
}
