/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecmic.B05.tecnicalOfficer;

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
public class TecnicalOfficer extends User {
    
    public void editProfile(TecnicalOfficer tecnicalofficer){
       String sql;
       PreparedStatement ps;
       try{
       Connection con =  TecmisDB.getConnection();
            sql = "UPDATE technical_officer SET id=?,nic=?,fname=?,mname=?,lname=?,birth_date=?,address=?,sex=?,phone_no=?,username=?,password=?,email=?,image_path=?,department_department_id=? WHERE id=?";
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, tecnicalofficer.getUserID());
            ps.setString(2, tecnicalofficer.getNIC());
            ps.setString(3, tecnicalofficer.getFirstName());
            ps.setString(4, tecnicalofficer.getMiddleName());
            ps.setString(5, tecnicalofficer.getLastName());
            ps.setString(6, tecnicalofficer.getBirthDate());
            ps.setString(7, tecnicalofficer.getAddress());
            ps.setString(8, tecnicalofficer.getSex());
            ps.setString(9, tecnicalofficer.getPhoneNumner());
            ps.setString(10, tecnicalofficer.getUserName());
            ps.setString(11, tecnicalofficer.getPassword());
            ps.setString(12, tecnicalofficer.getEmail());
            ps.setString(13, "E:\\Profile_pic\\TechnicalOfficer\\'"+tecnicalofficer.getUserID()+"'.png");
            ps.setString(14, tecnicalofficer.getDepartmentID());
            ps.setString(15, tecnicalofficer.getUserID());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
       
       try{
              
            String file = tecnicalofficer.getImagePathe(); 
            BufferedImage image = ImageIO.read(new File(file));
            ImageIO.write(image , "png", new File("E:\\Profile_pic\\TechnicalOfficer\\'"+tecnicalofficer.getUserID()+"'.png"));
               
           }catch(Exception e){
               
               JOptionPane.showMessageDialog(null, "Image Update Error!");
           }
       
    }
    
    
}
