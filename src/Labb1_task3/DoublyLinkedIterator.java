package Labb1_task3;
/*
 our own iterator interface must also have the hasPrev() and prev() methods implemented
 due to the double link requirement from the assignment
*/
public interface DoublyLinkedIterator<Item>
{
    public boolean hasNext();
    public boolean hasPrev();
    public Item prev();
    public Item next();
}
