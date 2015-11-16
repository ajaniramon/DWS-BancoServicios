/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.security;

import com.fpmislata.banco.business.domain.Usuario;

/**
 *
 * @author alumno
 */
public interface Authorization {
    public boolean isAuthorizedUrl(Usuario usuario, String url,String metodo);
}
