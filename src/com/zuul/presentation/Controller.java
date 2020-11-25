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
    private TextArea roomdiscription;


    @FXML
    void updateYear() {
        year.setText(PlayGame.getTimeStat());
    }

    @FXML
    void updateRoomDiscription(){
        roomdiscription.setText(PlayGame.getRoomDiscription());
    }


}
