package Labb_3.Task3;

import java.util.Iterator;
/*

*/
public class Queue<Item> implements Iterable<Item>
{
    private Node<Item> first;
    private Node<Item> last;
    private int n;

    private static class Node<Item>
    {
        private Item item;
        private Node<Item> next;
    }


    public Queue()
    {
        first = null;
        last = null;
        n = 0;
    }


    public boolean isEmpty()
    {
        return first == null;
    }

    public void enqueue(Item item)
    {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        n++;
    }



    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
        {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }


    public Iterator<Item> iterator()
    {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item>
    {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first)
        {
            current = first;
        }

        public boolean hasNext()
        {
            return current != null;
        }

        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}