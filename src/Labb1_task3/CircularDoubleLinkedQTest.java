package Labb1_task3;

import java.util.Scanner;
public class CircularDoubleLinkedQTest
{
    // allows the user to enqueue, dequeue and iterate through the queue using a while loop and switch combo
    public static void main(String[] args)
    {
        CircularDoubleQ<String> queue = new CircularDoubleQ<String>();
        Scanner intScan = new Scanner(System.in);
        Scanner strScan = new Scanner(System.in);

        int i = 0;
        while(i != 4)
        {
            System.out.println("'1' to enqueue, '2' to dequeue, '3' to iterate through the queue, '4' to exit.");
            System.out.print("Enter now: ");
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
                    DoublyLinkedIterator<String> itr = queue.DoublyLinkedIterator();
                    int j = 1;
                    while(j != (1 | 2))
                    {
                        System.out.println("Enter '1' to iterate to next, '2' to iterate to previous, else: exit");
                        j = intScan.nextInt() ;
                        if(j == 1)
                            itr.next();
                        else if(j == 2)
                            itr.prev();
                    }
                    break;

                default:
                    break;
            }
        }
    }
}
