package Labb_3.HigherGrade;

public class SeparateChainingHash<Key, Value>
{
    private static final int INIT_CAPACITY = 4;

    private int n;                                // number of key-value pairs
    private int m;                                // hash table size
    private SeqSearchST<Key, Value>[] st;

    public SeparateChainingHash()
    {
        this(INIT_CAPACITY);
    }

    public SeparateChainingHash(int m)
    {
        this.m = m;
        st = (SeqSearchST<Key, Value>[]) new SeqSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SeqSearchST<Key, Value>();
    }

    private int hash(Key key)
    {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    private void resize(int chains)
    {
        SeparateChainingHash<Key, Value> temp = new SeparateChainingHash<Key, Value>(chains);
        for (int i = 0; i < m; i++)
        {
            for (Key key : st[i].keys())
            {
                temp.put(key, st[i].get(key));
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
    }

    public Value get(Key key)
    {
        int i = hash(key);
        return st[i].get(key);
    }

    public void put(Key key, Value val)
    {
        // double table size if average length of list >= 10
        if(n >= 10*m)
            resize(2*m);

        int i = hash(key);
        if (!st[i].contains(key))
            n++;
        st[i].put(key, val);
    }

    public boolean contains(Key key)
    {
        return get(key) != null;
    }
}
