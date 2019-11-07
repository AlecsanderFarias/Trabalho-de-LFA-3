package model;

public class Transicao {

	public char simbolo;
	public char simboloRemoverPilha;
	public char simboloAddPilha;
	public String estadoResultante;
	
	
	//inicializador da classe
	public Transicao(char simbolo , String estadoResultante ) {
		this.simbolo = simbolo;
		this.estadoResultante = estadoResultante;
	}
	
	//Parametros : simbolo a ser processado e ultimo simbolo da pilha.
	//Funcao : verificar se eh possivel fazer a transicao atual.
	//Resposta : true ou false para transicao valida.
	public boolean ehValida(char simbolo, char pilha) {
		if(this.simbolo == simbolo) {
			if(this.simboloRemoverPilha != '@') {
				return this.simboloRemoverPilha == pilha ? true : false;
			}else {
				return true;
			}
			
		}
		
		return false;
	}
	
	//Parametros : .
	//Funcao : devolver o nome do estado resultante.
	//Resposta : nome do estado resultante.
	public String getEstado() {
		return estadoResultante;
	}
	
}
