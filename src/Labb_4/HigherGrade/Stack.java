package Labb_4.HigherGrade;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
README
    Stack datastructure, last in first out
*/
public class Stack<Item> implements Iterable<Item>
{
    private Node<Item> first;     // top of stack
    private int n;                // size of the stack

    // helper linked list class
    private static class Node<Item>
    {
        private Item item;
        private Node<Item> next;
    }

    // constructor
    public Stack()
    {
        first = null;
        n = 0;
    }

    // return true if empty
    public boolean isEmpty() {
        return first == null;
    }

    // returns size
    public int size() {
        return n;
    }

    // push new item onto stack
    public void push(Item item)
    {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    // return item at the top of the stack and remove it from stack
    public Item pop()
    {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
        {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }



    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    // java built in iterator
    private class LinkedIterator implements Iterator<Item>
    {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
