package dk.cphbusiness.alg.graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyGraph implements Graph {
  private boolean isUndirected = true;
  private final int V;
  private int E = 0;
  private final EdgeNode[] vertices;

  public AdjacencyGraph(int V) {
    this.V = V;
    vertices = new EdgeNode[V];
    }

  private class EdgeNode {
    int v;
    EdgeNode next;

    EdgeNode(int v, EdgeNode next) {
      this.v = v;
      this.next = next;
      }
    }

  @Override
  public int getV() { return V; }

  @Override
  public int getE() { return E; }

  @Override
  public void addEdge(int v, int w) {
    EdgeNode node = new EdgeNode(w, vertices[v]);
    vertices[v] = node;
    if (isUndirected) {
      EdgeNode node2 = new EdgeNode(v, vertices[w]);
      vertices[w] = node2;
      }
    }

  @Override
  public Iterable<Integer> adjacents(int v) {
    List<Integer> adjacents = new ArrayList<>();
    EdgeNode node = vertices[v];
    while (node != null) {
      adjacents.add(node.v);
      node = node.next;
      }
    return adjacents;
    }

  @Override
  public String toString() {
    String text = "";
    for (int v = 0; v < V; v++) {
      text += ""+v+": "+adjacents(v)+"\n";
      }
    return text;
    }

  public static void main(String[] args) {
    Graph g = new AdjacencyGraph(6);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(2, 4);
    g.addEdge(3, 4);
    g.addEdge(3, 5);
    g.addEdge(5, 0);
    g.addEdge(5, 3);
    System.out.println(g);
    /*
      0: [2, 1]
      1: []
      2: [4, 3, 0]
      3: [5, 4]
      4: []
      5: [3, 0]
    */
    }

  }
