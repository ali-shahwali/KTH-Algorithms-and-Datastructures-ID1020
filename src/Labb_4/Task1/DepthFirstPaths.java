package Labb_4.Task1;
import Labb_4.Graph;
import Labb_4.Stack;
/*
README
    Depth first search uses recursion to mark every accessible vertice and also store which vertice they have an edge to
*/
public class DepthFirstPaths
{
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int[] edgeTo;        // edgeTo[v] = last edge on s-v path
    private final int s;         // source vertex

    // constructor
    public DepthFirstPaths(Graph g, int s)
    {
        this.s = s;
        edgeTo = new int[g.V()];
        marked = new boolean[g.V()];
        validateVertex(s);
        dfs(g, s);
    }

    // recursively moves to an adjacent unmarked vertice
    private void dfs(Graph G, int v)
    {
        marked[v] = true;
        for (int w : G.adj(v))
        {
            if (!marked[w])
            {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    // if input v is a marked vertice then there is a path from the source to that vertice
    public boolean hasPathTo(int v)
    {
        validateVertex(v);
        return marked[v];
    }

    // uses stack and follows the edgeTo array until we reach the source, because the stack is LIFO we get the right order
    public Iterable<Integer> pathTo(int v)
    {
        validateVertex(v);
        if (!hasPathTo(v))
            return null;

        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    private void validateVertex(int v)
    {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
}
