package com.zuul.presentation;
// Import application layer
import com.zuul.application.PlayGame;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {


    @FXML
    private Label year;
    @FXML
    private Label microplast;

    @FXML
    private Label plastPerDay;
    @FXML
    private Label plastInSea;
    @FXML
    private Label fishSouls;
    @FXML
    private TextArea roomDescription;
    @FXML
    private TextArea userDescription;
    @FXML
    private Label roomName;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label upgrade1;
    @FXML
    private Label upgrade2;
    @FXML
    private Label upgrade1Amount;
    @FXML
    private Label upgrade2Amount;
    @FXML
    private Button upgradeButton1;
    @FXML
    private Label upgrade3;
    @FXML
    private Label upgrade4;
    @FXML
    private Label upgrade3Amount;
    @FXML
    private Label upgrade4Amount;
    @FXML
    private Button upgradeButton2;
    @FXML
    private Label production;
    @FXML
    private Button buttonUp;
    @FXML
    private Button buttonDown;
    @FXML
    private Button buttonRight;
    @FXML
    private Button buttonLeft;
    @FXML
    private Label deadFish;
    @FXML
    void updateYear() {
        year.setText(PlayGame.getTimeStat());
    }

    @FXML
    void updateRoomDiscription(){
        roomdiscription.setText(PlayGame.getRoomDiscription());
    }


}
