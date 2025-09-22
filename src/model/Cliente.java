package model;

public class Cliente {
	
	private int numero;
	private String nome;
	
	public Cliente(int numero, String nome) {
		this.numero = numero;
		this.nome = nome;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cliente [numero=" + numero + ", nome=" + nome + "]";
	}
	
	
}
