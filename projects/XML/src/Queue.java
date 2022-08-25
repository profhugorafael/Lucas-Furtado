public class Queue {

  private Node first;
  private Node last;

  public void enqueue(String tag) {
    if (first == null) {
      first = new Node(tag);
      last = first;
    } else {
      Node aux = new Node(tag);
      last.next = aux;
      last = last.next;
    }
  }

  public void dequeue() {
    if (first != null) {
      if (first == last) {
        last = null;
        first = last;
      } else {
        first = first.next;
      }
    }
  }

  public String peek() {
    if (first == null) {
      return null;
    } else {
      return first.tag;
    }
  }

  @Override
  public String toString() {
    int pos = 0;
    Node aux = first;
    String output = "QUEUE data: \n";

    while(aux != null) {
      output += " position " + pos + " = " + aux.tag + "\n";
      aux = aux.next;
      pos++;
    }

    output += "-----------------------\n";
    return output;
  }
}
