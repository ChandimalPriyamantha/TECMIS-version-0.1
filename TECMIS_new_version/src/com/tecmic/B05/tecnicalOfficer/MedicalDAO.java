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
public interface MedicalDAO {
    public void save(Medical medical);
    public void update(Medical medical);
    public void delete(Medical medical);
    public Medical get(int medical_id);
    public List <Medical> list();
}
