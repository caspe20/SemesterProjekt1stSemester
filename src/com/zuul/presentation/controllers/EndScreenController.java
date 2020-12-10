package com.zuul.presentation.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class EndScreenController extends Controller {

    @FXML
    public TextArea EndScreenDescription;

    @FXML
    public void EndGame(){
        Platform.exit();
        System.exit(0);
    }
}
