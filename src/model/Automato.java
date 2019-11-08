package model;

import java.util.Vector;


  /**
 * Representação computacional de um autômato determinístico com pilha
 */
public class Automato {
	public Vector<Estado> estados;
	public Estado estadoAtual;
	public String pilha;
	
	 /**
     * Construtor da Classe
     */
	public Automato() {
		this.estados = new Vector<Estado>();
		this.estadoAtual = null;
		this.pilha = "";
	}
	 /**
     * Cria um novo estado com o nome do parâmetro e adiciona no autômato
     * Obs.: Esta função não irá verificar se o estado já existe
     *
     * @param nome Nome do novo estado.
     */
	public void addEstado(String nome) {
		estados.add(new Estado(nome));
	}
	
	 /**
     * Cria uma nova transição no estado em questão.
     * Obs.: Esta função não irá verificar se a transição já existe
     *
     * @param estado           Nome do estado
     * @param simbolo          Símbolo da transição
     * @param estadoResultante Nome do estado resultante
     */
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
	
	
  /**
     * Muda o estado atual do autômato para o estado em questão
     *
     * @param nome Nome do estado para o qual ele deve mudar
     */
	public void mudarEstadoAtual(String estado) {
		for(int index = 0; index <  estados.size() ;index++) {
			if(estados.elementAt(index).nome.equals(estado)) {
				estadoAtual = estados.elementAt(index);
			}
		}
		
	}

/**
     * Processa a palavra em questão e mostra se foi aceita ou rejeitada
     *
     * @param palavra Palavra que o autômato irá processar e validar
     */
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









