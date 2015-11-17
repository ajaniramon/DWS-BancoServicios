package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.service.GenericService;
import com.fpmislata.banco.persistence.dao.GenericDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericServiceImpl<T> implements GenericService<T> {
    @Autowired
    protected GenericDAO<T> genericDAO;

    public GenericServiceImpl() {

    }

    @Override
    public T get(int id) {
        return genericDAO.get(id);
    }

    @Override
    public T insert(T t) {
       return genericDAO.insert(t);
    }

    @Override
    public List<T> findAll() {
        return genericDAO.findAll();
    }

    public T update(T t) {
        return genericDAO.update(t);
    }

    @Override
    public boolean delete(int id) {
        return genericDAO.delete(id);
    }
}
