/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmis.BO5.student;

import com.tecmic.B05.TecmisDB.TecmisDB;
import com.tecmic.B05.user.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class CourseMaterials {
    
    private int Material_ID;
    private String Material_name;
    private String coure_code;
    private String filePath;
    private String course_department_department_id;

    public String getCourse_department_department_id() {
        return course_department_department_id;
    }

    public void setCourse_department_department_id(String course_department_department_id) {
        this.course_department_department_id = course_department_department_id;
    }

    public String getMaterial_name() {
        return Material_name;
    }

    public void setMaterial_name(String Material_name) {
        this.Material_name = Material_name;
    }

    public int getMaterial_ID() {
        return Material_ID;
    }

    public void setMaterial_ID(int Material_ID) {
        this.Material_ID = Material_ID;
    }

    public String getCoure_code() {
        return coure_code;
    }

    public void setCoure_code(String coure_code) {
        this.coure_code = coure_code;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
 
    
     
     
     
        public  CourseMaterials get(String id) {
        
        CourseMaterials cm =new CourseMaterials();
        try {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT course_code,name,filePath FROM lecture_matireal WHERE course_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
             
               cm.setMaterial_ID(rs.getInt("Material_ID"));
               cm.setCoure_code(rs.getString("course_code"));
               cm.setFilePath(rs.getString("filePath"));
                cm.setMaterial_ID(rs.getInt("lecture_matireal_id"));
               cm.setMaterial_name(rs.getString("name"));
               cm.setCoure_code(rs.getString("	course_id"));
               cm.setFilePath(rs.getString("file_path"));
               cm.setCourse_department_department_id(rs.getString("course_department_department_id "));
               
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return cm;
    }
   
}
     
     
     
     
     
     
     
     
     
     
     
     

