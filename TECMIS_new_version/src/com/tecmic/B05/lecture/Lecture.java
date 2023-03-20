/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecmic.B05.lecture;

import com.tecmic.B05.TecmisDB.TecmisDB;
import com.tecmic.B05.user.User;

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
public class Lecture extends User {
    
    
    public void updateDetaile(Lecture lecture){
       String sql;
       PreparedStatement ps;
             try {
            
           
            Connection con =  TecmisDB.getConnection();
            sql = "UPDATE lecturer SET id=?,nic=?,fname=?,mname=?,lname=?,birth_date=?,address=?,sex=?,phone_no=?,"
                    + "username=?,password=?,email=?,image_path=?,department_department_id=? WHERE id=?";
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, lecture.getUserID());
            ps.setString(2, lecture.getNIC());
            ps.setString(3, lecture.getFirstName());
            ps.setString(4, lecture.getMiddleName());
            ps.setString(5, lecture.getLastName());
            ps.setString(6, lecture.getBirthDate());
            ps.setString(7, lecture.getAddress());
            ps.setString(8, lecture.getSex());
            ps.setString(9, lecture.getPhoneNumner());
            ps.setString(10,lecture.getUserName());
            ps.setString(11,lecture.getPassword());
            ps.setString(12,lecture.getEmail());
            ps.setString(13,"E:\\Profile_pic\\Lecture\\'"+lecture.getUserID()+"'.png");
            ps.setString(14, lecture.getDepartmentID());
            ps.setString(15, lecture.getUserID() );
            ps.executeUpdate();
            
            
            
            JOptionPane.showMessageDialog(null, "Updated!");
            
        } catch (Exception e) {
            
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
       
           try{
              
            String file =lecture.getImagePathe(); 
            BufferedImage image = ImageIO.read(new File(file));
            ImageIO.write(image , "png", new File("E:\\Profile_pic\\Lecture\\'"+lecture.getUserID()+"'.png"));
               
           }catch(Exception e){
               
               JOptionPane.showMessageDialog(null, "Image Update Error!");
           }
               
    }
    
} 
  
