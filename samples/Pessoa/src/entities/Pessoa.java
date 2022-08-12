package entities;

public class Pessoa {

	// atributos
	private String name;
	private String phoneNumber;
	private int age; 
	private double height;
	private double balance;
	
	// construtor
	// overload
	public Pessoa(String name, int age, double height) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.balance = 0.0;
	}
	
	public Pessoa(String name, int age, double height, double balance) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.balance = balance;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAge() {
		return age;
	}

	public double getHeight() {
		return height;
	}
	
	public double getBalance() {
		return balance;
	}

	// methods
	public void makeBirthday() {
		this.age++;
	}
	
	public double withdraw(double amount) {
		this.balance -= amount;
		return this.balance;
	}

	public boolean deposit(double amount) {
		balance += amount;
		return true;
	}
	
}