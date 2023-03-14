package com.example.worlddictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class DictionaryPageController {
    private dictionarySaver db;
    @FXML
    TextField search;
    @FXML
    TextField meaning;
    @FXML
    TextField newword;
    @FXML

    TextField find;

    public void Search(MouseEvent event) throws  ClassNotFoundException {
        try {


            db = new dictionarySaver();
          //  db.serializeHashMap();
            db.deSerializeHashMap();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Dictionary");
            if(search.getText().equals(""))
            {
                alert.setContentText("please enter a word");
                alert.showAndWait();
            }
            else if (db.getDictionaryList().containsKey(search.getText().toLowerCase())) {
                System.out.println("the word is available");
            } else {
               alert.setContentText("the word is not available");
               alert.showAndWait();
            }
        }
        catch(IOException ioe)
            {
                db.serializeHashMap();
                System.out.println("exception is solved");
            }
        }
    @FXML
    public void Add(MouseEvent event) throws IOException, ClassNotFoundException {
        db = new dictionarySaver();
       // db.serializeHashMap();
        db.deSerializeHashMap();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");
        if (newword.getText().equals("") || meaning.getText().equals("")) {
            alert.setContentText("new word or meaning not be added");
            alert.showAndWait();
        } else if (db.getDictionaryList().containsKey(newword.getText().toLowerCase())) {
            alert.setContentText("the word is already available");
        } else {
            db.getDictionaryList().put(newword.getText(), meaning.getText());
            db.serializeHashMap();
            alert.setContentText("new word is added in dictionary");
            alert.showAndWait();
        }

        System.out.println(search.getText());
    }

    @FXML
    public void Find(MouseEvent event) throws IOException, ClassNotFoundException {
        db = new dictionarySaver();
        db.deSerializeHashMap();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("meaning");
        if(find.getText().equals(""))
        {
            alert.setContentText("please enter a word to find meaning");
            alert.showAndWait();

        }
        else if (db.getDictionaryList().containsKey(find.getText().toLowerCase())) {

            alert.setContentText(db.getDictionaryList().get(find.getText().toLowerCase()));
            alert.showAndWait();
        } else {
            alert.setContentText("the word is not available in the dictionary");
            alert.showAndWait();
        }

    }
}
