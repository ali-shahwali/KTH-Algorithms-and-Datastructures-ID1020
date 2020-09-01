package Labb1_task4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircLinkedList<Item> implements Iterable<Item>
{
    private Node<Item> last;
    private int size;

    private static class Node<Item>
    {
        private Node<Item> next;
        private Item data;
    }

    public CircLinkedList()
    {
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
        }
        else
        {
            Node<Item> newFirst = new Node<Item>();
            newFirst.data = data;
            Node<Item> first = last.next;
            newFirst.next = first;
            last.next = newFirst;
        }
        size++;
    }

    public void addBack(Item data)
    {
        if (isEmpty())
        {
            last = new Node<Item>();
            last.data = data;
            last.next = last;
        }
        else
        {
            Node<Item> oldLast = last;
            last = new Node<Item>();
            last.data = data;
            last.next = oldLast.next;
            oldLast.next = last;
        }
        size++;
    }

    public Item removeFront()
    {
        if(isEmpty())
            throw new NoSuchElementException("Queue underflow");
        Item data = last.next.data;
        if(size == 1)
            last = null;
        else
            last.next = last.next.next;

        size--;
        return data;
    }

    public Item removeBack()
    {
        if(isEmpty())
            throw new NoSuchElementException("Queue underflow");

        Item data = last.data;
        if(size == 1)
            last = null;
        else
        {
            Node<Item> first = last.next;
            Node<Item> current = last.next;
            while(current.next != last)
                current = current.next;

            last = current;
            last.next = first;
        }
        size--;
        return data;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("(");
        if(isEmpty())
            return "Queue is now empty";
        Node<Item> current = last.next;
        while(current != last)
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
            if(!hasNext())
                throw new NoSuchElementException();

            current = current.next;
            return current.data;
        }
    }
}

