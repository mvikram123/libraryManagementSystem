package com.example.ecommerce;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

public class Order {
    void placeOrder(String productId) throws SQLException {
        ResultSet res=EcomMain.connection.executeQuery("select max(orderId) as orderId from orders");
        int orderId=1;
        if(res.next())
        {
            orderId=res.getInt("orderId")+1;

        }
        Date date=new Date(Calendar.getInstance().getTime().getTime());
        Timestamp ts= new Timestamp(Calendar.getInstance().getTime().getTime());
        System.out.println(date.toString());
        System.out.println(ts.toString());

        String query=String.format("insert into orders values(%s,%s,'%s','%s')" , orderId, productId,EcomMain.emailId,ts);
        int response=EcomMain.connection.executeUpdate(query);
        if(response>0)
        {
          //  System.out.println("the order is palced");
            Dialog<String> dialog=new Dialog<>();
            dialog.setTitle("Ordere");
            ButtonType type=new ButtonType("OK" , ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.setContentText("ordered is placed");
            dialog.showAndWait();
        }
        else {
            System.out.println("the order is not placed");
        }
    }
}
