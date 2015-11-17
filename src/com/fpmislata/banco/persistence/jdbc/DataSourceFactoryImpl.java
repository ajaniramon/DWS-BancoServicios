package com.fpmislata.banco.persistence.jdbc;

import com.fpmislata.banco.persistence.jdbc.DataSourceFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceFactoryImpl implements DataSourceFactory {

    @Override
    public DataSource getDataSource() {
        DataSource dataSource;
        try {
            InitialContext initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            dataSource = (DataSource) envCtx.lookup("jdbc/MySQLDS");
        } catch (NamingException ex) {
            dataSource = null;
            throw new RuntimeException("Error al inicializar objeto InitialContext. " + ex.getMessage());

        }
        return dataSource;
    }

}
