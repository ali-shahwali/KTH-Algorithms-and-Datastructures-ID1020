package Labb_1.task6;

import java.util.NoSuchElementException;

public class OrderedQueue
{
    // we track first and size
    private Node first;
    private int size;

    // a node points to the next node and contains integer (int) data in this case
    private static class Node
    {
        private Node next;
        private int data;
    }

    // the queue constructor sets first to null and size to 0
    public OrderedQueue()
    {
        first = null;
        size = 0;
    }

    // if first is null we know the queue is empty
    public boolean isEmpty()
    {
        return first == null;
    }

    /*
        if the queue is empty we initialise first with the given data
        if the given data is less than the data in first we must now replace first which gives us a special case
        for all other cases we first create a node scan that iterates through the queue until we either reach a null-
        or a node that contains data that is larger than the inputted data, we also have a node prev that is 1 node-
        behind scan. we then create a node 'newNode' and insert given data in to that node, we make it so prevscan points
        to the new newly inserted node, and the new node points to scan which will have essentially inserted a new node
        at the position where the next node in the queue is larger and the queue remains sorted.
    */
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

    // we use the same remove method as the one implemented in task 5
    public int remove(int k)
    {
        if(k < 1 || k - 1 > size)
            throw new NoSuchElementException("Index out of bounds");
        else if(isEmpty())
            throw new NoSuchElementException("Queue underflow");
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

    /*create a node current that iterates through the queue until it reaches null and adds the data of each element to
     a string builder*/
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("[");
        if(size == 1)
            sb.append(first.data + "]");
        else
        {
            Node current = first;
            while (current.next != null)
            {
                sb.append(current.data + "], [");
                current = current.next;
            }
            sb.append(current.data + "]");
        }
        return sb.toString();
    }
}
