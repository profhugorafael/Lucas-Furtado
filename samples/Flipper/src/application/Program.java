package application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite P: ");
		int p = sc.nextInt();
		
		System.out.print("Digite R: ");
		int r = sc.nextInt();
		
		if( p == 0 ) {
			System.out.println("C");
		} else if(r == 0) {
			System.out.println("A");
		} else {
			System.out.println("B");
		}
		
	}

}
