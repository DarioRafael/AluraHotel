package com.alura.jdbc.pruebas;


import java.sql.Connection;
import java.sql.SQLException;
import com.alura.jdbc.factory.ConnectionFactory;


public class PruebaFactory {





	    public static void main(String[] args) {
	        ConnectionFactory connectionFactory = new ConnectionFactory();

	        try {
	            Connection connection = connectionFactory.recuperaConexion();
	            System.out.println("Conexión exitosa a la base de datos.");
	  
	            connection.close(); 
	        } catch (SQLException e) {
	            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	}
