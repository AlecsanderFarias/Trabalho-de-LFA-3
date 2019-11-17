package model;

/**
 * Transições entre autômatos
 */
public class Transicao {

	public char simbolo;
	public String simboloRemoverPilha;
	public String simboloAddPilha;
	public String estadoResultante;
	
	
	  /**
     * Construtor da classe
     *
     * @param simbolo          Símbolo da transição
     * @param estadoResultante Estado para aonde irá transitar
     */
	public Transicao(char simbolo, String simboloRemoverPilha , String simboloAddPilha  , String estadoResultante ) {
		this.simbolo = simbolo;
		this.simboloRemoverPilha = simboloRemoverPilha;
		this.simboloAddPilha = simboloAddPilha;
		this.estadoResultante = estadoResultante;
	}
	
	/**
     * Verificar se é possível fazer a transição atual
     *
     * @param simbolo    Símbolo a ser processado
     * @param pilha        Último símbolo da pilha
     * @return Verdadeiro ou Falso para Transição Válida
     */
	public boolean ehValida(char simbolo, String pilha) {
		
		if(this.simbolo == simbolo || this.simbolo == '@') {
			if(!this.simboloRemoverPilha.equals("@") ) {
				return this.simboloRemoverPilha.equals(pilha.substring(pilha.length() - simboloRemoverPilha.length()))  ? true : false;
			}else {
				return true;
			}
			
		}
		
		return false;
	}
	
	 /**
     * Retorna o nome do estado resultante
     *
     * @return Nome do estado resultante
     */
	public String getEstado() {
		return estadoResultante;
	}
	
	public void imprimirTransicao() {
		System.out.printf("simbolo: %c, add: %s, remove: %s , goTo: %s \n",
				this.simbolo,
				this.simboloAddPilha,
				this.simboloRemoverPilha,
				this.estadoResultante );	
	}
	
	public String mudarPilha(String pilha) {
		
		//se o simboloRemoverPilha for diferente de "@"
		//exclua a mesma quantidade de caracteres do simboloRemoverPilha do final da pilha
		if(!simboloRemoverPilha.equals("@")) {
			pilha = pilha.substring(0,pilha.length() - simboloRemoverPilha.length());
		}
		
		//se o simboloAddPilha for diferente de "@"
		//adicione no final da pilha o simboloAddPilha
		if(!simboloAddPilha.equals("@")) {
			pilha = pilha + simboloAddPilha;
		}
		
		return pilha;
		
		
		
	}
	
	
}
