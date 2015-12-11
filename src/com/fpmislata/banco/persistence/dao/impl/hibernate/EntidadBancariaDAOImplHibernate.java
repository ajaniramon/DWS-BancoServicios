/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.hibernate;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.persistence.core.BusinessException;
import com.fpmislata.banco.persistence.dao.GenericDAO;
import com.fpmislata.banco.persistence.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Lliurex
 */
public class EntidadBancariaDAOImplHibernate implements GenericDAO<EntidadBancaria> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public EntidadBancaria get(int id) {
        Session session = sessionFactory.openSession();
        EntidadBancaria entidadBancaria = (EntidadBancaria) session.get(EntidadBancaria.class, id);
        session.close();
        return entidadBancaria;
    }

    @Override
    public EntidadBancaria insert(EntidadBancaria t) throws BusinessException {
        Session session = sessionFactory.openSession();
        EntidadBancaria entidadBancaria = (EntidadBancaria) session.save(t);
        session.close();
        return entidadBancaria;

    }

    @Override
    public EntidadBancaria update(EntidadBancaria t) {
        Session session = sessionFactory.openSession();
        session.update(t); //chapuza
        session.close();
        return t;
    }

    @Override
    public boolean delete(int id) {
        Session session = sessionFactory.openSession();
        EntidadBancaria entidadBancaria = this.get(id);
        session.delete(entidadBancaria);
        session.close();
        return true; //chapuza
    }

    @Override
    public List<EntidadBancaria> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<EntidadBancaria> entidades = session.createQuery("SELECT entidadBancaria FROM EntidadBancaria entidadBancaria").list();
        session.getTransaction().commit();
        session.close();
        return entidades;
    }

}
