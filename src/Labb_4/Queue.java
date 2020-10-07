package Labb_4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
README
    simple queue class used to iterate through a sequential search symbol table
*/
public class Queue<Item> implements Iterable<Item>
{
    // beginning of queue
    private Node<Item> first;

    // end of queue
    private Node<Item> last;

    // number of elements on queue
    private int n;

    // a helper linked list data structure
    private static class Node<Item>
    {
        private Item item;
        private Node<Item> next;
    }

    // Initializes an empty queue
    public Queue()
    {
        first = null;
        last  = null;
        n = 0;
    }

    // if queue is empty, return true
    public boolean isEmpty()
    {
        return first == null;
    }

    // returns size
    public int size()
    {
        return n;
    }

    // adds a new element at the end of the queue
    public void enqueue(Item item)
    {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    // dequeues the first element in the queue (FIFO)
    public Item dequeue()
    {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");

        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty())
            last = null;   // to avoid loitering
        return item;
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

    // java built in iterator
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
