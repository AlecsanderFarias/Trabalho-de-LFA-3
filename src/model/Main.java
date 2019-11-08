package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {
	
	public static void main(String args[]) {
		
		Automato teste = new Automato();
	
		
		Scanner ler = new Scanner(System.in);
		
		
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
		    	  teste.addEstado("q" + Integer.toString(i));
		    	  
		     }
		      
		    
	    	  
		      
		      
		      teste.ImprimirAutomoto();
		 
		      arq.close();
		}catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: input.txt\n",
	                e.getMessage());
	       }
		
		
		
	}
	
	
}
