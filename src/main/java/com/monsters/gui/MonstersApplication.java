package com.monsters.gui;

import com.monsters.core.GameEngine;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MonstersApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemClassLoader().getResource("main.fxml"));
        Parent root = loader.load();
        stage.setTitle("Monsters in the city");
        stage.setScene(new Scene(root, 1280, 800));
        stage.setResizable(false);
        stage.show();

        GameEngine.getInstance().gameUI = loader.getController();
        GameEngine.getInstance().initGame();
    }
}
