module com.example.worlddictionary {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.worlddictionary to javafx.fxml;
    exports com.example.worlddictionary;
}