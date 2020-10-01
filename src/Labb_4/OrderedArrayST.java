package Labb_4;
/*
    Ordered Array Symbol Table using binary search
    We have an array for keys and an array for values, each key is paired with a value
    Keys are of type comparable. We continuously resize the arrays if more space is needed.
    Used in task 2.
*/
public class OrderedArrayST<Key extends Comparable<Key>, Value>
{
    private Key[] keys;
    private Value[] values;

    // number of pairs
    private int n = 0;
    private static final int init_size = 2;

    // constructor if size isnt given
    public OrderedArrayST()
    {
        this(init_size);
    }

    // constructor if size is given
    public OrderedArrayST(int size)
    {
        keys = (Key[]) new Comparable[size];
        values = (Value[]) new Object[size];
    }

    // return true if there are no pairs
    public boolean isEmpty()
    {
        return n == 0;
    }

    /*
        Retrieve rank of the key, if key is already in the array we replace the value
        if number of pairs is equal to the key array size we perform resizing and doubling the size
        we insert the new key and associated value at the correct rank
    */
    public void put(Key key, Value value)
    {
        int index = rank(key);
        if(index < n && keys[index].compareTo(key) == 0)
        {
            values[index] = value;
            return;
        }
        if(n == keys.length)
            resize(2* keys.length);
        for(int j = n; j > index; j--)
        {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[index] = key;
        values[index] = value;
        n++;
    }

    // retrieves value associated with given key
    public Value get(Key key)
    {
        if(isEmpty())
            return null;

        int index = rank(key);
        if(index < n && keys[index].compareTo(key) == 0)
            return values[index];
        else
            return null;
    }

    // uses binary search to find the rank of given key
    public int rank(Key key)
    {
        int lo = 0;
        int hi = n - 1;
        while(lo <= hi)
        {
            int mid = lo + (hi - lo)/2;
            int compare = key.compareTo(keys[mid]);
            if(compare < 0)
                hi = mid - 1;
            else if(compare > 0)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }

    // resizes the key and value arrays to given capacity
    private void resize(int capacity)
    {
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++)
        {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        values = tempv;
        keys = tempk;
    }

    public int size()
    {
        return n;
    }

    public Key max()
    {
        return keys[n-1];
    }

    public Key min()
    {
        return keys[0];
    }
    // checks if given key is already inside the ST
    public boolean contains(Key key)
    {
        return get(key) != null;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null)
            throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null)
            throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new Queue<Key>();
        if (lo.compareTo(hi) > 0)
            return queue;
        for (int i = rank(lo); i < rank(hi); i++)
            queue.enqueue(keys[i]);
        if (contains(hi))
            queue.enqueue(keys[rank(hi)]);
        return queue;
    }
}
