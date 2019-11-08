package model;

import java.util.Vector;
import model.Estado;



public class Automato {
	public Vector<Estado> estados;
	public Estado estadoAtual;
	public String pilha;
	
	//Incializador da classe
	public Automato() {
		this.estados = new Vector<Estado>();
		this.estadoAtual = null;
		this.pilha = "";
	}
	
	//Parametros : nome do novo estado.
	//Funcao : criar um novo estado com o nome em questao e adicionar no automato.
	//Observacao : essa funcao nao ira verificar se esse estado ja existe.
	public void addEstado(String nome) {
		estados.add(new Estado(nome));
	}
	
	//Parametros : nome do estado , simbolo da transicao , simbolo que remove da pilha , simbolo que adiciona na pilha e nome do estado resultante.
	//Funcao : criar uma nova transicao no estado em questao.
	//Observacao : essa funcao nao ira verificar se essa transicao ja existe.
	public void addTransicao(String estado , char simbolo, String simboloRemoverPilha , String simboloAddPilha  , String estadoResultante ) {
		for(int index = 0 ; index < estados.size() ; index ++) {
			if(estados.elementAt(index).nome.equals(estado) ) {
				estados.elementAt(index).addTransicao(simbolo, simboloRemoverPilha, simboloAddPilha,estadoResultante);
			}
		}
	}
	
	public void setEstadosFinais(String conjunto) {
		String[] estadosFinais = conjunto.split(",");
		
		for(int index = 0 ; index < estadosFinais.length ; index ++) {
			for(int index2 = 0 ; index2 < estados.size() ; index2 ++) {
				if(estados.elementAt(index2).nome.equals(estadosFinais[index])){
					
				}
			}
				
		}
		
	}
	
	
	//Parametros : nome do estado para qual ele deve mudar.
	//Funcao : mudar o estado atual do automato para o estado em questao.
	//Observacao : .
	public void mudarEstadoAtual(String estado) {
		for(int index = 0; index <  estados.size() ;index++) {
			if(estados.elementAt(index).nome.equals(estado)) {
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
	
	public void ImprimirAutomoto() {
		System.out.printf("\n Estados : \n");
		
		for(int i =0; i < estados.size(); i++) {
			System.out.printf("%s \n", estados.elementAt(i).nome);
		}
		
		
	}
	
	
	
}









