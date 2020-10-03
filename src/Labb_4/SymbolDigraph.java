package Labb_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolDigraph
{
    private SequentialSearchST<String, Integer> st;  // string -> index
    private String[] keys;           // index  -> string
    private Digraph digraph;             // the underlying graph


    public SymbolDigraph(File file, String delimiter) throws FileNotFoundException
    {
        st = new SequentialSearchST<String, Integer>();

        Scanner in = new Scanner(file);
        while(in.hasNextLine())
        {
            String[] a = in.nextLine().split(delimiter);
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
        digraph = new Digraph(st.size());
        in = new Scanner(file);
        while (in.hasNextLine())
        {
            String[] a = in.nextLine().split(delimiter);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++)
            {
                int w = st.get(a[i]);
                digraph.addEdge(v, w);
            }
        }
        in.close();
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
    public Digraph G()
    {
        return digraph;
    }


    public Digraph graph()
    {
        return digraph;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v)
    {
        int V = digraph.V();
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }
}
