package com.example.worlddictionary;
import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import javafx.scene.Group;

public class Main extends Application {
    public static Group root;

    @Override
    public void start(Stage stage) throws Exception {

        root = new Group();
        stage.setTitle(" world Dictionary");
        DictionaryPage page;
        page = new DictionaryPage();
        root.getChildren().add(page.root);

        stage.setScene(new Scene(root,500,500));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

