package Labb_4.Task1;
import Labb_4.Graph;
import Labb_4.Stack;
public class DepthFirstPaths
{
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int[] edgeTo;        // edgeTo[v] = last edge on s-v path
    private final int s;         // source vertex

    public DepthFirstPaths(Graph g, int s)
    {
        this.s = s;
        edgeTo = new int[g.vertices()];
        marked = new boolean[g.vertices()];
        validateVertex(s);
        dfs(g, s);
    }

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

    public boolean hasPathTo(int v)
    {
        validateVertex(v);
        return marked[v];
    }

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
