package model;

public class Transicao {

	public char simbolo;
	public String simboloRemoverPilha;
	public String simboloAddPilha;
	public String estadoResultante;
	
	
	//inicializador da classe
	public Transicao(char simbolo, String simboloRemoverPilha , String simboloAddPilha  , String estadoResultante ) {
		this.simbolo = simbolo;
		this.simboloRemoverPilha = simboloRemoverPilha;
		this.simboloAddPilha = simboloAddPilha;
		this.estadoResultante = estadoResultante;
	}
	
	//Parametros : simbolo a ser processado e ultimo simbolo da pilha.
	//Funcao : verificar se eh possivel fazer a transicao atual.
	//Resposta : true ou false para transicao valida.
	public boolean ehValida(char simbolo, String pilha) {
		if(this.simbolo == simbolo) {
			if(!this.simboloRemoverPilha.equals("@") ) {
				return this.simboloRemoverPilha == pilha.substring(pilha.length() - simboloRemoverPilha.length()) ? true : false;
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
