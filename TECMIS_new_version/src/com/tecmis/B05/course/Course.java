/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmis.B05.course;

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
public class Course {
    
    private String courseID;
    private String courseName;
    private int credit;
    private String courseType;
    private int level;
    private String departmentID;

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
    public List<Course> list() {
        
       List<Course> list = new ArrayList<Course>();
        try {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM course";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                Course course= new Course();
                course.setCourseID(rs.getString("course_id"));
                course.setLevel(rs.getInt("level"));
                course.setCredit(rs.getInt("credit"));
                course.setCourseName(rs.getString("course_name"));
                course.setCourseType(rs.getString("course_type"));
                course.setDepartmentID(rs.getString("department_department_id"));
                
 
                list.add( course);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
  
    
    }
    
      public  Course get(String id) {
        Course course = new Course();
        try {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM course WHERE course_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                setCourseID(rs.getString("course_id"));
                setLevel(rs.getInt("level"));
                setCredit(rs.getInt("credit"));
                setCourseName(rs.getString("course_name"));
                setCourseType(rs.getString("course_type"));
                setDepartmentID(rs.getString("department_department_id"));
               System.out.println(getCourseName());
 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return course;
    }
   
}
