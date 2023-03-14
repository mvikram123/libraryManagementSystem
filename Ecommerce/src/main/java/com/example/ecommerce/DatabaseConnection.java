package com.example.ecommerce;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class DatabaseConnection {

             Connection con=null;
                String sqlurl="jdbc:mysql://localhost:3306/Ecommerce?useSSL=false";
                String username="root";
                String password="Vikram@123";
                DatabaseConnection() throws SQLException
                {
                    con=getConnection(sqlurl,username,password);
                    if(con!=null)
                    {
                        System.out.println("our conection is established with the database");
                    }
                }
                public ResultSet executeQuery(String query) throws SQLException {
                    ResultSet result=null;
                    try {

                        Statement statement = con.createStatement();
                         result =  statement.executeQuery(query);
                        return result;

                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    return result;
                }
                public int executeUpdate(String query) throws SQLException
                {
                    int row = 0;
                    try {

                        Statement statement = con.createStatement();
                        row =  statement.executeUpdate(query);
                        return row;

                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    return row;
                }

}
