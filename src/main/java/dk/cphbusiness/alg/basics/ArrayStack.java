package dk.cphbusiness.alg.basics;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class ArrayStack<T> implements Stack<T>  {
  private final T[] items;
  private int top = 0;

  public ArrayStack(int capacity) {
    items = (T[]) new Object[capacity];
    }

  @Override
  public void push(T item) {
    items[top++] = item;
    }

  @Override
  public T pop() {
    return items[--top];
    }

  @Override
  public T peek() {
    return items[top - 1];
    }

  @Override
  public int getSize() {
    return top;
    }

  @NotNull
  @Override
  public Iterator<T> iterator() {
    return null;
  }
}
