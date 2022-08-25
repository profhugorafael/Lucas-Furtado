package entities;

public class Vehicle {
  
  private Integer id;
  private String brand;
  private Integer mileage;
  private Integer productionYear;

  public Vehicle(Integer id, String brand, Integer mileage, Integer productionYear) {
    this.id = id;
    this.brand = brand;
    this.mileage = mileage;
    this.productionYear = productionYear;
  }

  public Integer getId() {
    return id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Integer getMileage() {
    return mileage;
  }

  public Integer getProductionYear() {
    return productionYear;
  }

  @Override
  public String toString() {
    String aux = "Vehicle: " + brand + "\n";
    
    aux += "Id = " + id + " | Mileage = ";
    aux += (mileage == null) ?  "Not informed" : mileage;
    aux += "\nProduction Year = " + productionYear;

    return aux;
  }
  
}
