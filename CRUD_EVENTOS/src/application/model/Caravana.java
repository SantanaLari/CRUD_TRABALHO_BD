package application.model;

public class Caravana {
	
	private int codigo;
	private String nome;
	private int capacidade;
	private Double preco;
	private String uf;
	private Evento evento;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	 
	@Override
	public String toString() {
		return "Caravana [codigo=" + codigo + ", nome=" + nome 
				+ ", capacidade=" + capacidade + ", preco=" + preco 
				+ ", uf=" + uf;
	}
	public Evento getEvento() {
		return evento;
	}
	
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
}
