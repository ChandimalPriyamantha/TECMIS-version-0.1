/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmis.BO5.student;

import com.tecmic.B05.TecmisDB.TecmisDB;
import com.tecmic.B05.TecmisView.TechmisView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class StudentLoginImp extends StudentLogin{

    @Override
    void Login(Student st) {
        try {
            Connection con =  TecmisDB.getConnection();
            String sql = "Select id, password from student where id=? and password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, st.getUserName());
            ps.setString(2, st.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
              
            JOptionPane.showMessageDialog(null, "You have successfully logged in");
                     
                
             Auth auth=Auth.getInstance();
             auth.setUsername(st.getUserName());
              
            new StudentView().setVisible(true);
            
            }else{
             JOptionPane.showMessageDialog(null, "Wrong Username & Password");
              new TechmisView().setVisible(true);
             
            }
            
        } catch (Exception e) {
            System.out.println(e);    
                
        }
    }

   
    
}
