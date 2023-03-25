/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmis.BO5.student;

import com.tecmic.B05.TecmisDB.TecmisDB;
import com.tecmic.B05.admin.AdminForm;
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
    void Login(Student student) {
        try {
            Connection con =  TecmisDB.getConnection();
            String sql = "Select username, password from student where username=? and password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, student.getUserName());
            ps.setString(2, student.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
            JOptionPane.showMessageDialog(null, "You have successfully logged in");
            
            Auth auth=Auth.getInstance();
            auth.setUsername(student.getUserName());
            
            new StudentView().setVisible(true);
            
            
            
            
            }else{
             JOptionPane.showMessageDialog(null, "Wrong Username & Password");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");

        }
    }
    
}
