package com.alura.jdbc.models;

import java.sql.Date;

public class Reservas {

	private Integer numeroDeReserva;
	private Date fechaCheckIn;
	private Date fechaCheckOut;
	private String valor;
	private String formaDePago;
	
	
	


	public Reservas(Integer numeroDeReserva, Date fechaCheckIn, Date fechaCheckOut, String valor, String formaDePago) {
		this.numeroDeReserva = numeroDeReserva;
		this.fechaCheckIn = fechaCheckIn;
		this.fechaCheckOut = fechaCheckOut;
		this.valor = valor;
		this.formaDePago = formaDePago;
	}


	public Integer getNumeroDeReserva() {
		return numeroDeReserva;
	}


	public void setNumeroDeReserva(Integer NumeroDeReserva) {
		this.numeroDeReserva = numeroDeReserva;
	}


	public Date getFechaCheckIn() {
		return fechaCheckIn;
	}


	public void setFechaCheckIn(Date fechaCheckIn) {
		this.fechaCheckIn = fechaCheckIn;
	}


	public Date getFechaCheckOut() {
		return fechaCheckOut;
	}


	public void setFechaCheckOut(Date fechaCheckOut) {
		this.fechaCheckOut = fechaCheckOut;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	public String getFormaDePago() {
		return formaDePago;
	}


	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}
	
	
	
	
	
	
	
	

	
	
}
