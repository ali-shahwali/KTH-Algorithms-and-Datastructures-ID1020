package Labb_2.task_6;
import Labb_2.task_5.MergeSort;
import java.util.*;
public class MergeSortTest
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        Scanner intScan = new Scanner(System.in);
        System.out.print("Enter desired array length: ");
        int n = intScan.nextInt();
        System.out.println();
        System.out.print("Enter desired merge cutoff: ");
        int cutoff = intScan.nextInt();
        System.out.println();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            int randInt = rand.nextInt(n);
            arr[i] = randInt;
        }
        int[] arrCopy = arr;

        System.out.println("Sorting with cutoff "+ cutoff);
        long startTime = System.currentTimeMillis();
        MergeSortCutoff.sort(arr,cutoff);
        long finishTime = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000 + " seconds");


        System.out.println("Sorting without cutoff");
        startTime = System.currentTimeMillis();
        MergeSort.sort(arrCopy);
        finishTime = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000 + " seconds");
    }

}
