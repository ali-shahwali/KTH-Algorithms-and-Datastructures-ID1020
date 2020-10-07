package Labb_4.HigherGrade;
/*
README
    An edge consists of 2 vertices and a weight between them, used in edge weighted graphs
*/
public class Edge implements Comparable<Edge>
{
    private final int v;
    private final int w;
    private final int weight;

    // constructor
    public Edge(int v, int w, int weight)
    {
        if (v < 0)
            throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (w < 0)
            throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (weight < 0)
            throw new IllegalArgumentException("Weight must be nonnegative");
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    // returns weight
    public double weight()
    {
        return weight;
    }

    // returns v
    public int either()
    {
        return v;
    }

    // returns the opposite of inputted vertex i.e the vertice on the other end of the edge
    public int other(int vertex)
    {
        if (vertex == v)
            return w;
        else if (vertex == w)
            return v;
        else
            throw new IllegalArgumentException("Illegal endpoint");
    }

    @Override
    public int compareTo(Edge that)
    {
        return Double.compare(this.weight, that.weight);
    }

    public String toString()
    {
        return v + "-" + w + " " + weight;
    }
}
