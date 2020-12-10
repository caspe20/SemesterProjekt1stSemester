package com.zuul.presentation.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class EndScreenController extends Controller {

    @FXML
    public TextArea userDescription;

    @FXML
    public void endGame(){
        Platform.exit();
        System.exit(0);
    }
}
