package Labb_4.Task2;
import Labb_4.Graph;
import Labb_4.Stack;
import Labb_4.Queue;
/*
README
    Breadth-first search uses a distance-to array and a queue to find the shortest amounts of edges one needs to traverse
    in order to get to a vertice.
*/
public class BreadthFirstPaths
{
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  // marked[v] = is there an s-v path
    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
    private int[] distTo;      // distTo[v] = number of edges shortest s-v path


    public BreadthFirstPaths(Graph G, int s)
    {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        validateVertex(s);
        bfs(G, s);
    }


    /*
        Sets distance to every vertice as infinity first, and starts at the source and works its way through the graph
        until the shortest path to every vertice from the source has been found.
    */
    private void bfs(Graph G, int s)
    {
        Queue<Integer> q = new Queue<Integer>();
        for (int v = 0; v < G.V(); v++)
            distTo[v] = INFINITY;

        distTo[s] = 0;
        marked[s] = true;
        q.enqueue(s);
        while (!q.isEmpty())
        {
            int v = q.dequeue();
            for (int w : G.adj(v))
            {
                if (!marked[w])
                {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    // returns true if there is a connected path from source to v
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
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }

    // throw an IllegalArgumentException if index is out of bounds
    private void validateVertex(int v)
    {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
}
