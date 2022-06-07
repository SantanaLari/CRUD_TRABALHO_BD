package application.model;

public class Evento{
	
	private int codigo;
	private String nome;
	private String data;
	private String hora;
	private String rua;
	private int numero;
	private String uf;
	private Ingresso ingresso;
	
	public Ingresso getIngresso() {
		return ingresso;
	}
	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	@Override
	public String toString() {
		return "Codigo [codigo=" + codigo + ", nome=" + nome + ", data=" + data 
				+ ", rua=" + rua + ", numero=" + numero 
				+ ", uf=" + uf + "]";
	}
}


/*
public class Evento {
	
	private int codigo;
	private String nome;
	private Date data;
	private int hora;
	private String rua;
	private int numero;
	private String uf;
	private Ingresso ingresso;
	
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public Ingresso getIngresso() {
		return ingresso;
	}
	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}
	
	@Override
	public String toString() {
		return "Codigo [codigo=" + codigo + ", nome=" + nome + ", data=" + data 
				+ ", rua=" + rua + ", numero=" + numero 
				+ ", uf=" + uf + ", ingresso= " + ingresso + "]";
	}
	
}
*/