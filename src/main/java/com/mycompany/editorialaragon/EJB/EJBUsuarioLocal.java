/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.EJB;

import javax.ejb.Local;

/**
 *
 * @author LUIS
 */
@Local
public interface EJBUsuarioLocal {
    //@ConstraintUsuario(message = "Usuario no definido")
    public String getUsuario();
    public void setUsuario(String usuario);
    
    @ConstraintEmail(message = "Email incorrecto")
    public String getEmail();
    public void setEmail(String email);
    
    //@ConstraintPassword(message = "Password incorrecto")
    public String getPassword();
    public void setPassword(String password);
}
