/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecmis.B05.notice;

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
public class Notice {
    
    private String NoticeID;
    private String Title;
    private String Date_Time;
    private String FilePath;
    private String Description;
  
    public String getNoticeID() {
        return NoticeID;
    }

    public void setNoticeID(String NoticeID) {
        this.NoticeID = NoticeID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDate_Time() {
        return Date_Time;
    }

    public void setDate_Time(String Date_Time) {
        this.Date_Time = Date_Time;
    }

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String FilePath) {
        this.FilePath = FilePath;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
        
    }
    
    public List<Notice> list() {
        
       List<Notice> list = new ArrayList<Notice>();
        try {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM notice";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                Notice notice = new Notice();
                notice.setNoticeID(rs.getString("notice_id"));
                notice.setTitle(rs.getString("title"));
                notice.setDate_Time(rs.getString("date_and_time"));
                notice.setDescription(rs.getString("discripsion"));
                
 
                list.add(notice);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
  
    
    }
    
      public Notice get(int id) {
        Notice notice = new Notice();
        try {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM notice WHERE notice_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                setNoticeID(rs.getString("notice_id"));
                setFilePath(rs.getString("file_path"));
                setTitle(rs.getString("title"));
                setDate_Time(rs.getString("date_and_time"));
                setDescription(rs.getString("discripsion"));
 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return notice;
    }
    
    
}
