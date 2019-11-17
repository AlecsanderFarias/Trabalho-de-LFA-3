package model;

import java.util.Vector;

/**
 * Representação de um estado do autômato
 */
public class Estado {

	public Vector<Transicao> transicoes;
	public String nome;
	public boolean Inicial;
	public boolean Final;
	
	 /**
     * Construtor da Classe
     *
     * @param nome Nome do estado
     */
	public Estado(String nome) {
		
		this.nome = nome;
		this.transicoes = new Vector<Transicao>();
		this.Inicial = false;
		this.Final = false;
	}
	
	 /**
     * Adiciona uma transição com o símbolo e o estado resultante
     *
     * @param simbolo          Símbolo da transição
     * @param estadoResultante Estado resultante
     */
	public void addTransicao(char simbolo, String simboloRemoverPilha , String simboloAddPilha  , String estadoResultante ) {
		transicoes.add(new Transicao(simbolo,simboloRemoverPilha,  simboloAddPilha , estadoResultante));
	}
	
	/**
     * Marca o estado como inicial
     */
	public void setInicial() {
		this.Inicial = true;
	}
	
	/**
     * Marca o estado como final
     */
	public void setFinal() {
		this.Final = true;
	}
	
	 /**
     * Retorna se o estado é um estado final ou não
     *
     * @return Verdadeiro ou Falso para Estado Final
     */
	public boolean getFinal() {
		return this.Final;
	}
	
	/**
     * Processa o símbolo para dizer se é válido ou não
     * Obs.: Essa função já trata a pilha (adiciona e retira quando necessário)
     *
     * @param simbolo Símbolo a ser processado pelo estado
     * @param pilha   Pilha do Autômato
     * @return Se for válido retorna o nome do estado para qual irá transitar, se for inválido retornará "null"
     */
	public String transitar(char simbolo , String pilha) {
		
		//verficar o vetor de transicoes procurando por uma 
		//transicao com o simbolo requisitado
		
		for(int index=0;index < transicoes.size(); index++) {
					
		
			if(transicoes.elementAt(index).ehValida(simbolo,pilha) ) {
				//transicoes.elementAt(index).imprimirTransicao();
				
				//ESTA COM ERRO EM ALGUM LUGAR
				
				
				
				pilha = transicoes.elementAt(index).mudarPilha(pilha);
				
				//System.out.println("pilha = " + pilha);
				
				//se a transicao valida nao ter o simbolo "@" 
				//retorne o estado + ,1 para indicar que deve avancar na leitura
				//caso nao seja esse simbolo 
				////retorne o estado + ,0 para indicar que nao deve avancar na leitura
				if(transicoes.elementAt(index).simbolo == '@' && !transicoes.elementAt(index).simboloRemoverPilha.equals("$")) {
					return transicoes.elementAt(index).getEstado() + ",0," + (pilha.length() > 0 ? pilha : " ");
				}else {
					return transicoes.elementAt(index).getEstado() + ",1,"+ (pilha.length() > 0 ? pilha : " ");
				}
				
				
			}
				
			
			
			
		}
		
		return null;
	}
	
	
	
	public void ImprimirTransicoes() {
	
		for(int index =0; index < this.transicoes.size(); index++) {
			System.out.printf("(%s,%c,%s) = (%s,%s) \n",
					this.nome,			
					this.transicoes.elementAt(index).simbolo,
					this.transicoes.elementAt(index).simboloRemoverPilha,
					this.transicoes.elementAt(index).getEstado(),
					this.transicoes.elementAt(index).simboloAddPilha);
		}
	}
}






