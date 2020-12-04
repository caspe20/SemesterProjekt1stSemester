package com.zuul.presentation;

// Import application layer
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    @FXML
    public Label year;
    @FXML
    public Label microplast;
    @FXML
    public Label time;

    @FXML
    public Label plastPerDay;
    @FXML
    public Label plastInSea;
    @FXML
    public Label fishSouls;
    @FXML
    public TextArea roomDescription;
    @FXML
    public TextArea userDescription;
    @FXML
    public Label roomName;
    @FXML
    public ProgressBar progressBar;
    @FXML
    public Label upgradeProducts1;
    @FXML
    public Label upgradeProducts2;
    @FXML
    public Label upgrade1Amount;
    @FXML
    public Label upgrade2Amount;
    @FXML
    public Button upgradeProductsButton;
    @FXML
    public Label upgradeUsage1;
    @FXML
    public Label upgradeUsage2;
    @FXML
    public Label upgrade3Amount;
    @FXML
    public Label upgrade4Amount;
    @FXML
    public Button upgradeUsageButton;
    @FXML
    public Label production;
    @FXML
    public Button goToMatas;
    @FXML
    public Button goToCarDealer;
    @FXML
    public Button goToLaundry;
    @FXML
    public Button goToHarbour;
    @FXML
    public Label deadFish;
    @FXML
    private Button goToDevil;
    @FXML
    private Label matasLvl1;
    @FXML
    private Label matasLvl2;
    @FXML
    private Label carDealerLvl1;
    @FXML
    private Label getCarDealerLvl2;
    @FXML
    private Label laundryLvl1;
    @FXML
    private Label laundryLvl2;
    @FXML
    private Label harbourlvl1;
    @FXML
    private Label harbourLvl2;

    @FXML
    void updateRoomToMatas() {
        Wrapper.changeRoomToMatas();
        Wrapper.writeRoomDescription();
        Wrapper.writeRoomName();
        Wrapper.writeUpgradeProductsOneToScreen();
        Wrapper.writeUpgradeProductsTwoToScreen();
        Wrapper.writeProductsUpgradePriceToButton();
    }

    @FXML
    void upgradeProductsButtonClick() {
        Wrapper.upgradeLvlUpdate1();
        Wrapper.writeUpgradeProductsOneToScreen();
        Wrapper.buyProductsUpgrade();
        Wrapper.writeUpgradeProductsOneToScreen();
        Wrapper.writeUpgradeProductsTwoToScreen();
        Wrapper.writeProductsUpgradePriceToButton();
    }

    @FXML
    void upgradeUsageButtonClick() {
        Wrapper.upgradeLvlUpdate2();
    }

    @FXML
    void updateRoomToCardealer() {
        Wrapper.changeRoomToCardealer();
        Wrapper.writeRoomDescription();
        Wrapper.writeRoomName();
        Wrapper.writeUpgradeProductsOneToScreen();
        Wrapper.writeUpgradeProductsTwoToScreen();
        Wrapper.writeProductsUpgradePriceToButton();
    }

    @FXML
    void updateRoomToLaundry() {
        Wrapper.changeRoomToLaundry();
        Wrapper.writeRoomDescription();
        Wrapper.writeRoomName();
        Wrapper.writeUpgradeProductsOneToScreen();
        Wrapper.writeUpgradeProductsTwoToScreen();
        Wrapper.writeProductsUpgradePriceToButton();
    }

    @FXML
    void updateRoomToDock() {
        Wrapper.changeRoomToDock();
        Wrapper.writeRoomDescription();
        Wrapper.writeRoomName();
        Wrapper.writeUpgradeProductsOneToScreen();
        Wrapper.writeUpgradeProductsTwoToScreen();
        Wrapper.writeProductsUpgradePriceToButton();
    }

}
