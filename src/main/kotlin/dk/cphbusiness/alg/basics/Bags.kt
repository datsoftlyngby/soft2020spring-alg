package dk.cphbusiness.alg.basics

class ArrayBasedBag<T>(capacity: Int) : Bag<T> {
  val items: Array<T?> = arrayOfNulls<Any>(capacity) as Array<T?>
  override var size = 0

  override fun add(item: T) { items[size++] = item }

  override fun iterator(): Iterator<T> = iterator<T> {
    items.take(size).forEach { yield(it!!) }
    }

  }

class LinkBasedBag<T> : Bag<T> {
  var first: Node<T>? = null
  override var size = 0

  override fun add(item: T) {
    size++
    first = Node(item, first)
    }

  override fun iterator(): Iterator<T> = iterator<T> {
    var step = first
    while (step != null) {
      yield(step.value)
      step = step.next
      }
    }

  data class Node<T>(val value: T, val next: Node<T>?)

  }