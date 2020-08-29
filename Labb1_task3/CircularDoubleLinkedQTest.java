package DoubleCircLinkedList;

import java.util.Iterator;

public class CircularDoubleLinkedQTest
{
    public static void main(String[] args)
    {
        CircularDoubleQ<String> queue = new CircularDoubleQ<String>();

        queue.enqueue("First text");
        queue.enqueue("Second text");
        queue.enqueue("Third text");

        DoublyLinkedIterator itr = queue.DoublyLinkedIterator();

        itr.prev();
        itr.prev();
        itr.prev();
        itr.prev();

    }
}
