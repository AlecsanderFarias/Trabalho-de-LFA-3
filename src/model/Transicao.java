package model;

public class Transicao {

	public String simbolo;
	public String simboloRemoverPilha;
	public String simboloAddPilha;
	public String estadoResultante;
	
	
	public Transicao(String simbolo , String estadoResultante ) {
		this.simbolo = simbolo;
		this.estadoResultante = estadoResultante;
	}
	
	public boolean ehValida(String simbolo, String pilha) {
		return (this.simbolo == simbolo && pilha == simboloRemoverPilha) ? true : false;
	}
	
	public String getEstado() {
		return estadoResultante;
	}
	
}
