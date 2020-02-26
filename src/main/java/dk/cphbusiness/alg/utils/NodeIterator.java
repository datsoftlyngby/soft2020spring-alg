package dk.cphbusiness.alg.utils;

import java.util.Iterator;

public class NodeIterator<T> implements Iterator<T> {
  private Node<T> step;

  public NodeIterator(Node<T> first) { this.step = first; }

  @Override
  public boolean hasNext() { return step != null; }

  @Override
  public T next() {
    T value = step.getValue();
    step = step.getNext();
    return value;
    }

  }
