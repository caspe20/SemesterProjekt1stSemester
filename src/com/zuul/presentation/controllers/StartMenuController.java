package com.zuul.presentation.controllers;

import com.zuul.presentation.Wrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class StartMenuController extends Controller{

    @FXML
    public Button goToDevil;
    @FXML
    public TextArea roomDescription;

    @FXML
    void startGame(){
        Wrapper.startGame();
    }
}
