package dk.cphbusiness.alg.graphs;

public interface Graph {
  int getV(); // get number of vertices V
  int getE(); // get number of edges E
  void addEdge(int v, int w); // add an edge from vertice v to vertice w
  Iterable<Integer> adjacents(int v); // list all adjacent vertices to vertice v
  }
