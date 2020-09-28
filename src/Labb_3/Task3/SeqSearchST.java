package Labb_3.Task3;
/*
README
    Sequential search symbol table consists of a key-value pairs where each pair is a node that links
    to another key-value pair, searching is done sequentially meaning we iterate through the whole list for our key
    and there is no order.
*/
public class SeqSearchST<Key, Value>
{
    private int n;           // number of key-value pairs
    private Node first;      // the linked list of key-value pairs

    // each node has a key, value and a node pointing to the next;
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

    public SeqSearchST()
    {
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key)
    {
        return get(key) != null;
    }

    // search for key and return paired value, otherwise return null;
    public Value get(Key key)
    {
        for (Node x = first; x != null; x = x.next)
        {
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }

    // search sequentially through the list for a matching key and replace that value, otherwise add new node
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
