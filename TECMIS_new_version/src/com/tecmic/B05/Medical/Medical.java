/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmic.B05.Medical;

import com.tecmic.B05.TecmisDB.TecmisDB;
import com.tecmis.B05.notice.Notice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Vivobook
 */
public class Medical {
    
    private String medicalID;
    private String date;
    private String subjectCode;
    private String departmentId;
    private String description;
    private String student_id;
    private String state;
    private String file_path;

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
    

    public String getMedicalID() {
        return medicalID;
    }

    public void setMedicalID(String medicalID) {
        this.medicalID = medicalID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    public List<Medical> list() {
        
       List<Medical> list = new ArrayList<Medical>();
        try {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM medical";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
               
                Medical medical = new Medical();
                
                medical.setMedicalID(rs.getString("medical_id"));
                medical.setDate(rs.getString("date"));
                medical.setState(rs.getString("state"));
                medical.setDescription(rs.getString("description"));
                medical.setDepartmentId(rs.getString("department_id"));
                medical.setSubjectCode(rs.getString("subject_code"));
                medical.setStudent_id(rs.getString("student_id"));
                
                
 
                list.add(medical);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
  
    
    }
    
    public Medical get(String id) {
        Medical medical = new Medical();
        try {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM medical WHERE medical_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                setMedicalID(rs.getString("medical_id"));
                setDate(rs.getString("date"));
                setState(rs.getString("state"));
                setDescription(rs.getString("description"));
                setDepartmentId(rs.getString("department_id"));
                setSubjectCode(rs.getString("subject_code"));
                setStudent_id(rs.getString("student_id"));
                setFile_path(rs.getString("file_path"));
 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return medical;
    }
    
    
}
