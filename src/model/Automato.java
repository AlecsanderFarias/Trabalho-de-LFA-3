package model;

import java.util.Vector;
import model.Estado;

public class Automato {
	public Vector<Estado> estados;
	public Estado estadoAtual = null;
	public Vector<String> pilha;
	public String alfabeto;
	
	
	public Automato() {
		this.estados = null;
		this.pilha = null;
		this.alfabeto = null;
	}
	

	public void addEstado(String nome) {
		estados.add(new Estado(nome));
	}
	

	
	
	
}
