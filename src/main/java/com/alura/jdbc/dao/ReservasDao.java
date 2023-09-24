package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.models.Huespedes;
import com.alura.jdbc.models.Reservas;


public class ReservasDao {
	private Connection connection;

	public ReservasDao(Connection connection) {
		this.connection = connection;
	}

	public Reservas insertarReserva (Integer numeroDeReserva,Date fechaCheckIn, Date fechaCheckOut, String valor, String formaDePago) {
		try {
			String sql = "INSERT INTO reservas (`numero de reserva`, `fecha check in`, `fecha check out`, valor, `forma de pago`) VALUES (?, ?, ?, ?, ?)";

            final PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, numeroDeReserva);
            statement.setDate(2, fechaCheckIn);
            statement.setDate(3, fechaCheckOut);
            statement.setString(4, valor);
            statement.setString(5, formaDePago);

            statement.executeUpdate();
            
            Reservas nuevaReserva = new Reservas(numeroDeReserva ,fechaCheckIn, fechaCheckOut, valor, formaDePago);
            
            return nuevaReserva;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	
	public List<Reservas> buscarPorNumeroReserva(Integer numeroReserva) {
	    List<Reservas> resultados = new ArrayList<>();
	    try {
	        String sql = "SELECT * FROM reservas WHERE `numero de reserva` = ?";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setInt(1, numeroReserva);

	        
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            Reservas reservas = new Reservas(
	                resultSet.getInt("numero de reserva"),
	                resultSet.getDate("fecha check in"),
	                resultSet.getDate("fecha check out"),
	                resultSet.getString("valor"),
	                resultSet.getString("forma de pago")
	            );
	            resultados.add(reservas);
	        }
	    } catch (SQLException e) {
	        System.err.println("Error SQL: " + e.getMessage());
	        throw new RuntimeException(e);
	    }
	    return resultados;
	}
}