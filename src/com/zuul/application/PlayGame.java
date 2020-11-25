package com.zuul.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
// Import presentation Layer
import com.zuul.presentation.*;

/**
 * com.zuul.application.PlayGame This is the function for the chronological
 * order of the game. Due to it being the start of the game, it also has the
 * only main method that is present in the game.
 */
public class PlayGame extends Application {
    String presentationLocation = "../presentation/";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*
         * Game g = new Game(); g.play();
         */
        Parent root = FXMLLoader.load(getClass().getResource(presentationLocation + "sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static String getTimeStat() {
        return GameStats.getYear();
    }
}
