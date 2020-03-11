package dk.cphbusiness.alg.basics;

/**
 * Like a Collection in java.util.Collection just without mutability.
 * @param <T>
 */
public interface Container<T> extends Iterable<T> {
  int getSize();
  default boolean isEmpty() { return getSize() == 0; }
  }
