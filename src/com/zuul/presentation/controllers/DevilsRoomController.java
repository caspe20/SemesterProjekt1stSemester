package com.zuul.presentation.controllers;

import com.zuul.presentation.Wrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;

public class DevilsRoomController {

    @FXML
    public Label time;
    @FXML
    public Label plastPerDay;
    @FXML
    public Label plastInSea;
    @FXML
    public Label fishSouls;
    @FXML
    public ProgressBar progressBar;
    @FXML
    public Label deadFish;
    @FXML
    public TextArea roomDescription;
    @FXML
    public TextArea userDescription;
    @FXML
    public Button goToMatas;
    @FXML
    public Button goToCarDealer;
    @FXML
    public Button goToLaundry;
    @FXML
    public Button goToHarbour;
    @FXML
    public Button goToDevil;
    @FXML
    public Label matasProduction;
    @FXML
    public Label matasUsage;
    @FXML
    public Label carDealerProduction;
    @FXML
    public Label carDealerUsage;
    @FXML
    public Label laundryProduction;
    @FXML
    public Label laundryUsage;
    @FXML
    public Label harbourProduction;
    @FXML
    public Label harbourUsage;

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
}
