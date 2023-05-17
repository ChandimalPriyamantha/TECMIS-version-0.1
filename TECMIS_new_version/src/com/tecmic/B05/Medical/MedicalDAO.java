/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tecmic.B05.Medical;

import java.util.List;

/**
 *
 * @author ganidusahan
 */
public interface MedicalDAO {
    public void save(Medical01 medical);
    public void update(Medical01 medical);
    public void delete(Medical01 medical);
    public Medical01 get(int medical_id);
    public List <Medical01> list();
}
