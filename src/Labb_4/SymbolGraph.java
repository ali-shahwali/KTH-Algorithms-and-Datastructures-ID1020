package Labb_4;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

/*
README
    A symbol graph is a graph that has corresponding string names as vertices instead of integers.
    Used in task 1 and 2 to represent the states of america in numerical form
*/
public class SymbolGraph
{
    private SequentialSearchST<String, Integer> st;  // string -> index
    private String[] keys;           // index  -> string
    private Graph graph;             // the underlying graph

    // takes a file and a delimiter such as space or , and creates a corresponding graph with numerical values as vertices
    public SymbolGraph(File file, String delimiter) throws FileNotFoundException
    {
        st = new SequentialSearchST<String, Integer>();

        Scanner in = new Scanner(file);

        while (in.hasNextLine())
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

        // second pass builds the graph by connecting first vertex on each line to all others
        graph = new Graph(st.size());
        in = new Scanner(file);
        while (in.hasNextLine())
        {
            String[] a = in.nextLine().split(delimiter);
            int v = st.get(a[0]);
            int w = st.get(a[1]);
            graph.addEdge(v, w);
        }
        in.close();
    }

    // returns the representing vertice of a symbol
    public int indexOf(String s)
    {
        return st.get(s);
    }

    // returns the representing symbol of a vertice
    public String nameOf(int v)
    {
        validateVertex(v);
        return keys[v];
    }

    // returns the graph using numerical values representing the symbol graph
    public Graph graph()
    {
        return graph;
    }

    private void validateVertex(int v)
    {
        int V = graph.V();
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }
}
