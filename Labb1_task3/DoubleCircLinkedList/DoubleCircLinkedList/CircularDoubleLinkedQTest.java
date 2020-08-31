package DoubleCircLinkedList;

import java.sql.SQLOutput;
import java.util.Scanner;
public class CircularDoubleLinkedQTest
{
    public static void main(String[] args)
    {
        CircularDoubleQ<String> queue = new CircularDoubleQ<String>();
        Scanner intScan = new Scanner(System.in);
        Scanner strScan = new Scanner(System.in);

        System.out.println("'1' to enqueue, '2' to dequeue, '3' to iterate through the queue, '4' to exit.\n" +
                "Anything else displays size");

        int i = 0;
        while(i != 4)
        {
            System.out.println("Choose desired operation");
            i = intScan.nextInt();
            switch(i)
            {
                case 1:
                    System.out.println("Enter what you want to enqueue ");
                    String str = strScan.nextLine();
                    queue.enqueue(str);
                    System.out.println(queue.toString());
                    break;

                case 2:
                    System.out.println("Dequeueing");
                    queue.dequeue();
                    System.out.println(queue.toString());
                    break;

                case 3:
                    if(queue.isEmpty())
                    {
                        System.out.println("Can't iterate over empty queue");
                        break;
                    }
                    DoublyLinkedIterator itr = queue.DoublyLinkedIterator();
                    while(true)
                    {
                        System.out.println("Enter '1' to iterate to next, '2' to iterate to previous, else: exit");
                        i = intScan.nextInt() ;
                        if(i == 1)
                            itr.next();
                        else if(i == 2)
                            itr.prev();
                        else
                            break;
                    }
                    break;

                default:
                    System.out.println("size is: " + queue.getSize());
                    break;
            }
        }
    }
}
