package Labb1_task6;

import Labb1_task5.Queue;

import java.util.NoSuchElementException;

public class OrderedQueue
{
    private Node first;
    private int size;

    private static class Node
    {
        private Node next;
        private int data;
    }

    public OrderedQueue()
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

    public void add(int data)
    {
        if(isEmpty())
        {
            first = new Node();
            first.data = data;
            first.next = null;
        }
        else if(data <= first.data)
        {
            Node oldFirst = first;
            first = new Node();
            first.data = data;
            first.next = oldFirst;
        }
        else
        {
            Node scan = first;
            Node prevScan = first;
            while(scan != null && data > scan.data)
            {
                prevScan = scan;
                scan = scan.next;
            }
            Node newNode = new Node();
            newNode.data = data;
            prevScan.next = newNode;
            newNode.next = scan;
        }
        size++;
        System.out.println(toString());
    }

    public int remove(int k)
    {
        if(k < 1 || k - 1 > size)
            throw new NoSuchElementException("Index out of bounds");
        int data;
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
            Node current = first;
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

        Node current = first;
        if(size == 1)
            sb.append(current.data + ")");
        else
        {
            while (current.next != null)
            {
                sb.append(current.data + ", ");
                current = current.next;
            }
            sb.append(current.data + ")");
        }
        return sb.toString();
    }

}
