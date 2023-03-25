/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmis.BO5.student;

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
 * @author ACER
 */
public class Studentmarks {
    
    private int mark_id;
    private String grade;
    private String level;
    private int assessment;
    private int quiz;
    private int course_id;
    private int sgpa;
    private int cgpa;
    private int mid_term;
    private int final_thoery;
    private int final_practical;
    private String student_id;
    private String student_department_department_id;
    
    Auth auth = Auth.getInstance();
    String usr = auth.getUsername();

    public int getMark_id() {
        return mark_id;
    }

    public void setMark_id(int mark_id) {
        this.mark_id = mark_id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getAssessment() {
        return assessment;
    }

    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }

    public int getQuiz() {
        return quiz;
    }

    public void setQuiz(int quiz) {
        this.quiz = quiz;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getSgpa() {
        return sgpa;
    }

    public void setSgpa(int sgpa) {
        this.sgpa = sgpa;
    }

    public int getCgpa() {
        return cgpa;
    }

    public void setCgpa(int cgpa) {
        this.cgpa = cgpa;
    }

    public int getMid_term() {
        return mid_term;
    }

    public void setMid_term(int mid_term) {
        this.mid_term = mid_term;
    }

    public int getFinal_thoery() {
        return final_thoery;
    }

    public void setFinal_thoery(int final_thoery) {
        this.final_thoery = final_thoery;
    }

    public int getFinal_practical() {
        return final_practical;
    }

    public void setFinal_practical(int final_practical) {
        this.final_practical = final_practical;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_department_department_id() {
        return student_department_department_id;
    }

    public void setStudent_department_department_id(String student_department_department_id) {
        this.student_department_department_id = student_department_department_id;
    }
    
    public List<Studentmarks> list() {
        
       List<Studentmarks> list = new ArrayList<Studentmarks>();
        try {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM mark where student_id='"+usr+"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
     
            while(rs.next()){
                Studentmarks Stmark = new Studentmarks();
                Stmark.setMark_id(rs.getInt("mark_id"));
                Stmark.setGrade(rs.getString("grade"));
                Stmark.setLevel(rs.getString("level")) ;
                Stmark.setAssessment(rs.getInt("assesment")) ;
                Stmark.setQuiz(rs.getInt("quiz")) ;
                Stmark.setCourse_id(rs.getInt("course_id")) ;
                Stmark.setSgpa(rs.getInt("sgpa")) ;
                Stmark.setCgpa(rs.getInt("cgpa")) ;
                Stmark.setMid_term(rs.getInt("mid_term")) ;
                Stmark.setFinal_thoery(rs.getInt("final_theory")) ;
                Stmark.setFinal_practical(rs.getInt("final_practicle")) ;
                Stmark.setStudent_id(rs.getString("student_id")) ;
                Stmark.setStudent_department_department_id(rs.getString("student_department_department_id")) ;
                
                 list.add(Stmark);
          
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
  
    
    }
}
