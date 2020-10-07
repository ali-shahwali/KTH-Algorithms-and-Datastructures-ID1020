package Labb_4.HigherGrade;

import java.util.Scanner;

/*
README
    An edge weighted graph is a graph where each edge connecting 2 vertices has a weight, could be distance or reachability e.t.c
    Used in higher grade assignment.
*/
public class EdgeWeightedGraph
{
    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    // Takes a scanner that is reading from a file as input and constructs the edge weighted graph from it
    public EdgeWeightedGraph(Scanner in)
    {
        V = in.nextInt();
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++)
        {
            adj[v] = new Bag<Edge>();
        }

        int E = in.nextInt();
        if (E < 0)
            throw new IllegalArgumentException("Number of edges must be nonnegative");

        for (int i = 0; i < E; i++)
        {
            int v = in.nextInt();
            int w = in.nextInt();
            validateVertex(v);
            validateVertex(w);
            int weight = in.nextInt();
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
        in.close();
    }

    // returns number of vertices
    public int V() {
        return V;
    }

    // returns number of edges
    public int E() {
        return E;
    }

    // throws exception if v is out of bounds
    private void validateVertex(int v)
    {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    // adds a new edge from v to w with
    public void addEdge(Edge e)
    {
        int v = e.either();
        int w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);

        // Not needed for higher grade database
        // adj[w].add(e);
        E++;
    }

    // returns an iterable that can iterate through every adjacent vertice of v
    public Iterable<Edge> adj(int v)
    {
        validateVertex(v);
        return adj[v];
    }

    // returns the number of vertices v is connected to with an edge
    public int degree(int v)
    {
        validateVertex(v);
        return adj[v].size();
    }

}
