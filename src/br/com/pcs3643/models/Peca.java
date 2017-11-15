package br.com.pcs3643.models;

public class Peca {
	private int idPeca;
	
	private String nome;
	
	private String tipo;
	
	private String descricao;
	
	private Double preco;
	
	public Peca() {
		// TODO Auto-generated constructor stub
	}
	
	public Peca(int idPeca, String nome, String tipo, String descricao, Double preco) {
		this.idPeca = idPeca;
		this.nome = nome;
		this.tipo = tipo;
		this.descricao = descricao;
		this.preco = preco;
	}

	public int getIdPeca() {
		return idPeca;
	}

	public void setIdPeca(int idPeca) {
		this.idPeca = idPeca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
}
