package com.alura.jdbc.pruebas;

import java.sql.Connection;
import java.sql.SQLException;

import com.alura.jdbc.dao.UsuarioDao;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.models.Usuario;

public class Prueba {

	
	public static void main(String[] args) {
	    ConnectionFactory connectionFactory = new ConnectionFactory();
	    Connection conexion = connectionFactory.recuperaConexion();


	    UsuarioDao usuarioDao = new UsuarioDao(conexion);

	    String nombreUsuarioPrueba = "dario"; 
	    String contrasenaPrueba = "bestia";   

	    Usuario usuarioAutenticado = usuarioDao.verificarCredenciales(nombreUsuarioPrueba, contrasenaPrueba);

	    try {
	        conexion.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }


	    if (usuarioAutenticado != null) {
	        System.out.println("Usuario autenticado correctamente.");
	    } else {
	        System.out.println("Usuario o contraseña incorrectos.");
	    }
	}

}
