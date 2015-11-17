package com.fpmislata.banco.persistence.dao.impl.jdbc;

import com.fpmislata.banco.business.domain.Provincia;
import com.fpmislata.banco.persistence.jdbc.ConnectionFactory;
import com.fpmislata.banco.persistence.dao.ProvinciaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ProvinciaDAOImplJDBC implements ProvinciaDAO {

    @Autowired
    ConnectionFactory connectionFactory;

    @Override
    public Provincia get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Provincia insert(Provincia t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Provincia update(Provincia t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Provincia> findAll() {

        return null;
    }

}
