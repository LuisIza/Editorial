/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.webservice.datos;

/**
 *
 * @author Luis
 */
public class InUser {
    String mail;
    String pass;

    public InUser(String mail, String pass) {
        this.mail = mail;
        this.pass = pass;
    }

    public InUser() {
    }
    

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
