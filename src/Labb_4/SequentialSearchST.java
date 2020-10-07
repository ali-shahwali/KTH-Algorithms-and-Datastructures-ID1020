package Labb_4;
/*
README
    Sequential search symbol table consists of a key-value pairs where each pair is a node that links
    to another key-value pair, searching is done sequentially meaning we iterate through the whole list for our key
    and there is no order.
*/

public class SequentialSearchST<Key, Value> {
    private int n;           // number of key-value pairs
    private Node first;      // the linked list of key-value pairs

    // a helper linked list data type
    private class Node
    {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next)
        {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    // Initializes an empty symbol table.
    public SequentialSearchST() { }

    // return the size of the symbol table
    public int size()
    {
        return n;
    }

    // return true if ST is empty
    public boolean isEmpty()
    {
        return size() == 0;
    }

    // checks if inputted key is in the ST
    public boolean contains(Key key)
    {
        return get(key) != null;
    }

    // takes key as input and returns the associated value
    public Value get(Key key)
    {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }

    // takes key and value as input and puts them in the ST
    public void put(Key key, Value val)
    {
        for (Node x = first; x != null; x = x.next)
        {
            if (key.equals(x.key))
            {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }

    public Iterable<Key> keys()
    {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }
}
