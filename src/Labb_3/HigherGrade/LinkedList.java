package Labb_3.HigherGrade;

public class LinkedList
{
    private Node head;
    private int size = 0;

    private class Node
    {
        private Node next;
        private String data;
    }

    public LinkedList()
    {
        head = null;
    }
    public boolean isEmpty()
    {
        return size == 0;
    }
    public void add(String data)
    {
        if(isEmpty())
        {
            head = new Node();
            head.data = data;
            head.next = null;
        }
        else
        {
            Node copy = head;
            head = new Node();
            head.data = data;
            head.next = copy;
        }
        size++;
    }
    public void clear()
    {
        while(head != null)
        {
            head = head.next;
        }
        size = 0;
    }
    public void addAll(String[] data)
    {
        for(int i = 0; i < data.length;i++)
        {
            add(data[i]);
        }
        size = data.length;
    }
    public String[] getAll()
    {
        String[] list = new String[size];
        int i = 0;
        Node current = head;
        while(current != null)
        {
            list[i] = current.data;
            current = current.next;
            i++;
        }
        return list;
    }
}
