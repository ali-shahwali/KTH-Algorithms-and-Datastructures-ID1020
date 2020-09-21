package Labb_2.HigherGrade;

import Labb_2.task_5.MergeSort;
import java.util.*;
/*
README
    Sorts an array with given input n in sizes with entries ranging  from 0-n first with merge sort then with
    quicksort, time is tracked using System.nanoTime() which is later converted to seconds.
*/
public class QSortMSortComparisonTest
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        Scanner intScan = new Scanner(System.in);
        System.out.println("Enter desired array length");
        int n = intScan.nextInt();

        int[] arr = new int[n];
        int[] arrCopy = new int[n];
        for(int i = 0; i < n; i++)
        {
            int randInt = rand.nextInt(n);
            arr[i] = randInt;
            arrCopy[i] = randInt;
        }

        System.out.println("Sorting with quick sort");
        long startTime = System.nanoTime();
        QuickSort.sort(arr,0,arr.length-1);
        long finishTime = System.nanoTime();
        System.out.println("Time elapsed: " + (double)(finishTime - startTime)/1000000000 + " seconds");

        System.out.println("Sorting with merge sort");
        startTime = System.nanoTime();
        MergeSort.sort(arrCopy,new int[n],0, arrCopy.length-1);
        finishTime = System.nanoTime();
        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000000000 + " seconds");
    }
}
