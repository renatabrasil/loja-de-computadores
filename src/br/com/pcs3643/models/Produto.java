package br.com.pcs3643.models;

public class Produto {
	private  int id;
	private String Tipo;
	private String Nome;
	private double Preço;
	
//	public Produto(){
////		Random r = new Random();
////		id = r.nextInt();
//	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public double getPreço() {
		return Preço;
	}

	public void setPreço(double preço) {
		Preço = preço;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		
	}
}
