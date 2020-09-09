package Labb_1.task2;

public class Stack
{
    // a stack consists of a first element and optionally we can track the size
    private Node first;
    private int size;

    // a node in the stack consists of a pointer to the next node and contains a form of data
    private class Node
    {
        private Node next;
        private char data;
    }

    // constructor
    public Stack()
    {
        first = null;
        size = 0;
    }

    // if first == null, we know that the stack is empty
    public boolean isEmpty()
    {
        return first == null;
    }

    public int getSize()
    {
        return size;
    }
    // create a copy of the current first, create a new first and its next pointer points to the old first
    public void push(char data)
    {
        Node firstCopy = first;
        first = new Node();
        first.data = data;
        first.next = firstCopy;
        size++;
    }

    // retrieve data from first, then we essentially "remove" the current first by making it equal its next
    public char pop()
    {
        char data = first.data;
        first = first.next;
        size--;
        return data;
    }
}
