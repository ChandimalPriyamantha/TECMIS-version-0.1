/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmic.B05.tecnicalOfficer;
import com.tecmic.B05.TecmisDB.TecmisDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ganidusahan
 */
public class TecnicalOfficerLoginImp extends TecnicalOfficerLogin{

    @Override
    void Login(TecnicalOfficer tecnicalOfficer) {
        try{
            
            Connection con =  TecmisDB.getConnection();
            String sql = "Select username, password from technical_officer where username=? and password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tecnicalOfficer.getUserName());
            ps.setString(2, tecnicalOfficer.getPassword());
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "You have successfully logged in");
                
                Auth auth = Auth.getInstance();
                auth.setUsername(tecnicalOfficer.getUserName());
                
                new TecnicalOfficerForm().setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong Username & Password");
            }
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error-loginImp");
        }
    }
    
}
