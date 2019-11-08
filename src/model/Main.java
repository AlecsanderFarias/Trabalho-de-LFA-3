package model;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {
	
	public static void main(String args[]) {
		

		Automato teste = new Automato();

	    Scanner entrada = new Scanner(System.in);

	    int optionn = 0;
	    while (optionn != 3)
	    {
	       optionn = mostraMenu();
	       switch (optionn) {
	            case 1:
	            	String palavra = entrada.nextLine();
	                System.out.println(palavra);
	                System.out.println("Processa palavra");
	                break;
	            case 2:
	            	System.out.println("Le arquivo");
	                break;
	            case 3:
	            	System.exit(0);
	            default:
	                System.out.println("Entrada invalida");
	        }
	    }
	}


	public static int mostraMenu() {

	    int optionn = 0;
	    Scanner keyboard = new Scanner(System.in);
	    System.out.println("--------------");
	    System.out.println("1.Processar palavra");
	    System.out.println("2.Ler arquivo TXT");
	    System.out.println("3.Sair");
	    System.out.println("--------------");
	    System.out.println("Opcao:");
	    optionn = keyboard.nextInt();

	    return optionn;

	}
	

	
		
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
