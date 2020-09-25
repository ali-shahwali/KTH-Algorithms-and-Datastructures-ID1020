package Labb_3.HigherGrade;

public class SeqSearchST<Key, Value>
{
    private int n;           // number of key-value pairs
    private Node first;

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
        for(Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);

        return (Iterable<Key>) queue;
    }


}
