package Labb1_task5;

public class QueueTest
{
    public static void main(String[] args)
    {
        Queue<String> queue = new Queue<String>();

        queue.enqueue("Hello",1);
        queue.enqueue("hello again", 2);
        queue.enqueue("yep", 3);
        queue.enqueue("yep2", 3);
        queue.enqueue("2", 1);
        System.out.println(queue.toString());
    }
}
