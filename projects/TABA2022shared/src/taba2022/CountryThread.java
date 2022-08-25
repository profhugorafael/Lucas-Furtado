package taba2022;

public class CountryThread implements Runnable {

  private int numberOfTheCountry;
  private Country country;

  public CountryThread() {
  }

  public CountryThread(int numberOfTheCountry, Country country) {
    this.numberOfTheCountry = numberOfTheCountry;
    this.country = country;
  }
  
  @Override
  public void run() {
      int pos = numberOfTheCountry-1;
      long sum = 0;
      int size = 0,
          max = Country.countries[1].get(0),
          min = Country.countries[1].get(0);

      for(Integer value : Country.countries[pos]) {
        sum += value;
        size++;
        max = (max > value) ? max : value;
        min = (min < value) ? min : value;
      }

      float average = (float) sum / (float) size;

      try {
        country.sum[pos] = sum;
        country.average[pos] = average;
        country.max[pos] = max;
        country.min[pos] = min;

        
        synchronized (this){
          printData(sum, max, min, average);
        }
        Thread.sleep(2000);

        System.out.println("I'm done with the Country #" + numberOfTheCountry);
      } catch (InterruptedException interruptedException) {
      }
  }

  private void printData(long sum, int max, int min, float average) throws InterruptedException {
    System.out.println("COUNTRY #" + numberOfTheCountry);
    Thread.sleep(200);
    System.out.println("SUM # " + numberOfTheCountry + " = " + sum);
    Thread.sleep(200);
    System.out.println("AVERAGE # " + numberOfTheCountry + " = " + average);
    Thread.sleep(200);
    System.out.println("MAX # " + numberOfTheCountry + " = " + max);
    Thread.sleep(200);
    System.out.println("MIN # " + numberOfTheCountry + " = " + min);
  }

}
