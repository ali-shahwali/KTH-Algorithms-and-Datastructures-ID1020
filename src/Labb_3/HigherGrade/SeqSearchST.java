package Labb_3.HigherGrade;
// code taken from Robert Sedgewick's and Kevin Wayne's booksite Algorithms 4th edition

/*
README
    Sequential search symbol table consists of a key-value pairs where each pair is a node that links
    to another key-value pair, searching is done sequentially meaning we iterate through the whole list for our key
    and there is no order.
*/
public class SeqSearchST<Key, Value>
{
    private int n;           // number of key-value pairs
    private Node first;

    // each node has a key, value and a node pointing to the next;
    private class Node
    {
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next)
        {
            this.key  = key;
            this.value  = value;
            this.next = next;
        }
    }

    public int size()
    {
        return n;
    }

    public boolean isEmpty()
    {
        return n == 0;
    }

    // search sequentially through the list for a matching key and replace that value, otherwise add new node
    public void put(Key key, Value value)
    {
        for(Node node = first; node != null; node = node.next)
        {
            if(key.equals(node.key))
            {
                node.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        n++;
    }

    public boolean contains(Key key)
    {
        return get(key) != null;
    }

    // search for key and return paired value, otherwise return null;
    public Value get(Key key)
    {
        for(Node node = first; node != null; node = node.next)
        {
            if(key.equals(node.key))
                return node.value;
        }
        return null;
    }

    public Iterable<Key> keys()
    {
        Queue<Key> queue = new Queue<Key>();
        for(Node node = first; node != null; node = node.next)
            queue.enqueue(node.key);

        return queue;
    }
}
