/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.hibernate;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.persistence.hibernate.HibernateUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lliurex
 */
public class EntidadBancariaDAOImplHibernateTest {
    
    public EntidadBancariaDAOImplHibernateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        HibernateUtil.buildSessionFactory("com/fpmislata/banco/persistence/dao/impl/hibernate/hibernate.test.cfg.xml");
    }
    
    @AfterClass
    public static void tearDownClass() {
        HibernateUtil.closeSessionFactory();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of get method, of class EntidadBancariaDAOImplHibernate.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        EntidadBancariaDAOImplHibernate instance = new EntidadBancariaDAOImplHibernate();
        EntidadBancaria result = instance.get(48);
        assertEquals("EL REIMON", result.getNombre());

    }






    
}
