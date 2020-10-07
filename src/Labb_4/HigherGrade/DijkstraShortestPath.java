package Labb_4.HigherGrade;

/*
README
    Dijkstras shortest path algorithm finds the shortest path from the source to all vertices in a graph.
    Used in higher grade
*/
public class DijkstraShortestPath
{
    private static final double INFINITY = Integer.MAX_VALUE;

    private double[] distTo;          // distTo[v] = distance of shortest s->v path
    private Edge[] edgeTo;            // edgeTo[v] = last edge on shortest s->v path
    private IndexMinPQ<Double> pq;    // priority queue of vertices

    // uses dijkstras shortest path algorithm to find the shortest path from s to all reachable vertices in the graph
    public DijkstraShortestPath(EdgeWeightedGraph G, int s)
    {
        distTo = new double[G.V()];
        edgeTo = new Edge[G.V()];

        validateVertex(s);

        for (int v = 0; v < G.V(); v++)
            distTo[v] = INFINITY;
        distTo[s] = 0.0;

        // relax vertices in order of distance from s
        pq = new IndexMinPQ<Double>(G.V());
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty())
        {
            int v = pq.delMin();
            for (Edge e : G.adj(v))
                relax(e, v);
        }
    }

    // relax edge e and update priority queue if changed, insert new vertice if it is not already in priority queue
    private void relax(Edge e, int v)
    {
        int w = e.other(v);
        if (distTo[w] > distTo[v] + e.weight())
        {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;

            if (pq.contains(w))
                pq.decreaseKey(w, distTo[w]);
            else
                pq.insert(w, distTo[w]);
        }
    }

    // return true if there is a distance from v to s that is less than infinity, meaning edge has been relaxed
    public boolean hasPathTo(int v)
    {
        validateVertex(v);
        return distTo[v] < INFINITY;
    }

    // uses a stack to follow the edgeTo array from v until we reach source which has a null edgeTo. using a stack gives us the right order (LIFO)
    public Iterable<Edge> pathTo(int v)
    {
        validateVertex(v);
        if (!hasPathTo(v))
            return null;
        Stack<Edge> path = new Stack<Edge>();
        int x = v;
        for (Edge e = edgeTo[v]; e != null; e = edgeTo[x])
        {
            path.push(e);
            x = e.other(x);
        }
        return path;
    }

    // throw an IllegalArgumentException if v is less than zero or larger than the total amount of vertices
    private void validateVertex(int v)
    {
        int V = distTo.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

}
