package com.zuul.presentation;
// Import application layer
import com.zuul.application.PlayGame;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    @FXML
    private Button upgrade1;
    @FXML
    private Label time;

    public void changeName(){
        String labelName = PlayGame.getTimeStat();
        time.setText(labelName);
    }

}
