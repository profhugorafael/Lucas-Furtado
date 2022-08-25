import entities.Airport;
import tree.BinaryTree;

public class App {
    public static void main(String[] args) throws Exception {
        BinaryTree<Airport> airports = new BinaryTree<>();

        airports.add(new Airport("galeao", "brazil-rj", 5));
        airports.add(new Airport("congonhas", "brazil-sp", 2));
        airports.add(new Airport("carlos dumont", "brazil-rj", 7));
        airports.add(new Airport("brasilia", "brazil-bsb", 4));
        airports.add(new Airport("fortaleza", "brazil-for", 8));
        airports.add(new Airport("rio grande do sul", "brazil-rs", 3));
        airports.add(new Airport("manaus", "brazil-mn", 10));

        System.out.println("NUMBER OF AIRPORTS = " + airports.count());
        System.out.println("THE TREE IS EMPTY ? " + airports.isEmpty());
        
        System.out.println("BEST AIRTPORT: ");
        System.out.println(airports.greatest());

        System.out.println("WORST AIRPORT: ");
        System.out.println(airports.lowest());
    }
}
