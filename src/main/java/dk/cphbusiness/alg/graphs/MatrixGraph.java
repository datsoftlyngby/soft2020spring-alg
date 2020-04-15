package dk.cphbusiness.alg.graphs;

import java.util.ArrayList;
import java.util.List;

public class MatrixGraph implements Graph {
  private final int V;
  private int E = 0;
  private boolean[][] edges;

  public MatrixGraph(int V) {
    this.V = V;
    edges = new boolean[V][V];
    }

  @Override
  public int getV() { return V; }

  @Override
  public int getE() { return E; }

  @Override
  public void addEdge(int v, int w) {
    edges[v][w] = true;
    E++;
    }

  @Override
  public Iterable<Integer> adjacents(int v) {
    List<Integer> adjacents = new ArrayList<>();
    for (int w = 0; w < V; w++)
        if (edges[v][w]) adjacents.add(w);
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
    Graph g = new MatrixGraph(6);
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
    }


  }
