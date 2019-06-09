/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.CRUD;

import java.io.File;


/**
 *
 * @author luis
 */
public class Comprobaciones {
    
public static boolean BorrarFichero(File fichero) {
        if (fichero.exists()) {
            fichero.delete();
            return true;
        }
            return false;

    }
    
}
