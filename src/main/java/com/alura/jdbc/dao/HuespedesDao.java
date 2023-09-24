package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
