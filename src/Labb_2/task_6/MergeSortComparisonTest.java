package Labb_2.task_6;
import Labb_2.task_5.MergeSort;
import java.util.*;
/*
    Fills 6 arrays with size n with identically random elements ranging from 0-n.
    Sorts one with cutoff 5, one with 10, one with 15, one with 20, one with 30 and one without cutoff.
    Sorting times are compared using System.nanoTime() and later converted to seconds.
*/
public class MergeSortComparisonTest
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        Scanner intScan = new Scanner(System.in);
        System.out.print("Enter desired array length: ");
        int n = intScan.nextInt();
        System.out.println();

        int[] arr5 = new int[n];
        int[] arr10 = new int[n];
        int[] arr15 = new int[n];
        int[] arr20 = new int[n];
        int[] arr30 = new int[n];
        int[] arrCopy = new int[n];
        int randInt;
        for(int i = 0; i < n; i++)
        {
            randInt = rand.nextInt(n);
            arr5[i] = randInt;
            arrCopy[i] = randInt;
            arr10[i] = randInt;
            arr15[i] = randInt;
            arr20[i] = randInt;
            arr30[i] = randInt;
        }

        System.out.println("Sorting with cutoff 5");
        long startTime = System.nanoTime();
        MergeSortCutoff.sort(arr5,new int[arr5.length],0, arr5.length-1, 5);
        long finishTime = System.nanoTime();
        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000000000 + " seconds");

        System.out.println("Sorting with cutoff 10");
        startTime = System.nanoTime();
        MergeSortCutoff.sort(arr10,new int[arr10.length],0, arr10.length-1,10);
        finishTime = System.nanoTime();
        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000000000 + " seconds");

        System.out.println("Sorting with cutoff 15");
        startTime = System.nanoTime();
        MergeSortCutoff.sort(arr15,new int[arr15.length],0, arr15.length-1,15);
        finishTime = System.nanoTime();
        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000000000 + " seconds");

        System.out.println("Sorting with cutoff 20");
        startTime = System.nanoTime();
        MergeSortCutoff.sort(arr20,new int[arr20.length],0, arr20.length-1,20);
        finishTime = System.nanoTime();
        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000000000 + " seconds");

        System.out.println("Sorting with cutoff 30");
        startTime = System.nanoTime();
        MergeSortCutoff.sort(arr30,new int[arr30.length],0, arr30.length-1,30);
        finishTime = System.nanoTime();
        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000000000 + " seconds");

        System.out.println("Sorting without cutoff");
        startTime = System.nanoTime();
        MergeSort.sort(arrCopy,new int[arrCopy.length],0, arrCopy.length-1);
        finishTime = System.nanoTime();
        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000000000 + " seconds");
    }

}
