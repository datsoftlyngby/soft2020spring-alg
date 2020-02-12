package dk.cphbusiness.alg.basics;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class LinkedBag<T> implements Bag<T> {
  private Node first = null;

  @Override
  public int getSize() { return first == null ? 0 : first.length(); }

  @Override
  public boolean isEmpty() { return first == null; }

  @Override
  public void add(T item) { first = new Node(item, first); }

  @NotNull
  @Override
  public Iterator<T> iterator() { return new LinkedIterator(); }

  private class LinkedIterator implements Iterator<T> {
    private Node step = first;
    @Override
    public T next() {
      T item = step.item;
      step = step.next;
      return item;
      }
    @Override
    public boolean hasNext() { return step != null; }
    }

  private class Node {
    T item;
    Node next;
    Node (T item, Node next) {
      this.item = item;
      this.next = next;
      }
    int length() {
      if (next == null) return 1;
      return next.length() + 1;
      }
    }

  public static void main(String[] args) {
    Bag b = new LinkedBag<Integer>();
    b.add(7);
    b.add(9);
    b.add(13);
    for (Object item : b) System.out.println(item);
    }
 }
