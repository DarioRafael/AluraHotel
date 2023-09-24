package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.models.Huespedes;
import com.alura.jdbc.models.Usuario;

public class HuespedesDao {
	private Connection connection;

	public HuespedesDao(Connection connection) {
		this.connection = connection;
	}

	public void insertarHuesped(String nombre, String apellido, Date fechaNac, String nacionalidad, String telefono,
			String numeroReserva) {
		try {
			String sql = "INSERT INTO huespedes (nombre, apellido, `Fecha de Nacimiento`, nacionalidad, telefono, `Id Reserva`) VALUES (?, ?, ?, ?, ?, ?)";


			final PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, nombre);
			statement.setString(2, apellido);
			statement.setDate(3, new java.sql.Date(fechaNac.getTime()));
			statement.setString(4, nacionalidad);
			statement.setString(5, telefono);
			statement.setString(6, numeroReserva);

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	public List<Huespedes> buscarPorApellido(String apellido) {
	    List<Huespedes> resultados = new ArrayList<>();
	    try {
	        String sql = "SELECT * FROM huespedes WHERE apellido = ?";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1, apellido);
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {

	            Huespedes huesped = new Huespedes(
	            	resultSet.getInt("Id"),
	                resultSet.getString("Nombre"),
	                resultSet.getString("Apellido"),
	                resultSet.getDate("Fecha de Nacimiento"),
	                resultSet.getString("Nacionalidad"),
	                resultSet.getString("Telefono"),
	                resultSet.getInt("Id Reserva")
	            );
	            resultados.add(huesped);
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	    return resultados;
	}
	
	public List<Huespedes> buscarPorNumeroReserva(int numeroReserva) {
	    List<Huespedes> resultados = new ArrayList<>();
	    try {
	        String sql = "SELECT * FROM huespedes WHERE `Id Reserva` = ?";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setInt(1, numeroReserva);

	        
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            Huespedes huesped = new Huespedes(
	                resultSet.getInt("Id"),
	                resultSet.getString("Nombre"),
	                resultSet.getString("Apellido"),
	                resultSet.getDate("Fecha de Nacimiento"),
	                resultSet.getString("Nacionalidad"),
	                resultSet.getString("Telefono"),
	                resultSet.getInt("Id Reserva")
	            );
	            resultados.add(huesped);
	        }
	    } catch (SQLException e) {
	        System.err.println("Error SQL: " + e.getMessage());
	        throw new RuntimeException(e);
	    }
	    return resultados;
	}



}
