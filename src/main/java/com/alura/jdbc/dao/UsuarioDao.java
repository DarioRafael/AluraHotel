package com.alura.jdbc.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.alura.jdbc.models.Usuario;

public class UsuarioDao {

    private Connection connection;

    public UsuarioDao(Connection connection) {
        this.connection = connection;
    }

    public Usuario verificarCredenciales(String nombreUsuario, String contrasena) {
        Usuario usuario = null;

        try {
        	String sql = "SELECT id, usuario FROM usuario WHERE usuario = ? AND contraseña = ?";

            System.out.println(sql);

            final PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombreUsuario);
            statement.setString(2, contrasena);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("usuario");
                    usuario = new Usuario(nombre, contrasena);
                    usuario.setId(id);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return usuario;
    }
}

