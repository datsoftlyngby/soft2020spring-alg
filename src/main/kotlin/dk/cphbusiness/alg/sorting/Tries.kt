package dk.cphbusiness.alg.sorting

import dk.cphbusiness.alg.utils.stopwatch
import dk.cphbusiness.alg.utils.toStringArray
import java.io.File

fun String.before(position: Int) = if (position >= length) this else substring(0, position)
fun String.at(position: Int) = if (position >= length) "" else this[position]
fun String.after(position: Int) = if (position >= length) "" else substring(position + 1)

interface Key {
  val max: Int
  val index: Int
  val length: Int
  val next: Key
  fun includes(other: Key): Boolean
  override operator fun equals(other: Any?): Boolean
  }

sealed class Trie<V> : Iterable<Pair<Key,V>> {
  // abstract fun add(key: Key, value: V): Trie<V>
  abstract fun add(key: Key, action: (V?) -> V): Trie<V>
  abstract fun find(key: Key): V?
  abstract fun locate(key: Key): Trie<V>?
  class ArrayTrie<V>(key: Key, action: (V?) -> V) : Trie<V>() {
    private val tries = arrayOfNulls<Trie<V>>(key.max + 1)
    init {
      tries[key.index] = KeyTrie(key.next, action)
      }

    override fun add(key: Key, action: (V?) -> V): Trie<V> {
      when (val trie = tries[key.index]) {
        null -> tries[key.index] = KeyTrie(key.next, action)
        else -> tries[key.index] = trie.add(key.next, action)
        }
      return this
      }

    override fun find(key: Key) = tries[key.index]?.find(key.next)

    override fun locate(key: Key): Trie<V>? =
      if (key.length == 0) this
      else tries[key.index]?.locate(key.next)

    override fun iterator(): Iterator<Pair<Key, V>> = iterator {
      tries.filterNotNull().forEach { yieldAll(it) }
      }

    }

  class KeyTrie<V>(val key: Key, action: (V?) -> V): Trie<V>() {
    var value: V = action(null)

    override fun add(key: Key, action: (V?) -> V): Trie<V> {
      if (this.key == key) return this.apply { value = action(value) }
      return ArrayTrie(this.key) { _: V? -> this.value }.apply {
        add(key, action)
        }
      }

    override fun find(key: Key) = if (this.key == key) value else null

    override fun locate(key: Key): Trie<V>? =
      if (key.length == 0 || this.key.includes(key)) this
      else null

    override fun iterator(): Iterator<Pair<Key, V>> = iterator {
      yield(key to value)
      }

    }

  }

