package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author microsoftm
 */
public class MySQLConnect {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/phone_book";
    private static final String USERNAME = "hirthik";
    private static final String PASSWORD = "abcd";
    
    /**
     * 
     * @return Connection
     * Returns a valid connection to phone_book DB if it can, otherwise it returns null.
     */
    
    public static Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
//            JOptionPane.showMessageDialog(null, "Connection Established!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Connection Failed: " + ex.getMessage());
        }
        return conn;
    }
}
