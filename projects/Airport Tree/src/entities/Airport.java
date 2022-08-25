package entities;
public class Airport implements Comparable<Airport> {

  private String name;
  private String location;
  private int waitingIndex;

  public Airport() {
  }

  public Airport(String name, String location, int waitingIndex) {
    this.name = name;
    this.location = location;
    this.waitingIndex = waitingIndex;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public int getWaitingIndex() {
    return waitingIndex;
  }

  public void setWaitingIndex(int waitingIndex) {
    this.waitingIndex = waitingIndex;
  }

  @Override
  public String toString(){
    String aux = "Airport: " + name + "\n";
    aux += "Location: " + location + "\n";
    aux += "Waiting index: " + waitingIndex + "\n";
    return aux;
  }

  @Override
  public int compareTo(Airport other) {
    return -1*Integer.compare(this.waitingIndex, other.waitingIndex);
  }
}
