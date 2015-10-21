/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentation;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.business.service.EntidadBancariaService;
import com.fpmislata.banco.business.service.impl.EntidadBancariaServiceImpl;
import com.fpmislata.banco.persistence.dao.EntidadBancariaDAO;
import com.fpmislata.banco.persistence.dao.impl.jdbc.EntidadBancariaDAOImplJDBC;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author alumno
 */
public class Main {

    //@Autowired
    //EntidadBancariaService entidadBancariaService;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        new Main();
    }

    public Main() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        /* Esta línea sobra con la otra implementación. */
        EntidadBancariaService entidadBancariaService = applicationContext.getBean(EntidadBancariaServiceImpl.class);
        EntidadBancaria entidadBancaria = entidadBancariaService.get(9);
        System.out.println(entidadBancaria.toString());
    }

}
