package Labb1_task5;

import java.util.NoSuchElementException;

public class Queue<Item>
{
    private Node<Item> first;
    private int size;

    private static class Node<Item>
    {
        private Node<Item> next;
        private Item data;
    }

    public Queue()
    {
        first = null;
        size = 0;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public int getSize()
    {
        return size;
    }

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


    public Item dequeue(int k)
    {
        if(k < 1 || k - 1 > size)
            throw new NoSuchElementException("Index out of bounds");
        Item data;
        if(size == 1)
        {
            data = first.data;
            first = null;
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

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("(");
        Node<Item> current = first;
        if(size == 1)
        {
            sb.append(current.data + ")");
        }
        else
        {
            while(current.next != null)
            {
                sb.append(current.data + ", ");
                current = current.next;
            }
          sb.append(current.data + ")");
        }

        return sb.toString();
    }
}
