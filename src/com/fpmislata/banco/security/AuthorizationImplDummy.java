package com.fpmislata.banco.security;

import com.fpmislata.banco.business.domain.Usuario;

public class AuthorizationImplDummy implements Authorization {

    @Override
    public boolean isAuthorizedUrl(Usuario usuario, String url, String metodo) {
        boolean success;
       
        if(url.equals("/banco_api/api/login")){
            success = true;
        }else{
            success = usuario != null;
        }            

        return success;
    }

}
