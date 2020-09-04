package Labb1_task3;
// our own iterator interface must also have the hasPrev() and prev() methods implemented
public interface DoublyLinkedIterator<Item>
{
    public boolean hasNext();
    public boolean hasPrev();
    public Item prev();
    public Item next();
}
