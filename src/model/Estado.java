package model;

import java.util.Vector;

public class Estado {

	public Vector<Transicao> transicoes;
	public String nome;
	public boolean Inicial;
	public boolean Final;
	
	//inicializador da classe
	public Estado(String nome) {
		this.nome = nome;
		this.transicoes = null;
		this.Inicial = false;
		this.Final = false;
	}
	
	//Parametros : simbolo da transicao estado resultante da mesma.
	//Funcao : adiciona uma transicao com o simbolo e o estado resultante.
	//Resposta : .
	public void addTransicao(char simbolo , String estadoResultante ) {
		 transicoes.add(new Transicao(simbolo ,estadoResultante));
	}
	
	//Parametros : .
	//Funcao : marca o estado como inicial.
	//Resposta : .
	public void setInicial() {
		this.Inicial = true;
	}
	
	//Parametros : .
	//Funcao : marca o estado como final.
	//Resposta : .
	public void setFinal() {
		this.Final = true;
	}
	
	//Parametros : .
	//Funcao : retorna se o estado e um estado final ou nao.
	//Resposta : true ou false para ser estado final,
	public boolean getFinal() {
		return this.Final;
	}
	
	//Parametros : simbolo a ser processado pelo estado e a pilha do automoto.
	//Funcao : processa o simbolo para dizer se eh valido ou nao.
	//Resposta : se for valido retorna o nome do estado para qual deve transitar,
	//se for invalido ele retorna null.
	//Observacao : essa funcao ja trata a pilha (adiciona e retira da pilha quando preciso).
	public String transitar(char simbolo , String pilha) {
		
		//verficar o vetor de transicoes procurando por uma 
		//transicao com o simbolo requisitado
		for(int index=0;index < transicoes.size(); index++) {
				
			//se a transicao com o simbolo requisitado for valido pare
			if(transicoes.elementAt(index).ehValida(simbolo , pilha.charAt(pilha.length()))) {
				
				//verificar se tem simbolo a ser retirado na pilha
				//se tiver , remover o ultimo simbolo da pilha
				if(transicoes.elementAt(index).simboloRemoverPilha != '@') {
					pilha = pilha.substring (0, pilha.length() - 1);
					
				}
				
				//verificar se tem simbolo a ser adicionado na pilha
				//se tiver , adicionar simbolo na pilha
				if(transicoes.elementAt(index).simboloAddPilha != '@') {
					pilha = pilha + transicoes.elementAt(index).simboloAddPilha;
				}
				
				return transicoes.elementAt(index).getEstado();
			 }
		}
		
		
		return null;
	}

}





