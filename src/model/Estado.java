package model;

import java.util.Vector;

public class Estado {

	public Vector<Transicao> transicoes;
	public String nome;
	public boolean Inicial;
	public boolean Final;
	
	public Estado(String nome) {
		this.nome = nome;
		this.transicoes = null;
		this.Inicial = false;
		this.Final = false;
	}
	
	public void addTransicao(String simbolo , String estadoResultante ) {
		 transicoes.add(new Transicao(simbolo ,estadoResultante));
	}
	
	public void setInicial() {
		this.Inicial = true;
	}
	
	public void setFinal() {
		this.Final = true;
	}

	public String transitar(String simbolo , Vector<String> pilha) {
		
		//verficar o vetor de transicoes procurando por uma 
		//transicao com o simbolo requisitado
		for(int index=0;index < transicoes.size(); index++) {
				
			//se a transicao com o simbolo requisitado for valido pare
			if(transicoes.elementAt(index).ehValida(simbolo , pilha.lastElement())) {
				
				//verificar se tem simbolo a ser retirado na pi
				if(transicoes.elementAt(index).simboloRemoverPilha != "@") {
					pilha.remove(pilha.size());
				}
				
				if(transicoes.elementAt(index).simboloAddPilha != "@") {
					pilha.add(transicoes.elementAt(index).simboloAddPilha);
				}
				
				return transicoes.elementAt(index).getEstado();
			 }
		}
		
		
		return null;
	}

}
