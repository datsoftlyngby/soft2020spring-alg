package dk.cphbusiness.alg.sorting

class TreeSumKey(val number: Int, private val position: Int = 0) : Key {
  override val max = 2
  override val index get() = (number shr position) and 1
  override val length = 24
  override val next get() = TreeSumKey(number, position + 1)
  override fun includes(other: Key): Boolean {
    TODO("implement function includes")
    }

  override fun equals(other: Any?) = other is TreeSumKey && other.number == this.number

  override fun toString(): String {
    val bin = (number and 0xffffff).toString(2)
    val text = "000000000000000000000000$bin".substring(bin.length, bin.length + length)
    return "${text.before(text.length - position)}[${text.at(text.length - position)}${text.after(text.length - position)}]"
    }
  }

class TreeSumTrie : Iterable<Pair<Key,Int>> {
  var trie: Trie<Int>? = null
  operator fun set(number: Int, value: Int) {
    if (trie == null) trie = Trie.KeyTrie(TreeSumKey(number), { value })
    else trie = trie?.add(TreeSumKey(number)) { value }
    }
  operator fun get(number: Int) =
    trie?.find(TreeSumKey(number))

  override fun iterator(): Iterator<Pair<Key, Int>> = iterator { trie?.let { yieldAll(it) } }
  }

fun main() {
  //println(TreeSumKey(17))
  val trie = TreeSumTrie()
  trie[7] = 7
  trie[17] = 17
  trie[-10] = -10
  trie[3] = 3
  trie[9] = 9
  trie[-19] = -19
  trie[5] = 5
  trie[0] = 0
  trie.forEach { println("${it.first} --> ${it.second}") }

  }