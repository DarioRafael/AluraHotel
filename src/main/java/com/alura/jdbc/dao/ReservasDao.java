package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.alura.jdbc.models.Reservas;


public class ReservasDao {
	private Connection connection;

	public ReservasDao(Connection connection) {
		this.connection = connection;
	}

	public Reservas insertarReserva (String numeroDeReserva,Date fechaCheckIn, Date fechaCheckOut, String valor, String formaDePago) {
		try {
			String sql = "INSERT INTO reservas (`numero de reserva`, `fecha check in`, `fecha check out`, valor, `forma de pago`) VALUES (?, ?, ?, ?, ?)";

            final PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, numeroDeReserva);
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
}
