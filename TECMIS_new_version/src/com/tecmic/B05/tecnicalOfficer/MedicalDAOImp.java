/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmic.B05.tecnicalOfficer;

import com.tecmic.B05.TecmisDB.TecmisDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ganidusahan
 */
public class MedicalDAOImp implements MedicalDAO{
    
    @Override
    public void save(Medical medical) {
        
        try{
            
            Connection con = TecmisDB.getConnection();
            String sql = "INSERT INTO medical(date,state,description,department_id,subject_code,student_id) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,medical.getDate());
            ps.setString(2,medical.getState());
            ps.setString(3,medical.getDescription());
            ps.setString(4,medical.getDepartment_id());
            ps.setString(5,medical.getSubject_code());
            ps.setString(6,medical.getStudent_id());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "SAVED!");
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR-medical-saved");
        }
        
    }

    @Override
    public void update(Medical medical) {
        
        try{
            
           Connection con = TecmisDB.getConnection();
           String sql = "UPDATE medical SET date=?,state=?,description=?,department_id=?,subject_code=?,student_id=? WHERE medical_id=?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1,medical.getDate());
           ps.setString(2,medical.getState());
           ps.setString(3,medical.getDescription());
           ps.setString(4,medical.getDepartment_id());
           ps.setString(5,medical.getSubject_code());
           ps.setString(6,medical.getStudent_id());
           ps.executeUpdate();
           
           
           JOptionPane.showMessageDialog(null, "UPDATED!");
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR-medical-update");
        }
        
    }

    @Override
    public void delete(Medical medical) {
        try{
           Connection con = TecmisDB.getConnection();
           String sql = "DELETE FROM medical WHERE medical_id=?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, medical.getMedical_id());
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null, "DELETED!");
           
            
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR-medical-delete");
        }
        
        
    }

    @Override
    public Medical get(int medical_id) {
        Medical med = new Medical();
        try{
           Connection con = TecmisDB.getConnection();
           String sql = "SELECT * FROM medical WHERE medical_id=?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1,medical_id);
           ResultSet rs = ps.executeQuery();
           if(rs.next()){
               med.setMedical_id(rs.getInt("medical_id"));
               med.setDate(rs.getString("date"));
               med.setState(rs.getString("state"));
               med.setDescription(rs.getString("description"));
               med.setDepartment_id(rs.getString("department_id"));
               med.setSubject_code(rs.getString("subject_code"));
               med.setStudent_id(rs.getString("student_id"));
               
           }
           
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR-medical-search");
        }
        return med;
        
        
    }

    @Override
    public List<Medical> list() {
        
        List<Medical> list = new ArrayList<Medical>();
        try{
           
           Connection con = TecmisDB.getConnection();
           String sql = "SELECT * FROM medical";
           PreparedStatement ps = con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()){
               Medical med = new Medical();
               med.setMedical_id(rs.getInt("medical_id"));
               med.setDate(rs.getString("date"));
               med.setState(rs.getString("state"));
               med.setDescription(rs.getString("description"));
               med.setDepartment_id(rs.getString("department_id"));
               med.setSubject_code(rs.getString("subject_code"));
               med.setStudent_id(rs.getString("student_id"));
               
               list.add(med);
           }
           
       }catch(Exception e){
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, "ERROR-medical-list");
       } 
        return list;
    }
       
}
    
