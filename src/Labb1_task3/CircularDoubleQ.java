package Labb1_task3;

import java.util.NoSuchElementException;
// circular double linked generic iterable queue
public class CircularDoubleQ<Item> implements DoublyLinkedIterable<Item>
{
    // a queue consists of a first and a last node, we also track its size
    private Node<Item> first;
    private Node<Item> last;
    private int size;

    /*
      a node in the double linked queue has a pointer to previous and next
      also contains a generic form of data
    */
    private static class Node<Item>
    {
        private Node<Item> prev;
        private Node<Item> next;
        private Item data;
    }

    // constructor
    public CircularDoubleQ()
    {
        first = null;
        last = null;
        size = 0;
    }

    // we know the queue is empty if last == null
    public boolean isEmpty()
    {
        return last == null;
    }

    /*
       if the queue is empty then the added element will be first and last
       when we add a second element we want to separate first and last and also uphold the circular structure
       for every other scenario we just add a element at the back and update last and maintain circular structure
    */
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

    /*
       first we check if the queue is empty, in that case we throw a exception
       if the queue has more than 2 element we perform a simple dequeue and update first
       if the queue consists of 2 elements we make it so the element that is left is first and last
       if the dequeue makes the list empty we make it so first and last are now null
    */
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

    // simple stringbuilder that iterates through the queue and prints data of each element
    public String toString()
    {
        StringBuilder sb = new StringBuilder("[");
        if(isEmpty())
            return "The queue is empty";
        if(size == 1)
            sb.append(last.data + "]");
        else
        {
            Node<Item> current = last;
            while(current != first)
            {
                sb.append(current.data + "], [");
                current = current.prev;
            }
            sb.append(current.data + "]");
        }
        return sb.toString();
    }

    // because the queue is double linked we cant use java's iterator
    public DoublyLinkedIterator<Item> DoublyLinkedIterator()
    {
        return new DoubleLinkedIterator(last);
    }

    private class DoubleLinkedIterator implements DoublyLinkedIterator<Item>
    {
        // the iterator consists of a node that iterates through the queue
        private Node<Item> current;

        // constructor, starts the iteration at the last element in the queue
        public DoubleLinkedIterator(Node<Item> last)
        {
            if(isEmpty())
                throw new NoSuchElementException("Can't iterate over empty queue");

            current = last;
        }

        // technically these functions are of no use since the queue is circular
        // but we implement them anyways as they are in the interface
        public boolean hasNext()
        {
            return current.next != null;
        }
        public boolean hasPrev()
        {
            return current.prev != null;
        }

        // we iterate current to the next element and return data in that element
        public Item next()
        {
            current = current.next;
            Item data = current.data;
            System.out.println(data);
            return data;
        }
        // we iterate current to the previous element and return data in that element
        public Item prev()
        {
            current = current.prev;
            Item data = current.data;
            System.out.println(data);
            return data;
        }
    }
}
