package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Vehicle;

public class TxtReader {

  private BufferedReader reader;

  public void open(String filename) throws FileNotFoundException {
    File absoluteFile = new File("");
    String absolutePath = absoluteFile.getAbsolutePath();
    String fullpath = absolutePath + "\\" + filename + ".txt";
    reader = new BufferedReader(new FileReader(fullpath));
  }

  public List<Vehicle> extractVehicles () throws IOException {
    List<Vehicle> vehicles = new ArrayList<>();

    // consuming the first line
    reader.readLine();
    String line;

    while( (line = reader.readLine()) != null ){
      String[] data = line.split(",");
      Integer mileage = (data[2].equals(" ")) ? null : Integer.parseInt(data[2]);

      vehicles.add(new Vehicle(
        Integer.parseInt(data[0]),
        data[1],
        mileage,
        Integer.parseInt(data[3])));
    }

    return vehicles;
  }

  public void close() throws IOException {
    reader.close();
  }

}
