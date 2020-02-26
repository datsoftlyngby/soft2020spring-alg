package dk.cphbusiness.alg.basics;

import dk.cphbusiness.alg.utils.ArrayIterator;
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
  public Iterator<T> iterator() { return new ArrayIterator<>(items, size); }

  @Override
  public boolean isEmpty() { return size == 0; }

  }
