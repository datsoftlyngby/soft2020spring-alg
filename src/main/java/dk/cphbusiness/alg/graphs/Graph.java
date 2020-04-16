package dk.cphbusiness.alg.graphs;

public interface Graph {
  int getV(); // get number of vertices V
  int getE(); // get number of edges E
  void addEdge(int v, int w); // add an edge from vertice v to vertice w
  default void addUndirectedEdge(int v, int w) {
    addEdge(v, w);
    addEdge(w, v);
    }
  Iterable<Integer> adjacents(int v); // list all adjacent vertices to vertice v
  }
