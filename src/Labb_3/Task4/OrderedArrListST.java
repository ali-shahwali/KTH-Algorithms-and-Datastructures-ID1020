package Labb_3.Task4;
import java.util.ArrayList;

/*
    ordered array ST that uses binary search, contains arraylists as values
    Used in task 4
*/
public class OrderedArrListST<Key extends Comparable<Key>, Value>
{
    private Key[] keys;
    private ArrayList<Value>[] values;
    private int n = 0;
    private static final int init_size = 2;

    public OrderedArrListST()
    {
        this(init_size);
    }

    // constructor creates a new array list inside each array spot
    public OrderedArrListST(int size)
    {
        keys = (Key[]) new Comparable[size];
        values = new ArrayList[size];
        for(int i = 0; i < values.length; i++)
        {
            values[i] = new ArrayList<>();
        }
    }

    // resize the the array to given capacity
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

    // check if given key returns null, if it does not we know the ST contains the key
    public boolean contains(Key key)
    {
        return get(key) != null;
    }

    // return size
    public int size()
    {
        return n;
    }

    // if size == 0 the ST is empty
    public boolean isEmpty()
    {
        return n == 0;
    }

    // returns the arraylist that is paired with the given key, if ST doesnt contain the key return null
    public ArrayList<Value> get(Key key)
    {
        int i = rank(key);
        if(i < n && keys[i].compareTo(key) == 0)
            return values[i];

        return null;
    }

    // uses binary search to find the correct to the key
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

    // puts in the given key-value pair in the ST by finding the correct spot using binary search
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
