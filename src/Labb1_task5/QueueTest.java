package Labb1_task5;
import java.util.Scanner;
public class QueueTest
{
    public static void main(String[] args)
    {
        Queue<String> queue = new Queue<String>();
        Scanner intScan = new Scanner(System.in);
        Scanner strScan = new Scanner(System.in);
        queue.enqueue("hey",1);
        queue.enqueue("hey2",2);
        queue.enqueue("hey3",3);
        queue.enqueue("hey4",4);
        queue.enqueue("hey5",5);
        System.out.println(queue.toString());
        int i = 0;
        while(i != 3)
        {
            System.out.println("'1' to enqueue, '2' to dequeue, '3' to exit");
            i = intScan.nextInt();
            switch(i)
            {
                case 1:
                    System.out.println("enter what u want to enqueue, then enter index");
                    String str = strScan.nextLine();
                    int j = intScan.nextInt();
                    queue.enqueue(str, j);
                    break;

                case 2:
                    System.out.println("enter what index u want to dequeue");
                    j = intScan.nextInt();
                    System.out.println(queue.dequeue(j));
                    break;

                default:
                    break;
            }
        }
    }
}
