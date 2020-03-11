package dk.cphbusiness.alg.utils;

@FunctionalInterface
public interface HashFunction<K> {
  int function(K key);
  }
