package dk.cphbusiness.alg.sorting

import dk.cphbusiness.alg.utils.stopwatch
import dk.cphbusiness.alg.utils.toStringArray
import java.io.File

class ShakespeareKey(val text: String, val position: Int = 0) : Key {
  override val max = 'z' - 'a' + 2
  private fun indexOf(position: Int) =
    if (position >= text.length) 0
    else when (text[position]) {
      in 'a'..'z' -> text[position] - 'a' + 1
      in 'A'..'Z' -> text[position] - 'A' + 1
      else -> max
      }
  override val index get() = indexOf(position)
  override val length get() = text.length - position
  override val next get() = ShakespeareKey(text, position + 1)
  override fun includes(other: Key): Boolean {
    TODO("implement function includes")
    }
  override fun equals(other: Any?) =
    other is ShakespeareKey &&
    text.length == other.text.length &&
    (position .. text.length).all { this.indexOf(it) == other.indexOf(it) }
  override fun toString() = "${text.before(position)}[${text.at(position)}${text.after(position)}]"
  }

class ShakespeareTrie<V> : Iterable<Pair<Key, V>> {
  var trie: Trie<V>? = null
  operator fun set(word: String, value: V) {
    if (trie == null) trie = Trie.KeyTrie(ShakespeareKey(word), { value })
    else trie = trie?.add(ShakespeareKey(word)) { value }
    }
  operator fun get(word: String) =
    trie?.find(ShakespeareKey(word))

  override fun iterator(): Iterator<Pair<Key, V>> = iterator { trie?.let { yieldAll(it) } }
  }

class ShakespeareCountTrie : Iterable<Pair<Key, Int>> {
  var trie: Trie<Int>? = null
  fun add(word: String) {
    if (trie == null) trie = Trie.KeyTrie(ShakespeareKey(word)) { it?.plus(1) ?: 1 }
    else trie = trie?.add(ShakespeareKey(word)) { it?.plus(1) ?: 1 }
    }
  operator fun get(word: String) =
    trie?.find(ShakespeareKey(word))

  override fun iterator(): Iterator<Pair<Key, Int>> = iterator { trie?.let { yieldAll(it) } }
  }

fun tryShakespeareCountTrie() {
  val counter = ShakespeareCountTrie()
  val words = File("/Users/AKA/DatSoftLyngby/soft2020spring-alg/data/shakespeare-complete-works.txt").toStringArray("[^A-Za-z']+")
  val millis = stopwatch {
    words.forEach { counter.add(it) }
    }
  println(millis)
  counter.filter { it.second > 10000 }.forEach { println("${it.first} --> ${it.second}") }
  println(counter["be"])
  }

fun main() {
  tryShakespeareCountTrie()
  }