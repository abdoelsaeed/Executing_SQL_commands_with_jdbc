package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class coonection {
static String user="root";
static String password="";
static String host="jdbc:mysql://localhost/jdbcc";
static Connection connectionobj;
public static Connection getCoonection(){
    try {
        connectionobj = DriverManager.getConnection(host, user, password);
        System.out.println("Connection with jdbcc Database Done ## "); }
    catch (SQLException ex){
        ex.printStackTrace();
    }

    return connectionobj;
}
}
