package Labb_4.Task3;
import Labb_4.Digraph;
/*
README
    Depth-first search on directed graph
*/
public class DigraphDFP
{
    private boolean[] marked;  // marked[v] = true if v is reachable from source(s)

    // constructor
    public DigraphDFP(Digraph G, int s)
    {
        marked = new boolean[G.V()];
        validateVertex(s);
        dfs(G, s);
    }

    // goes through the directed graph and marks every vertice that is reachable
    private void dfs(Digraph G, int v)
    {
        marked[v] = true;
        for (int w : G.adj(v))
        {
            if (!marked[w])
                dfs(G, w);
        }
    }

    public boolean marked(int v)
    {
        validateVertex(v);
        return marked[v];
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v)
    {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

}
