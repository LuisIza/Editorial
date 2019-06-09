/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author luis
 */
public class MD5 {

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static String letras(){
             String [] referencia= {"AD","2D","3D","4D","5D","6D","7D","8D","9D","0D" ,
            "JD","QD","KD", "AB","2B","3B","4B","5B","6B","7B","8B","9B","0B", "JB","QB","KB", 
            "AC","2C","3C","4C","5C","6C","7C","8C","9C","0C", "JC","QC","KC","AF","2F","3F",
            "4F","5F","6F","7F", "8F","9F","0F","JF","QF","KF"};
            int random = (int) (Math.random() * 99895) + 999;
            int numR = (int) Math.round(Math.random() * 51 );
            int numRandon = (int) Math.round(Math.random() * 51 );
            return referencia[numR]+referencia[numRandon]+"-"+random;
    }

}
