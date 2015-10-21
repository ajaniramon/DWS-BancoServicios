/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.business.service.EntidadBancariaService;
import com.fpmislata.banco.persistence.dao.EntidadBancariaDAO;
import java.util.List;

/**
 *
 * @author alumno
 */
public class EntidadBancariaServiceImpl extends GenericServiceImpl<EntidadBancaria> implements EntidadBancariaService {
   
 

    @Override
    public List<EntidadBancaria> findByNombre(String nombre) {
        EntidadBancariaDAO entidadBancariaDAO=(EntidadBancariaDAO)genericDAO;
       return entidadBancariaDAO.findByNombre(nombre);
    }

    

    
}
   




    

