package com.fpmislata.banco.security;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class PasswordManagerImplJasypt implements PasswordManager {

    @Override
    public String encrypt(String password) {
        StrongPasswordEncryptor strongPasswordEncryptor = new StrongPasswordEncryptor();
        String encryptedPassword = strongPasswordEncryptor.encryptPassword(password);
        return encryptedPassword;
    }

    @Override
    public boolean check(String password, String encryptedPassword) {
        StrongPasswordEncryptor strongPasswordEncryptor = new StrongPasswordEncryptor();
        boolean success = strongPasswordEncryptor.checkPassword(password, encryptedPassword);
        return success;
    }

}
