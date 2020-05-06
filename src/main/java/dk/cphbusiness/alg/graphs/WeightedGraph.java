package dk.cphbusiness.alg.graphs;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
  private List<Edge>[] vertices;

  public WeightedGraph(int V) {
    vertices = (List<Edge>[])(new ArrayList[V]);
    for (int v = 0; v < V; v++) vertices[v] = new ArrayList<>();
    }

  public void addEdge(int v, int w, double weight) {
    Edge edge = new Edge(v, w, weight);
    vertices[v].add(edge);
    }

  public void addUndirectedEdge(int v, int w, double weight) {
    addEdge(v, w, weight);
    addEdge(w, v, weight);
    }

  public int getV() { return vertices.length; }

  public Iterable<Edge> adjacents(int v) { return vertices[v]; }

  class Edge {
    int from;
    int to;
    double weight;

    public Edge(int from, int to, double weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
      }

    }

  }
