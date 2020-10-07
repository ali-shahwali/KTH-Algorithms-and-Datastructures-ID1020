package Labb_4;
/*
README
    Directed graph datastructure, each vertice has a bag of adjacent vertices that it can traverse to
    Traversal between 2 vertices is only possible in one direction.
*/

public class Digraph
{
    // number of vertices
    private final int V;

    // number of edges
    private int E;

    // bag containing adjacent vertices
    private Bag<Integer>[] adj;    // adj[v] = adjacency list for vertex v

    // creates empty digraph with V vertices
    public Digraph(int V)
    {
        if (V < 0)
            throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");

        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
        {
            adj[v] = new Bag<Integer>();
        }
    }


    // returns number of vertices in digraph
    public int V()
    {
        return V;
    }

    // returns number of edges in digraph
    public int E()
    {
        return E;
    }


    // checks if inputted vertice is within bounds
    private void validateVertex(int v)
    {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    // adds a directed edge that goes from v to w
    public void addEdge(int v, int w)
    {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        E++;
    }

    // returns the adjacent vertices as an iterable
    public Iterable<Integer> adj(int v)
    {
        validateVertex(v);
        return adj[v];
    }
}
