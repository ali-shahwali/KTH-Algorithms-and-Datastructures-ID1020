package Labb1_task6;
import java.util.Random;
import java.util.Scanner;
public class OrderedQueueTest
{
    // allows the user to enqueue a random integer and remove a element at given index
    // through a while loop with switch combo
    public static void main(String[] args)
    {
        OrderedQueue queue = new OrderedQueue();
        Scanner intScan = new Scanner(System.in);
        Random rand = new Random();

        int i = 0;
        while(i != 3)
        {
            System.out.println("'1' to add random integer to queue, '2' to remove, '3' to exit");
            i = intScan.nextInt();
            switch (i)
            {
                case 1:
                    int randomNum = rand.nextInt(100);
                    System.out.println("added: " + randomNum);
                    queue.add(randomNum);
                    break;

                case 2:
                    System.out.println("enter element index");
                    int j = intScan.nextInt();
                    System.out.println(queue.remove(j));
                    break;

                default:
                    break;
            }
        }
    }
}
