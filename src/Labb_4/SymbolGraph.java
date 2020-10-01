package Labb_4;
public class SymbolGraph
{
    private OrderedArrayST<String, Integer> st;  // string -> index
    private String[] keys;           // index  -> string
    private Graph graph;             // the underlying graph


    public SymbolGraph(String filename, String delimiter)
    {
        st = new OrderedArrayST<String, Integer>();

        // First pass builds the index by reading strings to associate
        // distinct strings with an index
        In in = new In(filename);
        // while (in.hasNextLine()) {
        while (!in.isEmpty())
        {
            String[] a = in.readLine().split(delimiter);
            for (int i = 0; i < a.length; i++)
            {
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
            }
        }

        // inverted index to get string keys in an array
        keys = new String[st.size()];
        for (String name : st.keys())
        {
            keys[st.get(name)] = name;
        }

        // second pass builds the graph by connecting first vertex on each
        // line to all others
        graph = new Graph(st.size());
        in = new In(filename);
        while (in.hasNextLine())
        {
            String[] a = in.readLine().split(delimiter);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++)
            {
                int w = st.get(a[i]);
                graph.addEdge(v, w);
            }
        }
    }


    public boolean contains(String s)
    {
        return st.contains(s);
    }


    @Deprecated
    public int index(String s)
    {
        return st.get(s);
    }


    public int indexOf(String s)
    {
        return st.get(s);
    }


    @Deprecated
    public String name(int v)
    {
        validateVertex(v);
        return keys[v];
    }

    public String nameOf(int v)
    {
        validateVertex(v);
        return keys[v];
    }


    @Deprecated
    public Graph G()
    {
        return graph;
    }


    public Graph graph()
    {
        return graph;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v)
    {
        int V = graph.V();
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }
}
