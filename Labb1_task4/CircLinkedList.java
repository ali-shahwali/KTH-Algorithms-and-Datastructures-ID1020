package Labb1_task4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircLinkedList<Item> implements Iterable<Item>
{
    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private static class Node<Item>
    {
        private Node<Item> next;
        private Item data;
    }

    public CircLinkedList()
    {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty()
    {
        return last == null;
    }

    public int getSize()
    {
        return size;
    }

    public void addFront(Item data)
    {
        if(isEmpty())
        {
            last = new Node<Item>();
            last.data = data;
            last.next = last;
            first = last;
        }
        else if(size == 1)
        {

        }
        else
        {
            Node<Item> oldFirst = first;
            first = new Node<Item>();
            first.data = data;
            last.next = first;
        }
        size++;
    }

    public void addBack(Item data)
    {
        if(isEmpty())
        {
            last = new Node<Item>();
            last.data = data;
            last.next = last;
            first = last;
        }
        else if(size == 1)
        {

        }
        else
        {
            Node<Item> oldLast = last;
            last = new Node<Item>();
            last.data = data;
            last.next = first;
            oldLast.next = last;
        }
        size++;
    }

    public Item removeFront()
    {
        if(isEmpty())
            throw new NoSuchElementException("Queue is already empty");

        Item data = first.data;
        if(size == 1)
        {
            last = null;
            first = null;
        }
        else
        {
            first = first.next;
            last.next = first;
        }
        size--;
        return data;
    }

    public Item removeBack()
    {
        if(isEmpty())
            throw new NoSuchElementException("Queue is empty");

        Item data = last.data;
        if(size == 1)
        {
            last = null;
            first = null;
        }
        else
        {
            Node<Item> newLast = first;
            while(newLast.next != last)
                newLast = newLast.next;

            last = newLast;
            last.next = first;

        }
        size--;
        return data;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("(");

        Node<Item> current = last;
        if(size == 1)
        {
            sb.append(current.data + ")");
            return sb.toString();
        }
        while(current.next !=  last)
        {
            sb.append(current.data + ", ");
            current = current.next;
        }
        sb.append(current.data + ")");
        return sb.toString();
    }

    public Iterator<Item> iterator()
    {
        return new CircLinkedIterator(last);
    }

    private class CircLinkedIterator implements Iterator<Item>
    {
        private Node<Item> current;

        public CircLinkedIterator(Node<Item> last)
        {
            if(isEmpty())
                throw new NoSuchElementException("Can't iterate over empty queue");

            current = last;
        }
        // kommer aldrig användas eftersom det är en circular list
        public boolean hasNext()
        {
            return current.next != null;
        }

        public Item next()
        {
            current = current.next;
            return current.data;
        }
    }
}

