package dk.cphbusiness.alg.basics;

import dk.cphbusiness.alg.utils.Node;
import dk.cphbusiness.alg.utils.NodeIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class LinkedBag<T> implements Bag<T> {
  private Node<T> first = null;
  private int size = 0;

  @Override
  public int getSize() { return size; }

  @Override
  public boolean isEmpty() { return first == null; }

  @Override
  public void add(T item) {
    size++;
    first = new Node(item, first);
    }

  @NotNull
  @Override
  public Iterator<T> iterator() { return new NodeIterator<>(first); }

  }
