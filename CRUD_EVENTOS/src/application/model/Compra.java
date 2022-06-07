package application.model;

public class Compra {
	
	private int codigo;
	private String nome;
	private String email;
	private Evento evento;
	private Caravana caravana;

	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Caravana getCaravana() {
		return caravana;
	}
	public void setCaravana(Caravana caravana) {
		this.caravana = caravana;
	}
	
	@Override
	public String toString() {
		return "Compra [codigo=" + codigo + ", nome=" + nome
				+ ", email=" + email + ", caravana=" + caravana + "]";
	}
}

/*public class Compra {
	
	private int codigo;
	private String nome;
	private String email;
	private Evento evento;
	private Ingresso ingresso;
	private Caravana caravana;
	private Double valor;
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public Ingresso getIngresso() {
		return ingresso;
	}
	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}
	public Caravana getCaravana() {
		return caravana;
	}
	public void setCaravana(Caravana caravana) {
		this.caravana = caravana;
	}
	
	@Override
	public String toString() {
		return "Compra [codigo=" + codigo + ", nome=" + nome
				+ ", email=" + email + ", evento=" + evento 
				+ ", ingresso=" + ingresso + ", caravana=" + caravana + "]";
	}
}
*/