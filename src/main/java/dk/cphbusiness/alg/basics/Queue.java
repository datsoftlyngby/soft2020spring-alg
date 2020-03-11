package dk.cphbusiness.alg.basics;

public interface Queue<T> extends Container<T> {
  void enqueue(T item);
  T dequeue();
  T peek();
  }
