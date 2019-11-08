package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	public void addTransicao(String string1, String string2 ) {
			
		String[] itens1 = string1.split(",");
		String[] itens2 = string2.split(",");
			
		for(int index = 0 ; index < estados.size() ; index ++) {
			if(estados.elementAt(index).nome.equals(itens1[0])) {
				char simbol = itens1[1].charAt(0);
				estados.elementAt(index).addTransicao(simbol, itens1[2], itens2[1], itens2[0]);
			}
		}
	}
	
	public void setEstadosFinais(String conjunto) {

		String[] estadosFinais = conjunto.split(",");
		
		
		for (String string : estadosFinais) {			
			for(int index = 0 ; index < estados.size() ; index ++) {
				if(estados.elementAt(index).nome.equals(string)){
					estados.elementAt(index).setFinal();
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
		
		if(this.estados.size() != 0) {
			 this.mudarEstadoAtual("q0");
				String estado = "";
				String[] reponses ;
				
				System.out.println("\n");
				
				for(int index = 0; index < palavra.length();index++) {
					
					
					
					estado = estadoAtual.transitar(palavra.charAt(index), pilha);
					
					if (estado == null) {
						break;
					}else {
						reponses = estado.split(",");
						
						if(reponses[1] == "1") {
							index--;
						}
						
						this.pilha = reponses[2];
						
						System.out.printf("fita: %s[%s]%s     pilha: %s\n",
								palavra.subSequence(0, index) ,
								estadoAtual.nome , 
								palavra.subSequence(index, palavra.length()-index) ,
								pilha);
						
						mudarEstadoAtual(reponses[0]);
					}
					
				}
				
				if(estado == null || !estadoAtual.getFinal()) {
					System.out.println("REJEITA");
				}else {
					System.out.println("ACEITA");
				} 
		}else {
			System.out.println("\n **Automo vazio.** \n");
		}
		
		
	}
	
	public void ImprimirAutomoto() {
		if(this.estados.size() != 0) {
			System.out.printf("\nEstados : {");
			
			for(int i =0; i < estados.size(); i++) {
				System.out.printf("%s,", estados.elementAt(i).nome);
			}
			
			System.out.printf("}\n");
			
			System.out.printf("Estados Finais : {");
			
			for(int i =0; i < estados.size(); i++) {
				if(estados.elementAt(i).Final) {
					System.out.printf("%s,", estados.elementAt(i).nome);
				}
			}
			
			System.out.printf("}\n");
			
			System.out.printf("Transicoes :\n");
			
			for(int i =0; i < estados.size(); i++) {
				estados.elementAt(i).ImprimirTransicoes();
			}
			
			System.out.printf("\n");
		}else {
			System.out.println("\n **Automo vazio.** \n");
		}
		
		
		
		
	}

	public void lerAutomoto() {
		this.estados = new Vector<Estado>();
		this.estadoAtual = null;
		this.pilha = "";
		
		
		try {
			FileReader arq = new FileReader("input.txt");
		    BufferedReader lerArq = new BufferedReader(arq);
		 
		 
		    //pegar a primeira linha 
		    //dividir entre duas string antes e depois do "="
		    //tranformar o segundo valor em inteiro que seria a quantidade de estados
		      String linha = lerArq.readLine(); 
		      String[] palavras = linha.split("=");
		      int qtd = Integer.parseInt(palavras[1]);
		    
		      for(int i=0 ; i < qtd ; i++) {
		    	  this.addEstado("q" + Integer.toString(i));
		     }
		      
		      linha = lerArq.readLine(); 
		      palavras = linha.split("=");
		      String estadosFinais = palavras[1];
		      estadosFinais = estadosFinais.replace("{", "");
		      estadosFinais = estadosFinais.replace("}", "");
      
		      this.setEstadosFinais(estadosFinais);
		      
		      linha = lerArq.readLine(); 
		      linha = lerArq.readLine(); 
		      linha = lerArq.readLine(); 
		      
		      String transicao1;
		      String transicao2;
		      
		      while(linha != null) {
		    	 if(!linha.equals("")) {
		    		 palavras = linha.split("=");
			    	  transicao1 = palavras[0];
			    	  transicao2 = palavras[1];
			    	  transicao1 = transicao1.replace("(", "");
			    	  transicao1 = transicao1.replace(")", "");
			    	  transicao2 = transicao2.replace("(", "");
			    	  transicao2 = transicao2.replace(")", "");
			    	  transicao1 = transicao1.replace(" ", "");
			    	  transicao2 = transicao2.replace(" ", "");
			 	  
			    	  this.addTransicao(transicao1,transicao2);
		    	 }
		   
		    	  linha = lerArq.readLine(); 
		      }
		      
		      System.out.println("\n **Automato lido com sucesso.**\n");
		 
		      arq.close();
		}catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: input.txt\n",
	                e.getMessage());
	       }
		
		
		
	}
	
	
	
}









