package com.alura.jdbc.pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {
	
	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/hotel_de_alura?useTimeZone=true&serverTimeZone=UTC",
				"root",
				"12345");
		
		
		System.out.println("Hola");
		con.close();
		
	}
}
