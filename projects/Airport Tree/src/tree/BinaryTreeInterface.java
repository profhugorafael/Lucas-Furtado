package tree;

public interface BinaryTreeInterface<T> {
  public boolean isEmpty();
  public void add(T data);
  public int count();
  public T greatest();
  public T lowest();
}
