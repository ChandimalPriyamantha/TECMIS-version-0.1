/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmis.BO5.student;

import com.tecmic.B05.TecmisDB.TecmisDB;
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
public class StudentAttendance
{
    private String student_id;
    private int attendence_id;
    private String type;
    private String state;
    private String date;
    private String course_id;
    private String lecturer_id;
    private int hour;
    
    
    Auth auth = Auth.getInstance();
    String usr = auth.getUsername();
    private String user=usr;

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
    
    public int getAttendence_id() {
        return attendence_id;
    }

    public void setAttendence_id(int attendence_id) {
        this.attendence_id = attendence_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getLecturer_id() {
        return lecturer_id;
    }

    public void setLecturer_id(String lecturer_id) {
        this.lecturer_id = lecturer_id;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

   
    
    
    public List<StudentAttendance> list() 
    {
        List<StudentAttendance> list = new ArrayList<StudentAttendance>();
        try{
           
           Connection con = TecmisDB.getConnection();
           String sql = "SELECT * FROM attendence where student_id='"+user+"'";
           PreparedStatement ps = con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()){
               StudentAttendance atnd = new StudentAttendance();
               atnd.setAttendence_id(rs.getInt("attendence_id"));
               atnd.setType(rs.getString("type"));
               atnd.setState(rs.getString("state"));
               atnd.setDate(rs.getString("date"));
               atnd.setCourse_id(rs.getString("course_id"));
               atnd.setLecturer_id(rs.getString("lecturer_id"));
               atnd.setHour(rs.getInt("hour"));
               atnd.setStudent_id(rs.getString("student_id"));
               
               list.add(atnd);
           }
           
       }catch(Exception e){
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, "ERROR");
       } 
    
           return list;
           
    }
}
