package com.zuul.presentation.controllers;

// Import application layer
import com.zuul.presentation.Wrapper;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class UpgradeRoomController extends Controller {


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
    public Button goToDevil;
    @FXML
    public Pane UpgradeProductArrow;
    @FXML
    public Pane UpgradeUsageArrow;

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

    @FXML
    void updateRoomToDevil() {
        Wrapper.changeRoomToDevil();
    }
}
