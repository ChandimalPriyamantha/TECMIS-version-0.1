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
    private String level;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
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
                marks.setLevel(rs.getString("level"));
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
    
      public Marks get(String sid, String cid) {
         Marks marks = new Marks();
        try {
            
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM mark WHERE student_id=? AND course_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sid);
            ps.setString(2, cid);
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
 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return marks;
    }
      
      
       public void InsertMarks(Marks marks){
       
       try {
            Connection con =  TecmisDB.getConnection();
            String sql = "INSERT INTO mark(student_id,student_department_department_id,course_id,level,semester ,Quiz_01,Quiz_02,Quiz_03,Quiz_04,Mid_term,Assignment_01,Assignment_02,final_practical,final_theory) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, marks.getStudentID());
            ps.setString(2, marks.getDepartmentID());
            ps.setString(3, marks.getCourseID());
            ps.setString(4, marks.getLevel());
            ps.setString(5, marks.getSemester());
            ps.setInt(6, marks.getQuize_01());
            ps.setInt(7, marks.getQuize_02());
            ps.setInt(8, marks.getQuize_03());
            ps.setInt(9, marks.getQuize_04());
            ps.setInt(10, marks.getMidterm());
            ps.setInt(11, marks.getAssesment_01());
            ps.setInt(12, marks.getAssesment_02());
            ps.setInt(13, marks.getFinalPracticle());
            ps.setInt(14, marks.getFinalTheory());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
   
   }
       
       
       
       public void UpdateMarks(Marks marks){
       
       try {
            Connection con =  TecmisDB.getConnection();
            String sql = "UPDATE  mark SET student_id=?,student_department_department_id=?,course_id=?,level=?,semester=? ,Quiz_01=?,Quiz_02=?,Quiz_03=?,Quiz_04=?,Mid_term=?,Assignment_01=?,Assignment_02=?,final_practical=?,final_theory=? WHERE student_id=? AND course_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, marks.getStudentID());
            ps.setString(2, marks.getDepartmentID());
            ps.setString(3, marks.getCourseID());
            ps.setString(4, marks.getLevel());
            ps.setString(5, marks.getSemester());
            ps.setInt(6, marks.getQuize_01());
            ps.setInt(7, marks.getQuize_02());
            ps.setInt(8, marks.getQuize_03());
            ps.setInt(9, marks.getQuize_04());
            ps.setInt(10, marks.getMidterm());
            ps.setInt(11, marks.getAssesment_01());
            ps.setInt(12, marks.getAssesment_02());
            ps.setInt(13, marks.getFinalPracticle());
            ps.setInt(14, marks.getFinalTheory());
            ps.setString(15, marks.getStudentID());
             ps.setString(16, marks.getCourseID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
   
   }
    
   public void markDelete(){
    
       try {
          
            Connection con = TecmisDB.getConnection();
            String sql = "delete from mark  WHERE  student_id=? AND course_id=? ";
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setString(1, getStudentID());
            ps.setString(2, getCourseID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleted!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
   
   }
    
    
}
