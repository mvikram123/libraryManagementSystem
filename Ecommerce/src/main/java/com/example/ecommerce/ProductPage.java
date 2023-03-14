package com.example.ecommerce;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductPage {
    ListView<HBox> products;

    ListView<HBox> productsbysearch(String search) throws SQLException {
        products = new ListView<>();
        ObservableList<HBox> productList = FXCollections.observableArrayList();
        ResultSet res = EcomMain.connection.executeQuery("select * from product");
        while (res.next()) {
            if (res.getString("productName").toLowerCase().contains(search.toLowerCase())) {
                Label name = new Label();
                Label price = new Label();
                Button buy = new Button();
                Label productId = new Label();
                name.setMinWidth(50);
                productId.setMinWidth(50);
                price.setMinWidth(50);
                buy.setText("Buy");

                HBox productsDetails = new HBox();
                buy.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (EcomMain.emailId.equals("")) {
                          //  System.out.println("please log in first");
                            Dialog<String> dialog=new Dialog<>();
                            dialog.setTitle("login");
                            ButtonType type=new ButtonType("OK" , ButtonBar.ButtonData.OK_DONE);
                            dialog.getDialogPane().getButtonTypes().add(type);
                            dialog.setContentText(" please log in first ");
                            dialog.showAndWait();
                        } else {
                            System.out.println("you are logged with" + EcomMain.emailId);
                            Order order = new Order();
                            try {
                                order.placeOrder(productId.getText());
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("Buy button is clicked");
                    }
                });

               products.setPrefHeight(350);
                products.setPrefWidth(300);
                name.setText(res.getString("productName"));
                price.setText(res.getString("price"));
                productId.setText(res.getString("productId"));
                productsDetails.getChildren().addAll(productId,name, price, buy);
                productList.add(productsDetails);
            }
        }
            products.setItems(productList);
            return products;
        }


        ListView<HBox> products () throws SQLException {
            products = new ListView<>();
            ObservableList<HBox> productList = FXCollections.observableArrayList();
            ResultSet res = EcomMain.connection.executeQuery("select * from product");
            while (res.next()) {
                Label name = new Label();
                Label price = new Label();
                Button buy = new Button();
                Label productId = new Label();
                name.setMinWidth(50);
                productId.setMinWidth(50);
                price.setMinWidth(50);
                buy.setText("Buy");

                HBox productsDetails = new HBox();
                buy.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (EcomMain.emailId.equals("")) {
                           // System.out.println("please log in first");
                            Dialog<String> dialog=new Dialog<>();
                            dialog.setTitle("login");
                            ButtonType type=new ButtonType("OK" , ButtonBar.ButtonData.OK_DONE);
                            dialog.getDialogPane().getButtonTypes().add(type);
                            dialog.setContentText(" please log in first ");
                            dialog.showAndWait();
                        } else {


                            System.out.println("you are logged with" + EcomMain.emailId);
                            Order order = new Order();
                            try {
                                order.placeOrder(productId.getText());
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                       // System.out.println("Buy button is clicked");
                    }
                });

               products.setPrefHeight(350);
                products.setPrefWidth(300);
                name.setText(res.getString("productName"));
                price.setText(res.getString("price"));
                productId.setText(res.getString("productId"));
                productsDetails.getChildren().addAll(productId,name, price, buy);
                productList.add(productsDetails);
            }

            products.setItems(productList);
            return products;
        }
    }
