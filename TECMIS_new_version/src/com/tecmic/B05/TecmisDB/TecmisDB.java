/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecmic.B05.TecmisDB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Vivobook
 */
public class TecmisDB {
    
    
    static Connection con;
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost/tecmis_db";
    static String uname = "root";
    static String pass = "1234";
    
    
    public static Connection getConnection()throws Exception{
        if(con == null){
            Class.forName(driver);
            con = DriverManager.getConnection(url, uname, pass);
        }
        return con;
        
    }
    
}
