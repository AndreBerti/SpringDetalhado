package com.tekila.domain.entity;

import java.time.LocalDate;

public class Pedido {
	private Integer id;
	private Cliente cliente;
	private LocalDate dataPedido;
	private double precoTotal;
	
	public Pedido() {
		
	}

	public Pedido(Integer id, Cliente cliente, LocalDate dataPedido, double precoTotal) {
		this.id = id;
		this.cliente = cliente;
		this.dataPedido = dataPedido;
		this.precoTotal = precoTotal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	
}
