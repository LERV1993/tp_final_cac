package dao;

import config.ConexionBD;
import inteface.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Usuario;

public class UsuarioDao implements Crud {

    // Importo lo que necesito
    ConexionBD conexionBD = new ConexionBD();
    Connection conn;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Usuario user = new Usuario();

    @Override
    public List<Usuario> listUsers() {

        ArrayList<Usuario> listUsers = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try {

            conn = conexionBD.obtenerConexion();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Usuario usuario = new Usuario();

                usuario.setId(resultSet.getInt("id"));
                usuario.setDni(resultSet.getString("dni"));
                usuario.setName(resultSet.getString("nombre"));

                listUsers.add(usuario);
            }
        } catch (Exception e) {

            e.printStackTrace();

        }

        return listUsers;

    }

    @Override
    public Usuario seeUser(int id) {
        String sql = "SELECT * FROM usuarios WHERE id=?";

        try {

            conn = conexionBD.obtenerConexion();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setDni(resultSet.getString("dni"));
                user.setName(resultSet.getString("nombre"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public Boolean Add(Usuario usuario) {
        String sql = "INSERT INTO usuarios (dni, nombre) VALUES (?, ?)";

        try {

            conn = conexionBD.obtenerConexion();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, usuario.getDni());
            preparedStatement.setString(2, usuario.getName());

            int filasAfectadas = preparedStatement.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean Edit(Usuario usuario) {
        String sql = "UPDATE usuarios SET dni=?, nombre=? WHERE id=?";

        try {

            conn = conexionBD.obtenerConexion();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, usuario.getDni());
            preparedStatement.setString(2, usuario.getName());
            preparedStatement.setInt(3, usuario.getId());

            int filasAfectadas = preparedStatement.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean Delete(int id) {

        String sql = "DELETE FROM usuarios WHERE id=?";

        try {

            conn = conexionBD.obtenerConexion();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            int filasAfectadas = preparedStatement.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
