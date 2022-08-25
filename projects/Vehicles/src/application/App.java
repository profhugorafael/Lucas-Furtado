package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Vehicle;
import utilities.TxtReader;
import utilities.TxtWritter;

public class App {

    private static List<Vehicle> vehicles;

    private static void readVehicles() {
        TxtReader fileReader = new TxtReader();

        try {
            fileReader.open("Vehicles");
            vehicles = fileReader.extractVehicles();
        } catch (FileNotFoundException notFoundException) {
            System.err.println("Sorry, cannot find file.");
        } catch (IOException ioException) {
            System.err.println("Error while manipulating the file.");
        }

        try {
            fileReader.close();
        } catch (IOException ioException){
            System.err.println("Error to close the file!");
        }

    }

    public static void filterVehicles(String brand) {
        List<Vehicle> otherList = new ArrayList<>();

        for(Vehicle vehicle : vehicles) {
            if(vehicle.getBrand().equals(brand)) {
                otherList.add(vehicle);
            }
        }

        TxtWritter fileWritter = new TxtWritter();

        try {
            fileWritter.open("Ford");
            fileWritter.writeVehicles(otherList);
        } catch (IOException ioException) {
            System.err.println("Error to write in this file!");
        }

        try {
            fileWritter.close();
        } catch (IOException ioException) {
            System.err.println("Error to close the file!");
        }
    }

    public static void filterMissingMileage() {
        List<Vehicle> otherList = new ArrayList<>();

        for(Vehicle vehicle : vehicles) {
            if(vehicle.getMileage() == null) {
                otherList.add(vehicle);
            }
        }

        TxtWritter fileWritter = new TxtWritter();

        try {
            fileWritter.open("Missing_Mileage");
            fileWritter.writeVehicles(otherList);
        } catch (IOException ioException) {
            System.err.println("Error to write in this file!");
        }

        try {
            fileWritter.close();
        } catch (IOException ioException) {
            System.err.println("Error to close the file!");
        }
    }

    public static void main(String[] args) {

        readVehicles();

        System.out.println("PRINTING ALL VEHICLES!");
        System.out.println("-----------------------");

        for(Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
            System.out.println("-----------------------");
        }
        
        System.out.println();
        System.out.println("Writing files with 'Ford' brand...");

        filterVehicles("Ford");

        System.out.println("The file has been created!");
        System.out.println();
        System.out.println("-----------------------");
        System.out.println();
        System.out.println("Writing files with missing mileage...");

        filterMissingMileage();
        
        System.out.println("The file has been created!");
        System.out.println();
        System.out.println("-----------------------");
    }
}
