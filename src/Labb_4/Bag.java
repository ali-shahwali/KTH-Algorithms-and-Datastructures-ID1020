package Labb_4;

import java.util.Iterator;
import java.util.NoSuchElementException;
/*
README
    Simple bag datastructure using linked nodes, retrieves items through iterator.
*/
public class Bag<Item> implements Iterable<Item>
{
    // start of bag
    private Node<Item> first;

    // number of elements in bag
    private int n;

    // each node is linked to a next node and contains some data
    private static class Node<Item>
    {
        private Item data;
        private Node<Item> next;
    }

    // constructor
    public Bag()
    {
        first = null;
        n = 0;
    }

    // if bag is empty return true
    public boolean isEmpty()
    {
        return first == null;
    }

    // returns number of elements in bag
    public int size() {
        return n;
    }

    // adds new element to bag as new first
    public void add(Item data)
    {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.data = data;
        first.next = oldfirst;
        n++;
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
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.data;
            current = current.next;
            return item;
        }
    }
}
