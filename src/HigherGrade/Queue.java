package Labb_3.HigherGrade;

import java.util.Iterator;

public class Queue<Item>
{
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements on queue

    // helper linked list class
    private static class Node<Item>
    {
        private Item item;
        private Node<Item> next;
    }


    public Queue()
    {
        first = null;
        last  = null;
        n = 0;
    }


    public boolean isEmpty()
    {
        return first == null;
    }

    public int size()
    {
        return n;
    }


    public void enqueue(Item item)
    {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }


    public Item dequeue()
    {
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }
}
