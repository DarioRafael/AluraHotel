package com.alura.jdbc.pruebas;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;


import com.alura.jdbc.dao.ReservasDao;
import com.alura.jdbc.factory.ConnectionFactory;
public class PruebaReservas {
	
	    public static void main(String[] args) {
	    	
	    	ConnectionFactory connectionFactory = new ConnectionFactory();

	        try {
	            // Establece la conexión a la base de datos
	            Connection connection = connectionFactory.recuperaConexion();

	            // Crea una instancia de ReservasDao
	            ReservasDao reservasDao = new ReservasDao(connection);

	            // Ejemplo de inserción de una reserva
	            String numeroDeReserva = "3213";
	            Date fechaCheckIn = Date.valueOf("2023-09-25"); // Cambia la fecha según tus necesidades
	            Date fechaCheckOut = Date.valueOf("2023-09-28"); // Cambia la fecha según tus necesidades
	            String valor = "500.00"; // Cambia el valor según tus necesidades
	            String formaDePago = "Tarjeta de crédito"; // Cambia la forma de pago según tus necesidades

	            reservasDao.insertarReserva(numeroDeReserva, fechaCheckIn, fechaCheckOut, valor, formaDePago);

	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}