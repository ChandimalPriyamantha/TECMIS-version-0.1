package com.tecmis.BO5.student;


import com.tecmic.B05.TecmisDB.TecmisDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class StudentMedical {
    private int medical_id;
    private String date;
    private String state;
    private String description;
    private String department_id;
    private String subject_code;
    private String student_id;
    
    Auth auth = Auth.getInstance();
    String usr = auth.getUsername();

    public int getMedical_id() {
        return medical_id;
    }

    public void setMedical_id(int medical_id) {
        this.medical_id = medical_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
    
    public List<StudentMedical> list() {
        
       List<StudentMedical> list = new ArrayList<StudentMedical>();
        try {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM medical where student_id='"+usr+"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                StudentMedical medical = new StudentMedical();
                medical.setMedical_id(rs.getInt("medical_id"));
                medical.setDate(rs.getString("date"));
                medical.setSubject_code(rs.getString("subject_code"));
                medical.setDescription(rs.getString("description"));
                medical.setState(rs.getString("state"));
                medical.setDepartment_id(rs.getString("student_department_department_id"));
                medical.setStudent_id(rs.getString("student_id"));
 
                list.add(medical);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }
    
}
