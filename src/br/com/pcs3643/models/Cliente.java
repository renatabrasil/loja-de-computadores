package br.com.pcs3643.models;

public class Cliente {
	
	public String nome;
	public int cpf;
	public String endereco;
	public String email;
	public int telefone;
	
	public Cliente(String nome, int cpf, String endereco, String email, int telefone) {
    	super();
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }
	
	public Cliente (){}
	
	public String getNome() {
	    return this.nome;
	}
	
	public int getCpf() {
		return this.cpf;
	}
	
	public String getEndereco() {
	    return this.endereco;
	}
	
	public String getEmail() {
	    return this.email;
	}
	
	public int getTelefone() {
		return this.telefone;
	}

	public void setNome(String string) {
		this.nome = string;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	
}
