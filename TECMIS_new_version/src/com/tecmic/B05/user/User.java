/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecmic.B05.user;

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
public  class User {
    

    private String LogingState;
    private String UserID;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Email;
    private String NIC;
    private String BirthDate;
    private String UserName;
    private String Password;
    private String Sex;
    private String PhoneNumner;
    private String Address;
    private String ImagePathe;
    private String level;
    private String departmentID;

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    
   public void login(){
   
   }

    public String getLogingState() {
        return LogingState;
    }

    public void setLogingState(String LogingState) {
        this.LogingState = LogingState;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public String getPhoneNumner() {
        return PhoneNumner;
    }

    public void setPhoneNumner(String PhoneNumner) {
        this.PhoneNumner = PhoneNumner;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getImagePathe() {
        return ImagePathe;
    }

    public void setImagePathe(String ImagePathe) {
        this.ImagePathe = ImagePathe;
    }
    
    
    public List<User> list(String accessType) {
       List<User> list = new ArrayList<User>();
       
       if(accessType == "admin"){
       
            try {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM admin";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                User user = new User();
                
                user.setUserID(rs.getString("id"));
                user.setNIC(rs.getString("nic"));
                user.setFirstName(rs.getString("fname"));
                user.setMiddleName(rs.getString("mname"));
                user.setLastName(rs.getString("lname"));
                user.setBirthDate(rs.getString("birth_date"));
                user.setAddress(rs.getString("address"));
                user.setSex(rs.getString("sex"));
              
                user.setPhoneNumner(rs.getString("phone_no"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
               
               
                
                
                
 
                list.add( user);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
       
       }else if(accessType=="student"){
               
            try {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM student";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                User user = new User();
                
                user.setUserID(rs.getString("id"));
                user.setNIC(rs.getString("nic"));
                user.setFirstName(rs.getString("fname"));
                user.setMiddleName(rs.getString("mname"));
                user.setLastName(rs.getString("lname"));
                user.setBirthDate(rs.getString("birth_date"));
                user.setAddress(rs.getString("address"));
                user.setSex(rs.getString("sex"));
              
                user.setPhoneNumner(rs.getString("phone_no"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setLevel(rs.getString("level"));
                user.setDepartmentID(rs.getString("department_id"));
                user.setEmail(rs.getString("email"));
               
               
                
                
                
 
                list.add( user);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
       
       }else if(accessType=="lecture"){
           
            try {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM lecturer";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                User user = new User();
                
                user.setUserID(rs.getString("id"));
                user.setNIC(rs.getString("nic"));
                user.setFirstName(rs.getString("fname"));
                user.setMiddleName(rs.getString("mname"));
                user.setLastName(rs.getString("lname"));
                user.setBirthDate(rs.getString("birth_date"));
                user.setAddress(rs.getString("address"));
                user.setSex(rs.getString("sex"));
              
                user.setPhoneNumner(rs.getString("phone_no"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setDepartmentID(rs.getString("department_department_id"));
               
               
                
                
                
 
                list.add( user);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
       
       }else if(accessType=="technical_officer"){
           
           try {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM technical_officer";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                User user = new User();
                
                user.setUserID(rs.getString("id"));
                user.setNIC(rs.getString("nic"));
                user.setFirstName(rs.getString("fname"));
                user.setMiddleName(rs.getString("mname"));
                user.setLastName(rs.getString("lname"));
                user.setBirthDate(rs.getString("birth_date"));
                user.setAddress(rs.getString("address"));
                user.setSex(rs.getString("sex"));
              
                user.setPhoneNumner(rs.getString("phone_no"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setDepartmentID(rs.getString("department_department_id"));
               
               
                
                
                
 
                list.add( user);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
       }
       
       
        return list;
  
    
    }
    
    public  User get(String id, String accessType) {
        
        User user = new User();
        
        if(accessType == "technical_officer"){
          
            try {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM technical_officer WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                setUserID(rs.getString("id"));
                setNIC(rs.getString("nic"));
                setFirstName(rs.getString("fname"));
                setMiddleName(rs.getString("mname"));
                setLastName(rs.getString("lname"));
                setBirthDate(rs.getString("birth_date"));
                setAddress(rs.getString("address"));
                setSex(rs.getString("sex"));
              
                setPhoneNumner(rs.getString("phone_no"));
                setUserName(rs.getString("username"));
                setPassword(rs.getString("password"));
                setEmail(rs.getString("email"));
                setImagePathe(rs.getString("image_path"));
                setDepartmentID(rs.getString("department_department_id"));
 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        
        }else if(accessType == "lecture"){
             System.out.println(id);
             try {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM lecturer WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                setUserID(rs.getString("id"));
                setNIC(rs.getString("nic"));
                setFirstName(rs.getString("fname"));
                setMiddleName(rs.getString("mname"));
                setLastName(rs.getString("lname"));
                setBirthDate(rs.getString("birth_date"));
                setAddress(rs.getString("address"));
                setSex(rs.getString("sex"));
              
                setPhoneNumner(rs.getString("phone_no"));
                setUserName(rs.getString("username"));
                setPassword(rs.getString("password"));
                setEmail(rs.getString("email"));
                setImagePathe(rs.getString("image_path"));
                setDepartmentID(rs.getString("department_department_id"));
 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        
        }else if(accessType == "student"){
         
             try {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM student WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                setUserID(rs.getString("id"));
                setNIC(rs.getString("nic"));
                setFirstName(rs.getString("fname"));
                setMiddleName(rs.getString("mname"));
                setLastName(rs.getString("lname"));
                setBirthDate(rs.getString("birth_date"));
                setAddress(rs.getString("address"));
                setSex(rs.getString("sex"));
              
                setPhoneNumner(rs.getString("phone_no"));
                setUserName(rs.getString("username"));
                setPassword(rs.getString("password"));
                setEmail(rs.getString("email"));
                setImagePathe(rs.getString("image_path"));
                setLevel(rs.getString("level"));
                setDepartmentID(rs.getString("department_id"));
 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        
        }else if(accessType == "admin"){
             
             try {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM admin WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                setUserID(rs.getString("id"));
                setNIC(rs.getString("nic"));
                setFirstName(rs.getString("fname"));
                setMiddleName(rs.getString("mname"));
                setLastName(rs.getString("lname"));
                setBirthDate(rs.getString("birth_date"));
                setAddress(rs.getString("address"));
                setSex(rs.getString("sex"));
              
                setPhoneNumner(rs.getString("phone_no"));
                setUserName(rs.getString("username"));
                setPassword(rs.getString("password"));
                setEmail(rs.getString("email"));
                setImagePathe(rs.getString("image_path"));
                
 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        }
        
        return user;
    }
      
      
       
    
    
}
