package Labb_1.task5;

import java.util.NoSuchElementException;
// generic queue that can insert and remove elements at given index k
public class Queue<Item>
{
    // our queue tracks the first node and its size
    private Node<Item> first;
    private int size;

    // node contains node pointing to next and generic data
    private static class Node<Item>
    {
        private Node<Item> next;
        private Item data;
    }

    // constructor
    public Queue()
    {
        first = null;
        size = 0;
    }

    // checks if first is null, then we know the list is empty
    public boolean isEmpty()
    {
        return first == null;
    }

    /*
       if given index 'k' is out of bounds an exception is thrown
       if empty we initialize first, if given index is 1 we have to reinitialize first
       in any other case we create a node prev and a node current, current iterates to position k + 1
       and prev iterates to position k, thereafter we insert the new element with the given data
       we change prev.next node to point to the newly inserted node and change the newly inserted.next to current
    */
    public void enqueue(Item data, int k)
    {
        if(k < 1 || k - 1> size)
            throw new NoSuchElementException("Index out of bounds");
        if(isEmpty())
        {
            first = new Node<Item>();
            first.data = data;
            first.next = null;
        }
        else if(k == 1)
        {
            Node<Item> oldFirst = first;
            first = new Node<Item>();
            first.data = data;
            first.next = oldFirst;
        }
        else
        {
            Node<Item> current = first;
            Node<Item> prev = new Node<Item>();
            prev.next = first;
            Node<Item> newNode = new Node<Item>();
            newNode.data = data;
            for(int i = 1; i < k; i++)
            {
                prev = current;
                current = current.next;
            }
            newNode.next = current;
            prev.next = newNode;
        }
        size++;
        System.out.println(toString());
    }

    /*
        first we check if the given index is out of bounds or if the queue is empty
        if size is 1 we want to make first null which we will consider a special case
        if the given index is 1 we are replacing first which also warrants a special case
        for all other cases we create a node current that iterates to the node before the given index
        we extract the data from current.next (the node being removed) and we change current.next pointer to point-
        to the one after the removed one which effectively removes that given node
    */
    public Item dequeue(int k)
    {
        if(k < 1 || k - 1 > size)
            throw new NoSuchElementException("Index out of bounds");
        else if(isEmpty())
            throw new NoSuchElementException("Queue underflow");
        Item data;
        if(size == 1)
        {
            data = first.data;
            first = null;
            return data;
        }
        if(k == 1)
        {
            data = first.data;
            first = first.next;
        }
        else
        {
            Node<Item> current = first;
            for(int i = 1; i < k - 1; i++)
                current = current.next;

            data = (current.next).data;
            current.next = (current.next).next;

        }
        size--;
        System.out.println(toString());
        return data;
    }

    // create node current that iterates through the queue and adds the data of each node to a stringbuilder
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("[");
        if(size == 1)
            sb.append(first.data + "]");
        else
        {
            Node<Item> current = first;
            while(current.next != null)
            {
                sb.append(current.data + "], [");
                current = current.next;
            }
          sb.append(current.data + "]");
        }
        return sb.toString();
    }
}
