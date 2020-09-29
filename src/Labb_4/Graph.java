package Labb_4;

import java.util.NoSuchElementException;

public class Graph
{
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private Bag<Integer>[] adj;


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

    public Graph(StdIn in)
    {
        if (in == null) throw new IllegalArgumentException("argument is null");
        try
        {
            this.V = in.readInt();
            if (V < 0)
                throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
            adj = (Bag<Integer>[]) new Bag[V];
            for (int v = 0; v < V; v++)
            {
                adj[v] = new Bag<Integer>();
            }
            int E = in.readInt();
            if (E < 0)
                throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
            for (int i = 0; i < E; i++)
            {
                int v = in.readInt();
                int w = in.readInt();
                validateVertex(v);
                validateVertex(w);
                addEdge(v, w);
            }
        }
        catch (NoSuchElementException e)
        {
            throw new
                    IllegalArgumentException("invalid input format in Graph constructor", e);
        }
    }

    // returns number of vertices
    public int vertices()
    {
        return V;
    }

    // returns number of edges
    public int edges()
    {
        return E;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v)
    {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    // Adds the undirected edge v-w to this graph.
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

    public int degree(int v)
    {
        validateVertex(v);
        return adj[v].size();
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++)
        {
            sb.append(v + ": ");
            for (int w : adj[v])
            {
                sb.append(w + " ");
            }
            sb.append(NEWLINE);
        }
        return sb.toString();
    }
}
