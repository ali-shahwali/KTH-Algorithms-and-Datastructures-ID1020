package Labb1_task4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircLinkedList<Item> implements Iterable<Item>
{
    // circular list tracks last and size
    private Node<Item> last;
    private int size;
    // node points to next and contains data
    private static class Node<Item>
    {
        private Node<Item> next;
        private Item data;
    }
    // constructor
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

    /*
       if the list is empty we declare last and make last.next point to last to create circularity
       otherwise we make a new node with reference newFirst, this will be the first element in the list
       we make it so it points to the previous first and so last.next points to the new first
    */
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
    /*
       if the list is empty we declare last and create circularity
       otherwise we simply copy last and declare a new last with inputted data as its .data
       the new last will now point to the copy
    */
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
    /*

    */
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

