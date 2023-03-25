/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmis.BO5.student;

/**
 *
 * @author ACER
 */
public class Auth {
    private static Auth instance;
    private String username;
    
    private Auth(){}

    public static Auth getInstance() {
        if(instance == null)
        {
            instance=new Auth();
        }
        return instance;
    }

    public static void setInstace(Auth instace) {
        Auth.instance = instace;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
