package Labb_3;

import java.util.Iterator;

public class OrderedArrayST<Key extends Comparable<Key>, Value> implements Iterable<Key>
{
    private Key[] keys;
    private Value[] values;
    private int n = 0;
    private static final int init_size = 2;
    public OrderedArrayST()
    {
        this(init_size);
    }
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
        if(n == keys.length)
            resize(2* keys.length);
        for (int j = n; j > index; j--)
        {
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
            else if(compare > 0)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }

    private void resize(int capacity)
    {
        assert capacity >= n;
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
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

    public Key max()
    {
        return keys[n-1];
    }

    public Key min()
    {
        return keys[0];
    }

    public Iterator<Key> iterator()
    {
        return new keyIterator(keys[0]);
    }

    private class keyIterator implements Iterator<Key>
    {
        Key currentKey;
        int startPos;
        private keyIterator(Key lo)
        {
            startPos = 0;
            currentKey = lo;
        }


        public boolean hasNext()
        {
            return keys[startPos + 1] != null;
        }


        public Key next()
        {
            if(hasNext())
            {
                Key key = currentKey;
                currentKey = keys[++startPos];
                return key;
            }
            else
                return currentKey;
        }
    }
}
