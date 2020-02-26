package dk.cphbusiness.alg.basics;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
// import static org.hamcrest.core.*;

public class QueueTest {
  @Test
  public void testArrayQueue() {
    ArrayQueue<String> queue = new ArrayQueue<>(4);
    queue.enqueue("Abel");
    queue.enqueue("Bent");

    Iterator<String> iterator = queue.iterator();
    assertTrue(iterator.hasNext());
    assertEquals("Abel", iterator.next());
    assertEquals("Bent", iterator.next());
    assertFalse(iterator.hasNext());

    queue.enqueue("Cleo");
    iterator = queue.iterator();
    assertTrue(iterator.hasNext());
    assertEquals("Abel", iterator.next());
    assertEquals("Bent", iterator.next());
    assertEquals("Cleo", iterator.next());
    assertFalse(iterator.hasNext());

    assertEquals("Abel", queue.dequeue());
    queue.enqueue("Dora");
    iterator = queue.iterator();
    assertTrue(iterator.hasNext());
    assertEquals("Bent", iterator.next());
    assertEquals("Cleo", iterator.next());
    assertEquals("Dora", iterator.next());
    assertFalse(iterator.hasNext());

    assertEquals("Bent", queue.dequeue());
    queue.enqueue("Eric");
    iterator = queue.iterator();
    assertTrue(iterator.hasNext());
    assertEquals("Cleo", iterator.next());
    assertEquals("Dora", iterator.next());
    assertEquals("Eric", iterator.next());
    assertFalse(iterator.hasNext());
    }

  }
