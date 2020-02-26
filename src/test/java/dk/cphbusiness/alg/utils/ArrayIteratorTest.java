package dk.cphbusiness.alg.utils;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Iterator;

public class ArrayIteratorTest {
  @Test
  public void testEmptyArray() {
    String[] names = new String[4];
    Iterator<String> iterator = new ArrayIterator<>(names, 0);
    assertFalse(iterator.hasNext());
    }

  @Test
  public void testNonEmptyArray() {
    String[] names = new String[4];
    names[0] = "Anders";
    names[1] = "Bente";
    names[2] = "Christine";
    Iterator<String> iterator = new ArrayIterator<>(names, 3);
    assertTrue(iterator.hasNext());
    assertEquals("Anders", iterator.next());
    assertEquals("Bente", iterator.next());
    assertEquals("Christine", iterator.next());
    assertFalse(iterator.hasNext());
    }

  @Test
  public void testNonEmptyFoldetArray() {
    String[] names = new String[4];
    names[2] = "Anders";
    names[3] = "Bente";
    names[0] = "Christine";
    Iterator<String> iterator = new ArrayIterator<>(names, 2, 1);
    assertTrue(iterator.hasNext());
    assertEquals("Anders", iterator.next());
    assertEquals("Bente", iterator.next());
    assertEquals("Christine", iterator.next());
    assertFalse(iterator.hasNext());
    }

  }
