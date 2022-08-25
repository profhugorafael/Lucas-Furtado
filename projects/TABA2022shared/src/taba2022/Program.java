package taba2022;

public class Program {
  
  public static void main(String[] args) throws InterruptedException {
    Country.generateData();
    Country country = new Country();

    for(int i=1; i <= 5; i++) {
      new Thread(new CountryThread(i, country)).start();
    }

    Thread.sleep(3000);
    
    System.out.println("------------------");

    System.out.println("GRAND TOTAL = " + country.computeGrandSum());
    System.out.println("TOTAL AVERAGE = " + country.computeGrandAverage());
    System.out.println("MAXIMUM = " + country.computeGrandMax());
    System.out.println("MINIMUM = " + country.computeGrandMin());

  }

}
