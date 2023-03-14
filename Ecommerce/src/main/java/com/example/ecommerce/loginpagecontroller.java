package com.example.ecommerce;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class loginpagecontroller{
    @FXML
    TextField email;
    @FXML
    PasswordField password;
    @FXML
    public void login(MouseEvent e) throws SQLException, IOException {
        String query = String.format("select * from user where emailId= '%s' AND password= '%s'", email.getText(), password.getText());
        ResultSet res = EcomMain.connection.executeQuery(query);

        if (res.next()) {
            EcomMain.emailId= res.getString("emailId");
            String userType = res.getString("userType");
            System.out.println(userType);
            if (userType.equals("Seller")) {
                AnchorPane sellerPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sellerpage.fxml")));
                EcomMain.root.getChildren().clear();


                EcomMain.root.getChildren().add(sellerPage);


            }

            else
                {

                   //EcomMain.root.getChildren().clear();
                    System.out.println("we are logged as buyer");
                    ProductPage productPage=new ProductPage();
                    Header header=new Header();

                    AnchorPane productPane=new AnchorPane();
                    productPane.getChildren().add(productPage.products());
                    productPane.setLayoutX(150);

                    productPane.setLayoutY(100);
                    EcomMain.root.getChildren().clear();
                   // EcomMain.root.getChildren().add(productPane);

                   // EcomMain.root.getChildren().add(productPane);
                   EcomMain.root.getChildren().addAll(header.root,productPane);

                   // AnchorPane sellerPage = FXMLLoader.load(getClass().getResource("sellerpage.fxml"));

                    //EcomMain.root.getChildren().add(sellerPage);


                }
                //   System.out.println("user is present");
            }
        else
        {
               // System.out.println("user is not present");
           // javafx.scene.control.Dialog<String> dialog=new Dialog<>();
            Dialog<String> dialog=new Dialog<>();
            dialog.setTitle("login");
            ButtonType type=new ButtonType("OK" , ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.setContentText("log in failed please check username/ password");
            dialog.showAndWait();


        }
    }
}
