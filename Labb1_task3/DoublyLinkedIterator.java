package Labb1_task3;

public interface DoublyLinkedIterator<Item>
{
    public boolean hasNext();
    public boolean hasPrev();
    public Item prev();
    public Item next();
}
