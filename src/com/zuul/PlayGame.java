package com.zuul;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * com.zuul.PlayGame This is the function for the chronological order of the game. Due to
 * it being the start of the game, it also has the only main method that is
 * present in the game.
 */
public class PlayGame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root,300,275));
        primaryStage.show();
        Game g = new Game();
        // g.play();
    }
}
