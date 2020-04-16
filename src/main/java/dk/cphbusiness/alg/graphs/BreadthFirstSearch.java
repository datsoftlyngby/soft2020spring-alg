package dk.cphbusiness.alg.graphs;

import dk.cphbusiness.alg.basics.ArrayQueue;
import dk.cphbusiness.alg.basics.Queue;

import java.io.PrintStream;

public class BreadthFirstSearch {
  private final Graph graph;
  private int[] visitedFrom;
  private Queue<Edge> edges;

  public BreadthFirstSearch(Graph graph) {
    this.graph = graph;
    visitedFrom = new int[graph.getV()];
    for (int v = 0; v < visitedFrom.length; v++) visitedFrom[v] = -1;
    edges = new ArrayQueue<>(1_000);
    }

  private class Edge {
    int from;
    int to;

    Edge(int from, int to) {
      this.from = from;
      this.to = to;
      }

    @Override
    public String toString() {
      return ""+from+" -> "+to;
      }
    }

  private void register(Edge edge) {
    if (visitedFrom[edge.to] != -1) return;
    // only register if 'to' has not been registered already
    edges.enqueue(edge);
    visitedFrom[edge.to] = edge.from;
    }

  public void searchFrom(int v) {
    register(new Edge(v, v));
    while (!edges.isEmpty()) {
      Edge step = edges.dequeue();
      for (int w : graph.adjacents(step.to))
          register(new Edge(step.to, w));
      }
    }

  public String showPathTo(int w) {
    String path = ""+w;
    while (visitedFrom[w] != w && visitedFrom[w] != -1) {
      w = visitedFrom[w];
      path = ""+w+" -> "+path;
      }
    return path;
    }

  public void print(PrintStream out) {
    for (int v = 0; v < graph.getV(); v++)
        out.println("" + v + ": " + showPathTo(v));
    }

  public static void main(String[] args) {
    Graph g = new AdjacencyGraph(6);
    g.addUndirectedEdge(0, 5);
    g.addUndirectedEdge(0, 1);
    g.addUndirectedEdge(0, 2);
    g.addUndirectedEdge(2, 3);
    g.addUndirectedEdge(2, 4);
    g.addUndirectedEdge(3, 4);
    g.addUndirectedEdge(5, 3);

    BreadthFirstSearch bfs = new BreadthFirstSearch(g);
    bfs.searchFrom(0);
    bfs.print(System.out);
    }

  }
