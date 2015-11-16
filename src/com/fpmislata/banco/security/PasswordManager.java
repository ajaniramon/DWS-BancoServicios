/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.security;

/**
 *
 * @author alumno
 */
public interface PasswordManager {
    public String encrypt(String password);
    public boolean check(String password,String encryptedPassword);
}
