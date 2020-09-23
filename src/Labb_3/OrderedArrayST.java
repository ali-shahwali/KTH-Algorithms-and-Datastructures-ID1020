package Labb_3;

public class OrderedArrayST<Key extends Comparable<Key>, Value>
{
    private Key[] keys;
    private Value[] values;
    private int n;

    public OrderedArrayST(int size)
    {
        keys = (Key[]) new Comparable[size];
        values = (Value[]) new Object[size];
    }

    public boolean isEmpty()
    {
        return n == 0;
    }

    public void put(Key key, Value value)
    {
        if(n == keys.length)
            throw new OutOfMemoryError("Exceeded capacity");

        if(value == null)
        {
            delete(key);
            return;
        }

        int index = rank(key);
        if(index < n && keys[index].compareTo(key) == 0)
        {
            values[index] = value;
            return;
        }

        for (int j = n; j > index; j--)  {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[index] = key;
        values[index] = value;
        n++;
    }

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

    public void delete(Key key)
    {
        put(key,null);
    }

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
            if(compare > 0)
                lo = mid + 1;
            else return mid;
        }
        return lo;
    }

}
