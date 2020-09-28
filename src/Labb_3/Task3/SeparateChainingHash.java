package Labb_3.Task3;
/*
README
    A hashmap is a data structure that uses hashing to use keys as indexing for an array, we use a hash function
    to generate the array position. This is done by using javas hashCode() function, converting it in to a
    positive number and also applying the modulo operand with the hashtable size. This is to
    ensure that the hashcode is within array index bounds.
*/
public class SeparateChainingHash<Key,Value>
{

    private static final int INIT_CAPACITY = 4;
    private int n;                                // number of key-value pairs
    private int m;                                // hash table size
    private SeqSearchST<Key, Value>[] st;  // array of linked-list symbol tables


    // constructor if size isnt given
    public SeparateChainingHash() {
        this(INIT_CAPACITY);
    }

    // constructor
    public SeparateChainingHash(int m)
    {
        this.m = m;
        st = (SeqSearchST<Key, Value>[]) new SeqSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SeqSearchST<Key, Value>();
    }

    // Resizing occurs if the average length of a list is greater than 10 times the hashmap size
    private void resize(int chains) {
        SeparateChainingHash<Key, Value> temp = new SeparateChainingHash<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
    }

    // hash function for keys, returns value between 0 and m-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }


    public int size() {
        return n;
    }


    public boolean isEmpty() {
        return size() == 0;
    }

    // used in task 4 to check the average size of each list
    public int averageBucketSize()
    {
        int averageSize = 0;
        for(int i = 0; i < m; i++)
        {
            averageSize += st[i].size();
        }
        averageSize /= m;
        return averageSize;
    }

    // prints out the size of every list
    public void bucketSize()
    {
        for(int i = 0; i < m; i++)
        {
            System.out.println("Bucket " + i + ": " + st[i].size());
        }
    }
    public boolean contains(Key key)
    {
        return get(key) != null;
    }

    // retrieves the value paired with the key
    public Value get(Key key)
    {
        int i = hash(key);
        return st[i].get(key);
    }

    // puts in a new key-value pair
    public void put(Key key, Value val)
    {
        // double table size if average length of list >= 10
        if (n >= 10*m) resize(2*m);

        int i = hash(key);
        if (!st[i].contains(key))
            n++;
        st[i].put(key, val);
    }


    // return keys in symbol table as an Iterable
    public Iterable<Key> keys()
    {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++)
        {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    }
}
