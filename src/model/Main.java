package model;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {
	
	public static void main(String args[]) {
		

		Automato aut = new Automato();

	    Scanner entrada = new Scanner(System.in);

	    int optionn = 0;
	    while (optionn != 4)
	    {
	       optionn = mostraMenu();
	       switch (optionn) {
	            case 1:
	            	System.out.println("Escreva a palavra a ser processada.");
	            	String palavra = entrada.nextLine();
	                aut.processarPalavra(palavra);
	                break;
	            case 2:
	            	limpartTerminal();
	            	aut.lerAutomoto();
	                break;
	                
	            case 3:
	            	limpartTerminal();
	            	aut.ImprimirAutomoto();;
	            	break;
	            case 4:
	            	System.exit(0);
	            default:
	                System.out.println("Entrada invalida");
	        }
	    }
	}


	public static int mostraMenu() {

	    int optionn = 0;
	    Scanner keyboard = new Scanner(System.in);
	    System.out.println("\n--------------");
	    System.out.println("1.Processar palavra");
	    System.out.println("2.Ler arquivo TXT");
	    System.out.println("3.Imprimir Automato");
	    System.out.println("4.Sair");
	    System.out.println("--------------");
	    System.out.println("Opcao:");
	    optionn = keyboard.nextInt();

	    return optionn;

	}
	

	public static void limpartTerminal() {
		for (int i = 0; i < 50; ++i) System.out.println();
	}

	
	
		
	
	
}
