package dk.cphbusiness.alg.basics;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class ArrayBag<T> implements Bag<T> {
  private T[] items;
  private int size = 0;

  public ArrayBag(int capacity) {
    items = (T[])(new Object[capacity]);
    }

  @Override
  public int getSize() { return size; }

  @Override
  public void add(T item) {
    items[size++] = item;
    }

  @NotNull
  @Override
  public Iterator<T> iterator() { return new ArrayIterator(); }

  private class ArrayIterator implements Iterator<T> {
    int index = 0;
    @Override
    public boolean hasNext() { return index < size; }
    @Override
    public T next() { return items[index++]; }
    }

  @Override
  public boolean isEmpty() { return size == 0; }

  public static void main(String[] args) {
    Bag b = new ArrayBag<Integer>(10);
    b.add(7);
    b.add(9);
    b.add(13);
    for (Object item : b) System.out.println(item);
    }
  }
