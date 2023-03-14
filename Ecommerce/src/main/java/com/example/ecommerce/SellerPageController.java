package com.example.ecommerce;

import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SellerPageController {
    @FXML
    TextField name, price , sellerid;
    @FXML
    public void AddProduct(MouseEvent event) throws SQLException {
        int productId=1;
        ResultSet response2=EcomMain.connection.executeQuery(" Select max(productId) as productId from product");
        if(response2.next())
        {
            productId = response2.getInt("productId") + 1;
        }
            String query=String.format("Insert into product values(%s,'%s','%s','%s')" , productId , name.getText(),price.getText(),sellerid.getText());
            int response=EcomMain.connection.executeUpdate(query);
            if(response>0)
            {
               // System.out.println("new product is added");
                Dialog<String> dialog=new Dialog<>();
               // dialog.setTitle("se");
                ButtonType type=new ButtonType("OK" , ButtonBar.ButtonData.OK_DONE);
                dialog.getDialogPane().getButtonTypes().add(type);
                dialog.setContentText("new product is added ");
                dialog.showAndWait();


            }

    }


}


