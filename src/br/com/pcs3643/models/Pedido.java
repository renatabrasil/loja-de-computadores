package br.com.pcs3643.models;

import java.sql.Timestamp;

public class Pedido {
	private int idPedido;
	private double preco;
	private double desconto;
	private Timestamp timestamp;
	
	public Pedido(int idPedido, double preco, double desconto, Timestamp timestamp){
		this.idPedido = idPedido;
		this.preco = preco;
		this.desconto = desconto;
		this.timestamp = timestamp;
	}
	
	public Pedido(){

	}

	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
