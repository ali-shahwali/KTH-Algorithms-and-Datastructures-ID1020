package Labb1_task3;

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
        return last == null;
    }

    public int getSize()
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
        size++;
    }

    public Item dequeue()
    {
        if(isEmpty())
            throw new NoSuchElementException("Queue underflow");
        Item data = first.data;

        if(size>2)
        {
            first = first.next;
            first.prev = last;
            last.next = first;
        }
        else if (size == 2)
        {
            last.next = last;
            last.prev = last;
            first = last;
        }
        else
        {
            last = null;
            first = null;
        }
        size--;
        return data;
    }

    // använder mig av stringbuilder och itererar igenom kön tills jag har loopat
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("(");
        if(isEmpty())
            return "The queue is empty";
        if(size == 1)
            sb.append(last.data + ")");
        else
        {
            Node<Item> current = last;
            while(current != first)
            {
                sb.append(current.data + ", ");
                current = current.prev;
            }
            sb.append(current.data + ")");
        }
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
            if(isEmpty())
                throw new NoSuchElementException("Can't iterate over empty queue");

            current = last;
        }

        // kommer aldrig användas då det är en circular queue
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
            current = current.next;
            Item data = current.data;
            System.out.println(data);
            return data;
        }

        public Item prev()
        {
            current = current.prev;
            Item data = current.data;
            System.out.println(data);
            return data;
        }
    }


}
