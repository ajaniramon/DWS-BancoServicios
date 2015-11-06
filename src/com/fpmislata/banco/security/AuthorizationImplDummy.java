package com.fpmislata.banco.security;

import com.fpmislata.banco.security.Authorization;
import com.fpmislata.banco.business.domain.Usuario;


public class AuthorizationImplDummy implements Authorization {

    @Override
    public boolean isAuthorizedUrl(Usuario usuario, String url) {
        return true;
        
        
        
        
        
        
        
        
    }

}
