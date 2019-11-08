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
		 transicoes.add(new Transicao(simbolo,  simboloRemoverPilha , simboloAddPilha,estadoResultante));
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
				
			//se o simbolo da transicao for igual ao simbolo requisitado
			if(transicoes.elementAt(index).simbolo == simbolo) {
				
				//verificar se eh valida a transicao  
				if(transicoes.elementAt(index).ehValida(simbolo , pilha)) {
					
					//verificar se tem simbolo a ser retirado na pilha
					//se tiver , remover o ultimo simbolo da pilha
					if(!transicoes.elementAt(index).simboloRemoverPilha.equals("@")) {
						pilha = pilha.substring (0, pilha.length() - transicoes.elementAt(index).simboloRemoverPilha.length());
						
					}
					
					//verificar se tem simbolo a ser adicionado na pilha
					//se tiver , adicionar simbolo na pilha
					if(!transicoes.elementAt(index).simboloAddPilha.equals("@")) {
						pilha = pilha + transicoes.elementAt(index).simboloAddPilha;
					}
					
					//se for valida a transicao retorna o nome do novo estado
					return transicoes.elementAt(index).getEstado();
				 }
			}
			
			
		}
		
		
		return null;
	}






