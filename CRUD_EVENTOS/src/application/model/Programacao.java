package application.model;

public class Programacao {

	private int codigo;
	private Evento codigoEvento; //não sei ao certo se é correto usar o "Evento" ou "int" aqui
	private String horario;
	private String nome;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Evento getCodigoEvento() {
		return codigoEvento;
	}
	public void setEvento(Evento codigoEvento) {
		this.codigoEvento = codigoEvento;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Programacao [codigo=" + codigo + ", codigoEvento=" + codigoEvento 
				+ ", horario=" + horario + ", nome=" + nome + "]";
	}
	
}
