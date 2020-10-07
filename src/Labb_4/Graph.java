package Labb_4;
/*
README
    Undirected graph datastructure, each vertice v has an edge to a vertice w which we can traverse in both directions
    Uses a bag for adjacent vertices.
*/
public class Graph
{
    // number of vectors
    private final int V;

    // number of edges
    private int E;

    // bag of adjacent vertices
    private Bag<Integer>[] adj;

    // constructs a graph with V vertices
    public Graph(int V)
    {
        if (V < 0)
            throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
        {
            adj[v] = new Bag<Integer>();
        }
    }

    // return number of vertices
    public int V()
    {
        return V;
    }

    // return number of edges
    public int E()
    {
        return E;
    }

    // throw an IllegalArgumentException if v is out of bounds
    private void validateVertex(int v)
    {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    // creates an undirected edge between v and w
    public void addEdge(int v, int w)
    {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v)
    {
        validateVertex(v);
        return adj[v];
    }
}
