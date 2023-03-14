package com.example.ecommerce;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.sql.SQLException;

public class HeaderController {
    @FXML
    public void initialize()
    {
        if(!EcomMain.emailId.equals(""))
        {
            loginbutton.setOpacity(0);


            email.setText(EcomMain.emailId);
        }
    }
    @FXML
    Label email;
    @FXML
    Button loginbutton,logoutbutton;
    @FXML
    TextField searchtext;
    @FXML
    public void login(MouseEvent event) throws IOException {
        AnchorPane loginpage= FXMLLoader.load(getClass().getResource("loginpage.fxml"));
        EcomMain.root.getChildren().add(loginpage);
    }
    @FXML
    public void search(MouseEvent e) throws IOException, SQLException {

        ProductPage productPage=new ProductPage();
        Header header=new Header();
        AnchorPane productPane=new AnchorPane();
        productPane.getChildren().add(productPage.productsbysearch(searchtext.getText()));
        productPane.setLayoutX(150);
        productPane.setLayoutY(100);
        EcomMain.root.getChildren().clear();
        EcomMain.root.getChildren().addAll(header.root,productPane);
    }
    @FXML
    public void logoutappear(MouseEvent e)
    {
        if(logoutbutton.getOpacity() == 0)
        {
            logoutbutton.setOpacity(1);
        }
        else
        {
            logoutbutton.setOpacity(0);
        }
    }
    @FXML
    public void logout(MouseEvent e)throws IOException
    {
        if(logoutbutton.getOpacity()==1) {
            EcomMain.emailId = "";
            logoutbutton.setOpacity(0);
            Header header = new Header();
            EcomMain.root.getChildren().add(header.root);
        }

    }
}
