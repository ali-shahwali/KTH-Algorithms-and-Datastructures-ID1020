package Labb_3.Task4;
import java.util.ArrayList;

public class ListBST<Key extends Comparable<Key>, Value>
{
    private Key[] keys;
    private ArrayList<Value>[] values;
    private int n = 0;
    private static final int init_size = 2;

    public ListBST(int size)
    {
        keys = (Key[]) new Comparable[size];
        values = new ArrayList[size];
        for(int i = 0; i < values.length; i++)
        {
            values[i] = new ArrayList<>();
        }
    }

    private void resize(int capacity)
    {
        Key[]   tempk = (Key[]) new Comparable[capacity];
        ArrayList<Value>[] tempv = (ArrayList<Value>[]) new Object[capacity];
        for (int i = 0; i < n; i++)
        {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        values = tempv;
        keys = tempk;
    }

    public boolean contains(Key key)
    {
        return get(key) != null;
    }

    public int size()
    {
        return n;
    }

    public boolean isEmpty()
    {
        return n == 0;
    }

    public ArrayList<Value> get(Key key)
    {
        int i = rank(key);
        if(i < n && keys[i].compareTo(key) == 0)
            return values[i];

        return null;
    }

    public int rank(Key key)
    {
        int lo = 0, hi = n-1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0)
                hi = mid - 1;
            else if(cmp > 0)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }

    public void put(Key key, Value value)
    {
        int i = rank(key);

        // key is already in table
        if (i < n && keys[i].compareTo(key) == 0)
        {
            values[i].add(value);
            return;
        }

        // insert new key-value pair
        if (n == keys.length)
            resize(2*keys.length);

        for (int j = n; j > i; j--)
        {
            keys[j] = keys[j-1];
            values[j].addAll(values[j-1]);
            values[j-1].clear();
        }
        keys[i] = key;
        values[i].add(value);
        n++;
    }
}
