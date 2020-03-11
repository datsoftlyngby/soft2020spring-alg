package dk.cphbusiness.alg.basics;

import dk.cphbusiness.alg.utils.ArrayIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class ArrayQueue<T> implements Queue<T> {
  private final T[] items;
  private int start = 0;
  private int end = 0;

  public ArrayQueue(int capacity) {
    items = (T[]) new Object[capacity];
    }

  @Override
  public int getSize() { return end - start; }

  @Override
  public void enqueue(T item) {
    items[end++] = item;
    end = end%items.length;
    }

  @Override
  public T dequeue() {
    T item = items[start++];
    start = start%items.length;
    return item;
    }

  @Override
  public T peek() { return items[start]; }

  @NotNull
  @Override
  public Iterator<T> iterator() {
    return new ArrayIterator<>(items, start, end);
    }

  }
