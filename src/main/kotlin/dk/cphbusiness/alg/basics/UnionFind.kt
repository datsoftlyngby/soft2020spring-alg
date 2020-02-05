package dk.cphbusiness.alg.basics

interface UnionFind {
  fun union(p: Int, q: Int)
  fun find(p: Int): Int
  fun connected(p: Int, q: Int): Boolean
  fun count(): Int
  }

class MyFirstUnionFind(count: Int) : UnionFind {
  override fun union(p: Int, q: Int) {
    TODO("implement function union")
    }

  override fun find(p: Int) : Int {
    TODO("implement function find")
    }

  override fun connected(p: Int, q: Int): Boolean {
    TODO("implement function connected")
    }

  override fun count(): Int {
    TODO("implement function count")
    }

}