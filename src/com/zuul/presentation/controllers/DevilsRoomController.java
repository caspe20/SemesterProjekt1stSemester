package com.zuul.presentation.controllers;

import com.zuul.presentation.Wrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DevilsRoomController extends Controller {
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

    @FXML
    void upgradeProductsButtonClick() {
        Wrapper.upgradeLvlUpdate1();
    }

    @FXML
    void upgradeUsageButtonClick() {
        Wrapper.upgradeLvlUpdate2();
    }

    @FXML
    void updateRoomToDevil() throws Exception {
        Wrapper.changeRoomToDevil();
    }
}
