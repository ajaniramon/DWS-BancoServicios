/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.business.service.EntidadBancariaService;
import com.fpmislata.banco.persistence.core.BusinessException;
import com.fpmislata.banco.persistence.core.BusinessMessage;
import com.fpmislata.banco.persistence.dao.EntidadBancariaDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alumno
 */
public class EntidadBancariaServiceImpl extends GenericServiceImpl<EntidadBancaria> implements EntidadBancariaService {

    @Autowired
    EntidadBancariaDAO entidadBancariaDAO = (EntidadBancariaDAO) genericDAO;

    @Override
    public List<EntidadBancaria> findByNombre(String nombre) {

        return entidadBancariaDAO.findByNombre(nombre);
    }

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) throws BusinessException {

        List<BusinessMessage> businessMessages = new ArrayList();

        if (entidadBancaria.getNombre() == null) {
            businessMessages.add(new BusinessMessage("nombre", "El nombre no puede estar vacío."));
        }
        if (entidadBancaria.getCif() == null) {
            businessMessages.add(new BusinessMessage("cif", "El CIF no puede estar vacío"));
        }
        if (entidadBancaria.getFechaCreacion() == null) {
            businessMessages.add(new BusinessMessage("fecha", "La fecha no puede estar vacía."));
        }
        if (String.valueOf(entidadBancaria.getCodigoEntidad()).length() != 4) {
            businessMessages.add(new BusinessMessage("codigoEntidad", "El código entidad debe tener 4 digitos."));
        }
        if (!businessMessages.isEmpty()) {
            throw new BusinessException(businessMessages);
        }
        return entidadBancariaDAO.insert(entidadBancaria);

    }

}
