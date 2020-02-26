package dk.cphbusiness.alg.sorting

fun String.before(position: Int) = if (position >= length) this else substring(0, position)
fun String.at(position: Int) = if (position >= length) "" else this[position]
fun String.after(position: Int) = if (position >= length) "" else substring(position + 1)

interface Key {
  val max: Int
  val index: Int
  val length: Int
  val next: Key
  override operator fun equals(other: Any?): Boolean
  }

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
  override fun equals(other: Any?) =
    other is ShakespeareKey &&
    text.length == other.text.length &&
    (position .. text.length).all { this.indexOf(it) == other.indexOf(it) }
  override fun toString() = "${text.before(position)}[${text.at(position)}${text.after(position)}]"
  }

sealed class Trie<V> : Iterable<Pair<Key,V>> {
  // abstract fun add(key: Key, value: V): Trie<V>
  abstract fun add(key: Key, action: (V?) -> V): Trie<V>
  abstract fun find(key: Key): V?
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

    override fun iterator(): Iterator<Pair<Key, V>> = iterator {
      yield(key to value)
      }

    }

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

fun main() {
  val trie = ShakespeareTrie<String>()
  trie["Anders"] = "Anders Kalhauge"
  trie["Anna"] = "Anna Kalhauge"
  trie["And"] = "Anders And"
  trie["Anders And"] = "Anders And & Co."
  trie["shakespeare"] = "William Shakespeare"
  trie.forEach { println("${it.first} --> ${it.second}") }
  println(trie["And"])
  println("-------")

  val counter = ShakespeareCountTrie()
  counter.add("Anders")
  counter.add("Anna")
  counter.add("Anders And")
  counter.add("shakespeare")
  counter.add("Anna")
  counter.add("Anna")
  counter.add("And")
  counter.forEach { println("${it.first} --> ${it.second}") }
  println(counter["anna"])
  }