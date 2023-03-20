/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmic.B05.lecture;

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
public class LectureLoginImp implements LectureLogin {

    @Override
    public void LoginLecture(Lecture lecture) {
        //LectureView lecturV =  new LectureView();
        try {
            Connection con = TecmisDB.getConnection();
            String sql = "Select id , password from lecturer where id=? and password=?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lecture.getUserID());
            ps.setString(2, lecture.getPassword());
            
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
            JOptionPane.showMessageDialog(null, "You have successfully logged in");
           
           
            new LectureView().setVisible(true);
            //ecturV.loadDetails(lecture);
            
            
            
            
            
            
            }else{
             JOptionPane.showMessageDialog(null, "Wrong Username & Password");
             new TechmisView().setVisible(true);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        
        
    }
    
    
    
}
