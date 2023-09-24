package com.alura.jdbc.pruebas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.alura.jdbc.dao.HuespedesDao;
import com.alura.jdbc.factory.ConnectionFactory;

public class PruebaHuespedes {

	public static void main(String[] args) {

		ConnectionFactory connectionFactory = new ConnectionFactory();

		try (Connection connection = connectionFactory.recuperaConexion()) {

			
			HuespedesDao huespedesDao = new HuespedesDao(connection);

			String nombre = "Juan";
			String apellido = "Perez";
			Date fechaNac = Date.valueOf("1990-01-15");
			String nacionalidad = "Mexicano";
			String telefono = "555-123-4567";
			Integer numeroReserva = 12345;

			huespedesDao.insertarHuesped(nombre, apellido, fechaNac, nacionalidad, telefono, numeroReserva);

			System.out.println("Nuevo huésped insertado en la base de datos.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
