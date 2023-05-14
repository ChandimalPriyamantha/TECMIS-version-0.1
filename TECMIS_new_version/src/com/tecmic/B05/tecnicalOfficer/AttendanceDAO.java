/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tecmic.B05.tecnicalOfficer;
import java.util.List;

/**
 *
 * @author ganidusahan
 */
public interface AttendanceDAO {
    
    public void save(Attendance attendence);
    public void update(Attendance attendence);
    public void delete(Attendance attendence);
    public Attendance get(int attendence_id);
    public List <Attendance> list();
    
}
