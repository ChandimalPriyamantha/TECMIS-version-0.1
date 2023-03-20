/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmic.B05.admin;

import com.tecmic.B05.TecmisDB.TecmisDB;
import com.tecmic.B05.TecmisView.TechmisView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Vivobook
 */
public class AdminLoginImp extends AdminLogin{

    @Override
    void Login(Admin admin) {
        
        try {
            Connection con =  TecmisDB.getConnection();
            String sql = "Select username, password from admin where username=? and password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, admin.getUserName());
            ps.setString(2, admin.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
            JOptionPane.showMessageDialog(null, "You have successfully logged in");
            new AdminForm().setVisible(true);
            
            
            
            
            }else{
             JOptionPane.showMessageDialog(null, "Wrong Username & Password");
              new TechmisView().setVisible(true);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }

   
    

   
        
    }
    

