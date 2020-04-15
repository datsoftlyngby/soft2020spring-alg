package dk.cphbusiness.alg.graphs;

import dk.cphbusiness.alg.basics.ArrayStack;
import dk.cphbusiness.alg.basics.Stack;

public class DepthFirstSearch {
  private final Graph graph;
  private int[] visitedFrom;
  private Stack<Edge> edges;

  public DepthFirstSearch(Graph graph) {
    this.graph = graph;
    visitedFrom = new int[graph.getV()];
    for (int v = 0; v < visitedFrom.length; v++) visitedFrom[v] = -1;
    edges = new ArrayStack<>(1_000);
    }

  private class Edge {
    int from;
    int to;

    Edge(int from, int to) {
      this.from = from;
      this.to = to;
      }
    }

  public void searchFrom(int v) {
    edges.push(new Edge(v, v));
    while (!edges.isEmpty()) {
      Edge step = edges.pop();
      visitedFrom[step.to] = step.from;
      int actual = step.to;
      for (int w : graph.adjacents(actual)) {
        if (visitedFrom[w] != -1) edges.push(new Edge(w, actual));
        }
      }
    }

  public String showPathTo(int w) {
    String path = ""+w;
    while (visitedFrom[w] != w && visitedFrom[w] != -1) {
      w = visitedFrom[w];
      path = "-> "+w;
      }
    return path;
    }

  @Override
  public String toString() {
    String text = "";
    for (int v = 0; v < graph.getV(); v++) {
      text += ""+v+": "+showPathTo(v)+"\n";
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

    DepthFirstSearch dfs = new DepthFirstSearch(g);
    dfs.searchFrom(0);
    System.out.println(dfs);
    }

  }
