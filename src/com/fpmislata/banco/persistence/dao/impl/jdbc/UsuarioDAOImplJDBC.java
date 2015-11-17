package com.fpmislata.banco.persistence.dao.impl.jdbc;

import com.fpmislata.banco.business.domain.Rol;
import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.persistence.dao.UsuarioDAO;
import com.fpmislata.banco.persistence.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioDAOImplJDBC implements UsuarioDAO {

    @Autowired
    ConnectionFactory connectionFactory;

    @Override
    public Usuario get(int id) {
        Usuario usuario;
        String sqlQuery = "SELECT * from usuario WHERE idUsuario = ?";
        Connection connection = connectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                usuario = new Usuario(resultSet.getInt("idUsuario"), resultSet.getString("username"), resultSet.getString("password"), Rol.valueOf(resultSet.getString("rol")));
            } else {
                usuario = null;
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Error SQL: " + ex.getMessage() + " ERROR CODE: " + ex.getSQLState());

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    throw new RuntimeException("Error SQL: " + ex.getMessage() + " ERROR CODE: " + ex.getSQLState());
                }
            }
        }
        return usuario;
    }

    @Override
    public Usuario insert(Usuario usuario) {
        String sqlQuery = "INSERT INTO usuario VALUES(null,?,?,?)";
        Connection connection = connectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, usuario.getUsername());
            preparedStatement.setString(2, usuario.getPassword());
            preparedStatement.setString(3, usuario.getRol().name());
            int numeroFilas = preparedStatement.executeUpdate();
            if (numeroFilas == 1) {
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        int returnedGeneratedKey = resultSet.getInt(1);
                        usuario.setIdUsuario(returnedGeneratedKey);
                    } else {
                        throw new RuntimeException("No se ha devuelto CP.");
                    }
                } catch (Exception e) {
                }
            } else if (numeroFilas == 0) {
                throw new RuntimeException("No se ha insertado el registro");
            } else {
                throw new RuntimeException("Soy un paranoico");
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error SQL: " + ex.getMessage() + " ERROR CODE: " + ex.getSQLState());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    throw new RuntimeException("Error SQL: " + ex.getMessage() + " ERROR CODE: " + ex.getSQLState());
                }
            }
        }
        return usuario;
    }

    @Override
    public Usuario update(Usuario t) {

        String sqlQuery = "UPDATE usuario SET username = ?, password = ?, rol = ? where idUsuario = ?";
        Connection connection = connectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, t.getUsername());
            preparedStatement.setString(2, t.getPassword());
            preparedStatement.setString(3, t.getRol().name());
           preparedStatement.setInt(4, t.getIdUsuario());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error SQL: " + ex.getMessage() + " ERROR CODE: " + ex.getSQLState());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    throw new RuntimeException("Error SQL: " + ex.getMessage() + " ERROR CODE: " + ex.getSQLState());
                }
            }
        }
        return this.get(t.getIdUsuario());
    }

    @Override
    public boolean delete(int id) {
        boolean success;
        String sqlQuery = "DELETE FROM usuario WHERE idUsuario = ?";
        Connection connection = connectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);
            int numeroFilas = preparedStatement.executeUpdate();
            if (numeroFilas == 1) {
                success = true;
            } else if (numeroFilas == 0) {
                success = false;
            } else {
                success = false;
                throw new RuntimeException("Soy un paranoico.");
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error SQL: " + ex.getMessage() + " ERROR CODE: " + ex.getSQLState());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    throw new RuntimeException("Error SQL: " + ex.getMessage() + " ERROR CODE: " + ex.getSQLState());
                }
            }
        }
        return success;
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList();
        String sqlQuery = "SELECT * from usuario";
        Connection connection = connectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Usuario usuario = new Usuario(resultSet.getInt("idUsuario"), resultSet.getString("username"), resultSet.getString("password"), Rol.valueOf(resultSet.getString("rol")));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error SQL: " + ex.getMessage() + " ERROR CODE: " + ex.getSQLState());

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    throw new RuntimeException("Error SQL: " + ex.getMessage() + " ERROR CODE: " + ex.getSQLState());
                }
            }
        }
        return usuarios;
    }

}
