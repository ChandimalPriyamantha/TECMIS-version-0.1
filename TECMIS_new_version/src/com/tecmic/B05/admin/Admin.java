/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmic.B05.admin;

import com.tecmic.B05.TecmisDB.TecmisDB;
import com.tecmic.B05.user.User;
import com.tecmis.B05.course.Course;
import com.tecmis.B05.notice.Notice;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;


import javax.swing.JOptionPane;


/**
 *
 * @author Vivobook
 */
public class Admin extends User{
    
   public void CrateNotice(Notice notice ){
      
        try {
            Connection con =  TecmisDB.getConnection();
            String sql = "INSERT INTO notice(file_path,title,date_and_time,discripsion) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, notice.getFilePath());
            ps.setString(2, notice.getTitle());
            ps.setString(3, notice.getDate_Time());
            ps.setString(4, notice.getDescription());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
   }
   
   
   public void EditNotice(Notice notice){
       
   
       try {
          
            Connection con = TecmisDB.getConnection();
            String sql = "UPDATE notice SET file_path=?,title=?,date_and_time=?, discripsion=? WHERE notice_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, notice.getFilePath());
            ps.setString(2, notice.getTitle());
            ps.setString(3, notice.getDate_Time());
            ps.setString(4, notice.getDescription());
             ps.setString(5, notice.getNoticeID());
            ps.executeUpdate();
 
        
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
   
   }
   
   
   public void deleteNotice(Notice notice){
       
       try {
          
            Connection con = TecmisDB.getConnection();
            String sql = "delete from notice  WHERE notice_id=?";
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setString(1, notice.getNoticeID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleteddd!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
   
   }
   
   public void CreateCourse(Course course){
       
       try {
            Connection con =  TecmisDB.getConnection();
            String sql = "INSERT INTO course(course_id,level,credit,course_name,course_type,department_department_id) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, course.getCourseID());
            ps.setInt(2, course.getLevel());
            ps.setInt(3, course.getCredit());
            ps.setString(4, course.getCourseName());
            ps.setString(5, course.getCourseType());
            ps.setString(6, course.getDepartmentID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
   
   }
   
   
   public void updateCourse(Course course){
   
         try {
            Connection con =  TecmisDB.getConnection();
            String sql = "UPDATE course SET course_id=?,level=?,credit=?, course_name=?, course_type=?,department_department_id=?  WHERE course_id=? ";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, course.getCourseID());
            ps.setInt(2, course.getLevel());
            ps.setInt(3, course.getCredit());
            ps.setString(4, course.getCourseName());
            ps.setString(5, course.getCourseType());
            ps.setString(6, course.getDepartmentID());
            ps.setString(7, course.getCourseID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
   
   }
   
   
  public void DeleteCourse(Course course){
  
           try {
          
            Connection con = TecmisDB.getConnection();
            String sql = "delete from course  WHERE course_id=?";
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setString(1, course.getCourseID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleteddd!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
  
  }
  
 
  
  public void CreatUser(Admin admin){
       
       
       String sql;
       PreparedStatement ps;
       if(admin.getLogingState() == "technical_officer"){
       try {
            
           
            Connection con =  TecmisDB.getConnection();
            sql = "INSERT INTO technical_officer(id,nic,fname,mname,lname,birth_date,address,sex,phone_no,username,password,email,image_path,department_department_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, admin.getUserID());
            ps.setString(2, admin.getNIC());
            ps.setString(3, admin.getFirstName());
            ps.setString(4, admin.getMiddleName());
            ps.setString(5, admin.getLastName());
            ps.setString(6, admin.getBirthDate());
            ps.setString(7, admin.getAddress());
            ps.setString(8, admin.getSex());
            ps.setString(9, admin.getPhoneNumner());
            ps.setString(10, admin.getUserName());
            ps.setString(11, admin.getPassword());
            ps.setString(12, admin.getEmail());
            ps.setString(13, "E:\\Profile_pic\\TechnicalOfficer\\'"+admin.getUserID()+"'.png");
            ps.setString(14, admin.getDepartmentID());
            ps.executeUpdate();
            
            
           
            
            JOptionPane.showMessageDialog(null, "Saved!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
       
       try{
              
            String file = admin.getImagePathe(); 
            BufferedImage image = ImageIO.read(new File(file));
            ImageIO.write(image , "png", new File("E:\\Profile_pic\\TechnicalOfficer\\'"+admin.getUserID()+"'.png"));
               
           }catch(Exception e){
               
               JOptionPane.showMessageDialog(null, "Image Update Error!");
           }
      
       }else if(admin.getLogingState() == "lecture"){
           
           try {
            
           
            Connection con =  TecmisDB.getConnection();
            sql = "INSERT INTO lecturer(id,nic,fname,mname,lname,birth_date,address,sex,phone_no,username,password,email,image_path,department_department_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, admin.getUserID() );
            ps.setString(2, admin.getNIC());
            ps.setString(3, admin.getFirstName());
            ps.setString(4, admin.getMiddleName());
            ps.setString(5, admin.getLastName());
            ps.setString(6, admin.getBirthDate());
            ps.setString(7, admin.getAddress());
            ps.setString(8, admin.getSex());
            ps.setString(9, admin.getPhoneNumner());
            ps.setString(10,admin.getUserName());
            ps.setString(11,admin.getPassword());
            ps.setString(12,admin.getEmail());
            ps.setString(13,"E:\\Profile_pic\\Lecture\\'"+admin.getUserID()+"'.png");
            ps.setString(14, admin.getDepartmentID());
            ps.executeUpdate();
            
            
            
            JOptionPane.showMessageDialog(null, "Saved!");
            
        } catch (Exception e) {
            
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
       
           try{
              
            String file = admin.getImagePathe(); 
            BufferedImage image = ImageIO.read(new File(file));
            ImageIO.write(image , "png", new File("E:\\Profile_pic\\Lecture\\'"+admin.getUserID()+"'.png"));
               
           }catch(Exception e){
               
               JOptionPane.showMessageDialog(null, "Image Update Error!");
           }
           
       }else if(admin.getLogingState() == "student"){
           
           try {
            
           
            Connection con =  TecmisDB.getConnection();
            sql = "INSERT INTO student(id,nic,fname,mname,lname,birth_date,address,sex,phone_no,username,password,email,image_path,level,department_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, admin.getUserID() );
            ps.setString(2, admin.getNIC());
            ps.setString(3, admin.getFirstName());
            ps.setString(4, admin.getMiddleName());
            ps.setString(5, admin.getLastName());
            ps.setString(6, admin.getBirthDate());
            ps.setString(7, admin.getAddress());
            ps.setString(8, admin.getSex());
            ps.setString(9, admin.getPhoneNumner());
            ps.setString(10,admin.getUserName());
            ps.setString(11,admin.getPassword());
            ps.setString(12,admin.getEmail());
            ps.setString(13,"E:\\Profile_pic\\Student\\'"+admin.getUserID()+"'.png");
            ps.setString(14,admin.getLevel());
            ps.setString(15,admin.getDepartmentID());
            ps.executeUpdate();
            
           JOptionPane.showMessageDialog(null, "Saved!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
           
           try{
              
            String file = admin.getImagePathe(); 
            BufferedImage image = ImageIO.read(new File(file));
            ImageIO.write(image , "png", new File("E:\\Profile_pic\\Student\\'"+admin.getUserID()+"'.png"));
               
           }catch(Exception e){
               
               JOptionPane.showMessageDialog(null, "Image Update Error!");
           }
           
       
       }else if(admin.getLogingState() == "admin"){
                
           try {
            
           
            Connection con =  TecmisDB.getConnection();
            sql = "INSERT INTO admin(id,nic,fname,mname,lname,birth_date,address,sex,phone_no,username,password,email,image_path) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, admin.getUserID() );
            ps.setString(2, admin.getNIC());
            ps.setString(3, admin.getFirstName());
            ps.setString(4, admin.getMiddleName());
            ps.setString(5, admin.getLastName());
            ps.setString(6, admin.getBirthDate());
            ps.setString(7, admin.getAddress());
            ps.setString(8, admin.getSex());
            ps.setString(9, admin.getPhoneNumner());
            ps.setString(10, admin.getUserName());
            ps.setString(11, admin.getPassword());
            ps.setString(12, admin.getEmail());
            ps.setString(13, "E:\\Profile_pic\\Admin\\'"+admin.getUserID()+"'.png");
            //ps.setString(14, admin.getDepartmentID());
            ps.executeUpdate();
            
           
            
            JOptionPane.showMessageDialog(null, "Saved!");
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
           
        try{
              
            String file = admin.getImagePathe(); 
            
            BufferedImage image = ImageIO.read(new File(file));
            ImageIO.write(image , "png", new File("E:\\Profile_pic\\Admin\\'"+admin.getUserID()+"'.png"));
               
           }catch(Exception e){
               
               JOptionPane.showMessageDialog(null, "Image Update Error!");
           }
                    
       }
  }
  
  
  
  public void UpdateUser(Admin admin){
       
       
       String sql;
       PreparedStatement ps;
       if(admin.getLogingState() == "technical_officer"){
       try {
            //UPDATE notice SET file_path=?,title=?,date_and_time=?, discripsion=? WHERE notice_id=?
           
            Connection con =  TecmisDB.getConnection();
            sql = "UPDATE technical_officer SET id=?,nic=?,fname=?,mname=?,lname=?,birth_date=?,address=?,sex=?,phone_no=?,username=?,password=?,email=?,image_path=?,department_department_id=? WHERE id=?";
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, admin.getUserID());
            ps.setString(2, admin.getNIC());
            ps.setString(3, admin.getFirstName());
            ps.setString(4, admin.getMiddleName());
            ps.setString(5, admin.getLastName());
            ps.setString(6, admin.getBirthDate());
            ps.setString(7, admin.getAddress());
            ps.setString(8, admin.getSex());
            ps.setString(9, admin.getPhoneNumner());
            ps.setString(10, admin.getUserName());
            ps.setString(11, admin.getPassword());
            ps.setString(12, admin.getEmail());
            ps.setString(13, "E:\\Profile_pic\\TechnicalOfficer\\'"+admin.getUserID()+"'.png");
            ps.setString(14, admin.getDepartmentID());
            ps.setString(15, admin.getUserID());
            ps.executeUpdate();
            
            
           
            
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
       
       try{
              
            String file = admin.getImagePathe(); 
            BufferedImage image = ImageIO.read(new File(file));
            ImageIO.write(image , "png", new File("E:\\Profile_pic\\TechnicalOfficer\\'"+admin.getUserID()+"'.png"));
               
           }catch(Exception e){
               
               JOptionPane.showMessageDialog(null, "Image Update Error!");
           }
      
       }else if(admin.getLogingState() == "lecture"){
           
           try {
            
           
            Connection con =  TecmisDB.getConnection();
            sql = "UPDATE lecturer SET id=?,nic=?,fname=?,mname=?,lname=?,birth_date=?,address=?,sex=?,phone_no=?,"
                    + "username=?,password=?,email=?,image_path=?,department_department_id=? WHERE id=?";
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, admin.getUserID());
            ps.setString(2, admin.getNIC());
            ps.setString(3, admin.getFirstName());
            ps.setString(4, admin.getMiddleName());
            ps.setString(5, admin.getLastName());
            ps.setString(6, admin.getBirthDate());
            ps.setString(7, admin.getAddress());
            ps.setString(8, admin.getSex());
            ps.setString(9, admin.getPhoneNumner());
            ps.setString(10,admin.getUserName());
            ps.setString(11,admin.getPassword());
            ps.setString(12,admin.getEmail());
            ps.setString(13,"E:\\Profile_pic\\Lecture\\'"+admin.getUserID()+"'.png");
            ps.setString(14, admin.getDepartmentID());
            ps.setString(15, admin.getUserID() );
            ps.executeUpdate();
            
            
            
            JOptionPane.showMessageDialog(null, "Updated!");
            
        } catch (Exception e) {
            
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
       
           try{
              
            String file = admin.getImagePathe(); 
            BufferedImage image = ImageIO.read(new File(file));
            ImageIO.write(image , "png", new File("E:\\Profile_pic\\Lecture\\'"+admin.getUserID()+"'.png"));
               
           }catch(Exception e){
               
               JOptionPane.showMessageDialog(null, "Image Update Error!");
           }
           
       }else if(admin.getLogingState() == "student"){
           
           try {
            
           
            Connection con =  TecmisDB.getConnection();
            sql = "UPDATE student SET id=?,nic=?,fname=?,mname=?,lname=?,birth_date=?,address=?,sex=?,phone_no=?,"
                    + "username=?,password=?,email=?,image_path=?,level=?,department_id=? WHERE id=?";
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, admin.getUserID());
            ps.setString(2, admin.getNIC());
            ps.setString(3, admin.getFirstName());
            ps.setString(4, admin.getMiddleName());
            ps.setString(5, admin.getLastName());
            ps.setString(6, admin.getBirthDate());
            ps.setString(7, admin.getAddress());
            ps.setString(8, admin.getSex());
            ps.setString(9, admin.getPhoneNumner());
            ps.setString(10,admin.getUserName());
            ps.setString(11,admin.getPassword());
            ps.setString(12,admin.getEmail());
            ps.setString(13,"E:\\Profile_pic\\Student\\'"+admin.getUserID()+"'.png");
            ps.setString(14,admin.getLevel());
            ps.setString(15,admin.getDepartmentID());
            ps.setString(16, admin.getUserID());
            ps.executeUpdate();
            
           JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
           
           try{
              
            String file = admin.getImagePathe(); 
            BufferedImage image = ImageIO.read(new File(file));
            ImageIO.write(image , "png", new File("E:\\Profile_pic\\Student\\'"+admin.getUserID()+"'.png"));
               
           }catch(Exception e){
               
               JOptionPane.showMessageDialog(null, "Image Update Error!");
           }
           
       
       }else if(admin.getLogingState() == "admin"){
                
           try {
            
           
            Connection con =  TecmisDB.getConnection();
             sql = "UPDATE admin SET id=?,nic=?,fname=?,mname=?,lname=?,birth_date=?,address=?,sex=?,phone_no=?,"
                    + "username=?,password=?,email=?,image_path=? WHERE id=?";
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, admin.getUserID());
            ps.setString(2, admin.getNIC());
            ps.setString(3, admin.getFirstName());
            ps.setString(4, admin.getMiddleName());
            ps.setString(5, admin.getLastName());
            ps.setString(6, admin.getBirthDate());
            ps.setString(7, admin.getAddress());
            ps.setString(8, admin.getSex());
            ps.setString(9, admin.getPhoneNumner());
            ps.setString(10, admin.getUserName());
            ps.setString(11, admin.getPassword());
            ps.setString(12, admin.getEmail());
            ps.setString(13, "E:\\Profile_pic\\Admin\\'"+admin.getUserID()+"'.png");
            ps.setString(14, admin.getUserID());
            //ps.setString(14, admin.getDepartmentID());
            ps.executeUpdate();
            
           
            
            JOptionPane.showMessageDialog(null, "Updated!");
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
           
        try{
              
            String file = admin.getImagePathe(); 
            
            BufferedImage image = ImageIO.read(new File(file));
            ImageIO.write(image , "png", new File("E:\\Profile_pic\\Admin\\'"+admin.getUserID()+"'.png"));
               
           }catch(Exception e){
               
               JOptionPane.showMessageDialog(null, "Image Update Error!");
           }
                    
       }
  }
  
  
  public void DeleteUser(Admin admin){
    
      if(admin.getLogingState()=="admin"){
      
          
            try {
          
            Connection con = TecmisDB.getConnection();
            String sql = "delete from admin  WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setString(1, admin.getUserID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleteddd!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
      
      }else if(admin.getLogingState() == "student"){
      
          
           try {
          
            Connection con = TecmisDB.getConnection();
            String sql = "delete from student  WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setString(1, admin.getUserID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleteddd!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
      
      }else if (admin.getLogingState() == "lecture"){
      
          
          try {
          
            Connection con = TecmisDB.getConnection();
            String sql = "delete from lecturer  WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setString(1, admin.getUserID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleteddd!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
      
      }else if (admin.getLogingState() == "technical_officer"){
          
          try {
          
            Connection con = TecmisDB.getConnection();
            String sql = "delete from technical_officer  WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setString(1, admin.getUserID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleteddd!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
      
      }
     
     
  
  }
   
   
}
   
   
  
    
