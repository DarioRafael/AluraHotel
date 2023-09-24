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
	            Connection connection = connectionFactory.recuperaConexion();

	            ReservasDao reservasDao = new ReservasDao(connection);


	            Integer numeroDeReserva = 3213;
	            Date fechaCheckIn = Date.valueOf("2023-09-25"); 
	            Date fechaCheckOut = Date.valueOf("2023-09-28");
	            String valor = "500.00"; 
	            String formaDePago = "Tarjeta de crédito"; 

	            reservasDao.insertarReserva(numeroDeReserva, fechaCheckIn, fechaCheckOut, valor, formaDePago);

	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}