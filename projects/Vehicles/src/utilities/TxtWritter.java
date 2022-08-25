package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import entities.Vehicle;

public class TxtWritter {
  
  private BufferedWriter writer;

  public void open(String filename) throws IOException {
    File absoluteFile = new File("");
    String absolutePath = absoluteFile.getAbsolutePath();
    String fullpath = absolutePath + "\\" + filename + ".txt";
    writer = new BufferedWriter(new FileWriter(fullpath));
  }

  public void writeVehicles(List<Vehicle> vehicles) throws IOException {
    writer.write("id,brand,mileage,production_year\n");

    for(Vehicle vehicle : vehicles) {
      String aux = vehicle.getId() + "," + vehicle.getBrand() + ",";
      aux += (vehicle.getMileage() == null) ? " " : vehicle.getMileage();
      aux += "," + vehicle.getProductionYear() + "\n";
      writer.write(aux);
    }
  }

  public void close() throws IOException {
    writer.close();
  }

}
