package com.example.ecommerce;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EcomMain extends Application {

   public static DatabaseConnection connection;
    static Group root;
    public static String emailId;
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        emailId="";
         connection =new DatabaseConnection();
        root = new Group();

        Header header=new Header();
        ProductPage productPage=new ProductPage();
        AnchorPane productPane=new AnchorPane();

        productPane.getChildren().add(productPage.products());
        productPane.setLayoutX(150);

        productPane.setLayoutY(100);
        root.getChildren().addAll(header.root,productPane);
        stage.setTitle("Ecommerce!");
       // ResultSet res = connection.executeQuery("select * from temporary");
        stage.setScene( new Scene(root, 500, 500));

        stage.show();
        stage.setOnCloseRequest(e ->{
            try
            {
                connection.con.close();
                System.out.println("connection is closed");

            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}