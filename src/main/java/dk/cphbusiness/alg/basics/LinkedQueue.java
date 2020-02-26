package dk.cphbusiness.alg.basics;

import dk.cphbusiness.alg.utils.Node;
import dk.cphbusiness.alg.utils.NodeIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class LinkedQueue<T extends Comparable<T>> implements Queue<T> {
  private Node<T> first = null;
  private Node<T> last = null;
  private int size = 0;

  @Override
  public void enqueue(T item) {
    size++;
    if (last == null) last = first = new Node(item, null);
    else last = new Node(item, last);
    }

  @Override
  public T dequeue() {
    size--;
    T item = first.getValue(); // throws if first == null
    first = first.getNext();
    if (first == null) last = null;
    return item;
    }

  @Override
  public T peek() { return first.getValue(); }

  @Override
  public int getSize() { return size; }

  @Override
  public boolean isEmpty() { return size == 0; }

  @NotNull
  @Override
  public Iterator<T> iterator() { return new NodeIterator<>(first); }

  }
