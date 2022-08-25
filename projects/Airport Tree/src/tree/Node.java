package tree;

public class Node<T> {

  T data;
  Node<T> left;
  Node<T> right;

  public Node(T data){
    this.data = data;
    right = null;
    left = null;
  }
  
}
