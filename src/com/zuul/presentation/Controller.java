package com.zuul.presentation;

// Import application layer
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static com.zuul.presentation.Wrapper.changeRoomToMatas;

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
    public Label upgradeProducts1Pollution;
    @FXML
    public Label upgradeProducts2Pollution;
    @FXML
    public Button upgradeProductsButton;
    @FXML
    public Label upgradeUsage1;
    @FXML
    public Label upgradeUsage2;
    @FXML
    public Label upgradeUsage1Pollution;
    @FXML
    public Label upgradeUsage2Pollution;
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
    }

    @FXML
    void updateRoomToCardealer() {
        Wrapper.changeRoomToCardealer();
    }

    @FXML
    void updateRoomToLaundry() {
        Wrapper.changeRoomToLaundry();
    }

    @FXML
    void updateRoomToDock() {
        Wrapper.changeRoomToDock();
    }

    @FXML
    void upgradeProductsButtonClick() {
        Wrapper.upgradeLvlUpdate1();
    }

    @FXML
    void upgradeUsageButtonClick() {
        Wrapper.upgradeLvlUpdate2();
    }

}
