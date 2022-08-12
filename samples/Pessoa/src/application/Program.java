package application;

import entities.Pessoa;

public class Program {
	
	public static void main(String[] args) {
		
		// criando uma pessoa	
		Pessoa jhon = new Pessoa("Jhon", 15, 1.75 , 1000.0);
		Pessoa test = new Pessoa("test", 15, 1.70);
				
		// usando uma pessoa
		System.out.println( "New Balance = $" + jhon.deposit(200) );
		System.out.println( "New Balance = $" + jhon.withdraw(200) );
		
		System.out.println(jhon.getName());
		System.out.println(jhon.getAge());
		System.out.println(jhon.getBalance());
		
	}

}
