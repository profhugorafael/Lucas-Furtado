package tree;

import java.sql.RowId;

public class BinaryTree<T extends Comparable<T>> implements BinaryTreeInterface<T> {
  
  private Node<T> root;

  @Override
  public boolean isEmpty() {
    return root == null;
  }

  @Override
  public void add(T data) {
    if(root == null) {
      root = new Node<T>(data);
    } else {
      add(data, root);
    }
  }

  private void add(T data, Node<T> node) {
    if(data.compareTo(node.data) > 0) {
      if(node.right == null) {
        node.right = new Node<T>(data);
      } else {
        add(data, node.right);
      }
    } else {
      if(node.left == null) {
        node.left = new Node<T>(data);
      } else {
        add(data, node.left);
      }
    }
  }

  @Override
  public int count() {
    return count(root);
  }
  
  public int count(Node<T> node) {

    if(node == null) {
      return 0;
    }

    return count(node.left) + 1 + count(node.right);
  }

  @Override
  public T greatest() {
    
    if(root == null) return null;

    Node<T> current = root;

    while(current.right != null) {
      current = current.right;
    }

    return current.data;
  }

  @Override
  public T lowest() {
    if(root == null) return null;

    Node<T> current = root;

    while(current.left != null) {
      current = current.left;
    }

    return current.data;
  }

}
