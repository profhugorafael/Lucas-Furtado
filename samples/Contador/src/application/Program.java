package application;

public class Program {

	public static void main(String[] args) {

		int numero = 1; // inicialização
		
		while( true ) { // verificação
						
			if(numero >= 10 ) {
				System.out.println("Fim! | numero = " + numero); 
				break;
			} 
			
			numero++; // atualização
			
			if(numero%2 != 0) {
				System.out.println("Continuando... | numero = " + numero); 
			}			
			
		}
		
	}

}
