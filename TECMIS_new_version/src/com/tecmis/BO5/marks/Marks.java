/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmis.BO5.marks;

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
public class Marks {
    
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
    private int level;
    private String semester;
    private String studentID;

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getQuize_04() {
        return Quize_04;
    }

    public void setQuize_04(int Quize_04) {
        this.Quize_04 = Quize_04;
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
    
    
    public List<Marks> list() {
        
       List<Marks> list = new ArrayList<Marks>();
        try {
            
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM mark";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                
                Marks marks = new Marks();
                marks.setStudentID(rs.getString("student_id"));
                marks.setDepartmentID(rs.getString("student_department_department_id"));
                marks.setCourseID(rs.getString("course_id"));
                marks.setLevel(rs.getInt("level"));
                marks.setSemester(rs.getString("semester"));
                marks.setQuize_01(rs.getInt("Quiz_01"));
                marks.setQuize_02(rs.getInt("Quiz_02"));
                marks.setQuize_03(rs.getInt("Quiz_03"));
                marks.setQuize_04(rs.getInt("Quiz_04"));
                marks.setMidterm(rs.getInt("mid_term"));
                marks.setAssesment_01(rs.getInt("Assignment_01"));
                marks.setAssesment_02(rs.getInt("Assignment_02"));
                marks.setFinalPracticle(rs.getInt("final_practical"));
                marks.setFinalTheory(rs.getInt("final_theory"));
                
 
                list.add(marks);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
  
    
    }
    
      public Marks get(int id) {
         Marks marks = new Marks();
        try {
            
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM notice WHERE notice_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                setStudentID(rs.getString("student_id"));
                setDepartmentID(rs.getString("student_department_department_id"));
                setCourseID(rs.getString("course_id"));
                setLevel(rs.getInt("level"));
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
 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return marks;
    }
    
    
    
}
