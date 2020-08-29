package DoubleCircLinkedList;

public interface DoublyLinkedIterator<Item>
{
    public boolean hasNext();
    public boolean hasPrev();
    public Item prev();
    public Item next();
}
