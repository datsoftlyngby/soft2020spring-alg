package dk.cphbusiness.alg.utils;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
  private final T[] items;
  private int index;
  private final int end;

  public ArrayIterator(T[] items, int start, int end) {
    this.items = items;
    this.index = start;
    this.end = end;
    }

  public ArrayIterator(T[] items, int end) {
    this(items, 0, end);
    }

  @Override
  public boolean hasNext() { return index != end; }

  @Override
  public T next() {
    T item = items[index++];
    index = index%items.length;
    return item;
    }

  }
