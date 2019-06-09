/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.webservice.datos;

import java.util.List;

/**
 *
 * @author Luis
 */
public class UsLDB {
    //UsuariosEa user = new UsuariosEa();
    String mensaje;
    boolean confirm;
    List<?> usLog;

    public UsLDB() {
    }

    public UsLDB(String mensaje, boolean confirm, List<?> usLog) {
        this.mensaje = mensaje;
        this.confirm = confirm;
        this.usLog = usLog;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public List<?> getUsLog() {
        return usLog;
    }

    public void setUsLog(List<?> usLog) {
        this.usLog = usLog;
    }

    
    
    
}
