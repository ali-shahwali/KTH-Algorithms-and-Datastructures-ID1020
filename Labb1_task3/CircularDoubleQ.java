package DoubleCircLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularDoubleQ<Item> implements DoublyLinkedIterable<Item>
{
    private Node<Item> first;
    private Node<Item> last;
    private int size;



    private static class Node<Item>
    {
        private Node<Item> prev;
        private Node<Item> next;
        private Item data;
    }

    public CircularDoubleQ()
    {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public int Size()
    {
        return size;
    }

    public void enqueue(Item data)
    {
        if(isEmpty())
        {
            last = new Node<Item>();
            last.data = data;
            last.prev = last;
            last.next = last;
            first = last;
        }
        else if(size == 1)
        {
            last = new Node<Item>();
            last.data = data;
            last.prev = first;
            last.next = first;
            first.prev = last;
            first.next = last;
        }
        else
        {
            Node<Item> oldLast = last;
            last = new Node<Item>();
            last.data = data;
            oldLast.next = last;
            last.prev = oldLast;
            first.prev = last;
            last.next = first;
        }
        
        System.out.println(toString());
        size++;
    }

    public Item dequeue()
    {
        if(isEmpty()) throw new NoSuchElementException("Queue underflow");

        Item data = first.data;
        first = first.next;
        first.prev = last;

        System.out.println(toString());
        size--;
        return data;
    }
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("(");
        Node<Item> current = last;
        while(current != first)
        {
            sb.append(current.data+", ");
            current = current.prev;
        }
        sb.append(first.data + ")");
        return sb.toString();
    }

    @Override
    public DoublyLinkedIterator<Item> DoublyLinkedIterator()
    {
        return new DoubleLinkedIterator(last);
    }

    private class DoubleLinkedIterator implements DoublyLinkedIterator<Item>
    {
        private Node<Item> current;

        public DoubleLinkedIterator(Node<Item> last)
        {
            current = last;
        }

        public boolean hasNext()
        {
            return current.next != null;
        }
        public boolean hasPrev()
        {
            return current.prev != null;
        }

        public Item next()
        {
            if(!hasNext())
                throw new NoSuchElementException();

            Item data = current.data;
            current = current.next;
            System.out.println(data);
            return data;
        }

        public Item prev()
        {
            if(!hasNext())
                throw new NoSuchElementException();

            Item data = current.data;
            current = current.prev;
            System.out.println(data);
            return data;
        }
    }


}
