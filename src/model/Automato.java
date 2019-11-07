package model;

import java.util.Vector;
import model.Estado;



public class Automato {
	public Vector<Estado> estados;
	public Estado estadoAtual = null;
	public String pilha;
	public String alfabeto;
	
	//Incializador da classe
	public Automato() {
		this.estados = null;
		this.pilha = null;
		this.alfabeto = null;
	}
	

	//Parametros : nome do novo estado.
	//Funcao : criar um novo estado com o nome em questao e adicionar no automato.
	//Observacao : essa funcao nao ira verificar se esse estado ja existe.
	public void addEstado(String nome) {
		estados.add(new Estado(nome));
	}
	
	
	
	//Parametros : nome do estado , simbolo da transicao e nome do estado resultante.
	//Funcao : criar uma nova transicao no estado em questao.
	//Observacao : essa funcao nao ira verificar se essa transicao ja existe.
	public void addTransicao(String estado , char simbolo , String estadoResultante ) {
		for(int index = 0 ; index < estados.size() ; index ++) {
			if(estados.elementAt(index).nome == estado) {
				estados.elementAt(index).addTransicao(simbolo, estadoResultante);
			}
		}
	}
	
	//Parametros : nome do estado para qual ele deve mudar.
	//Funcao : mudar o estado atual do automato para o estado em questao.
	//Observacao : .
	public void mudarEstadoAtual(String nome) {
		for(int index = 0; index <  estados.size() ;index++) {
			if(estados.elementAt(index).nome == nome) {
				estadoAtual = estados.elementAt(index);
			}
		}
		
	}

	//Parametros : palavra que o automato ira processar e validar.
	//Funcao : processar a palavra em questao e mostrar se foi rejeitada ou nao.
	//Observacao : .
	public void processarPalavra(String palavra) {
		this.mudarEstadoAtual("q0");
		String estado = null;
		
		for(int index = 0; index < palavra.length();index++) {
			estado = estadoAtual.transitar(palavra.charAt(index), pilha);
			
			if (estado == null) {
				break;
			}else {
				mudarEstadoAtual(estado);
			}
			
		}
		
		if(estado == null || !estadoAtual.getFinal()) {
			System.out.println("Palavra rejeitada");
		}else {
			System.out.println("Palavra aceita");
		}
		
		
	}
	
}
