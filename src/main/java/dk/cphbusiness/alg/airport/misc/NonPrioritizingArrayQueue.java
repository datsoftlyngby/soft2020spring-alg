package dk.cphbusiness.alg.airport.misc;

import dk.cphbusiness.alg.basics.ArrayQueue;
import dk.cphbusiness.alg.basics.PriorityQueue;

public class NonPrioritizingArrayQueue<T extends Comparable<T>>
  extends ArrayQueue<T> implements PriorityQueue<T> {
  public NonPrioritizingArrayQueue(int capacity) { super(capacity); }
  }
