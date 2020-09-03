package Labb1_task2;

public class Stack
{
    private Node first;
    private int size;

    private class Node
    {
        private Node next;
        private char data;
    }

    public Stack()
    {
        first = null;
        size = 0;
    }

    public boolean isEmpty()
    {
        return first == null;
    }
    public int size()
    {
        return size;
    }

    public void push(char data)
    {
        Node firstCopy = first;
        first = new Node();
        first.data = data;
        first.next = firstCopy;
        size++;
    }

    public char pop()
    {
        char data = first.data;
        first = first.next;
        size--;
        return data;
    }

    public char getFirst()
    {
        return first.data;
    }
}
