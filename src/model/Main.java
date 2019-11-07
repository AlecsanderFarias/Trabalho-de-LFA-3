package model;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		
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
	
	
	public void addEstado(String nome) {
		
	}
}
