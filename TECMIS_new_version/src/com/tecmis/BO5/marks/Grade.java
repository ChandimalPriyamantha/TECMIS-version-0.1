/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmis.BO5.marks;

import com.tecmic.B05.TecmisDB.TecmisDB;
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
public class Grade {
    
    
    private String DepartmentID;
    private String CourseID;
    private int Quize_01;
    private int Quize_02;
    private int Quize_03;
    private int Quize_04;
    private int assesment_01;
    private int assesment_02;
    private int finalTheory;
    private int finalPracticle;
    private int midterm;
    private String level;
    private String semester;
    private String studentID;
    private int type;
    private double gpa_value;

    public double getGpa_value() {
    return gpa_value;
    }

    public void setGpa_value(double gpa_value) {
        this.gpa_value = gpa_value;
    }

    public String getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(String DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String CourseID) {
        this.CourseID = CourseID;
    }

    public int getQuize_01() {
        return Quize_01;
    }

    public void setQuize_01(int Quize_01) {
        this.Quize_01 = Quize_01;
    }

    public int getQuize_02() {
        return Quize_02;
    }

    public void setQuize_02(int Quize_02) {
        this.Quize_02 = Quize_02;
    }

    public int getQuize_03() {
        return Quize_03;
    }

    public void setQuize_03(int Quize_03) {
        this.Quize_03 = Quize_03;
    }

    public int getQuize_04() {
        return Quize_04;
    }

    public void setQuize_04(int Quize_04) {
        this.Quize_04 = Quize_04;
    }

    public int getAssesment_01() {
        return assesment_01;
    }

    public void setAssesment_01(int assesment_01) {
        this.assesment_01 = assesment_01;
    }

    public int getAssesment_02() {
        return assesment_02;
    }

    public void setAssesment_02(int assesment_02) {
        this.assesment_02 = assesment_02;
    }

    public int getFinalTheory() {
        return finalTheory;
    }

    public void setFinalTheory(int finalTheory) {
        this.finalTheory = finalTheory;
    }

    public int getFinalPracticle() {
        return finalPracticle;
    }

    public void setFinalPracticle(int finalPracticle) {
        this.finalPracticle = finalPracticle;
    }

    public int getMidterm() {
        return midterm;
    }

    public void setMidterm(int midterm) {
        this.midterm = midterm;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    
    public List<Grade> list(String sid) {
        
       List<Grade> list = new ArrayList<Grade>();
        try {
            
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM mark where student_id=?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sid);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                
                Grade grade = new Grade();
                grade.setStudentID(rs.getString("student_id"));
                grade.setDepartmentID(rs.getString("student_department_department_id"));
                grade.setCourseID(rs.getString("course_id"));
                grade.setLevel(rs.getString("level"));
                grade.setSemester(rs.getString("semester"));
                grade.setQuize_01(rs.getInt("Quiz_01"));
                grade.setQuize_02(rs.getInt("Quiz_02"));
                grade.setQuize_03(rs.getInt("Quiz_03"));
                grade.setQuize_04(rs.getInt("Quiz_04"));
                grade.setMidterm(rs.getInt("mid_term"));
                grade.setAssesment_01(rs.getInt("Assignment_01"));
                grade.setAssesment_02(rs.getInt("Assignment_02"));
                grade.setFinalPracticle(rs.getInt("final_practical"));
                grade.setFinalTheory(rs.getInt("final_theory"));
                grade.setType(rs.getInt("Type"));
                grade.setGpa_value(rs.getInt("gpa_value"));
                
 
                list.add(grade);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
  
    
    }
    
    
    
    public Grade get(String sid) {
         Grade grade = new Grade();
        try {
            
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM mark WHERE student_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sid);
           
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                setStudentID(rs.getString("student_id"));
                setDepartmentID(rs.getString("student_department_department_id"));
                setCourseID(rs.getString("course_id"));
                setLevel(rs.getString("level"));
                setSemester(rs.getString("semester"));
                setQuize_01(rs.getInt("Quiz_01"));
                setQuize_02(rs.getInt("Quiz_02"));
                setQuize_03(rs.getInt("Quiz_03"));
                setQuize_04(rs.getInt("Quiz_04"));
                setMidterm(rs.getInt("mid_term"));
                setAssesment_01(rs.getInt("Assignment_01"));
                setAssesment_02(rs.getInt("Assignment_02"));
                setFinalPracticle(rs.getInt("final_practical"));
                setFinalTheory(rs.getInt("final_theory"));
                setGpa_value(rs.getInt("gpa_value"));
 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return grade;
    }
      
    
}
