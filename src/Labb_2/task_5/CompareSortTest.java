package Labb_2.task_5;
import Labb_2.task_1_2_3.InsertionSort;
import java.util.Scanner;
import java.util.Random;
public class CompareSortTest
{
    public static void main(String[] args)
    {
        Scanner intScan = new Scanner(System.in);
        System.out.print("Enter how many elements are to be sorted: ");
        int n = intScan.nextInt();
        System.out.println();
        Random rand = new Random();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++)
        {
            int randomInt = rand.nextInt(n);
            arr[i] = randomInt;
        }
        int[] arrCopy = arr; // used to sort with insertionsort

        System.out.println("Sorting with mergesort...");
        long startTime = System.currentTimeMillis();
        MergeSort.sort(arr);
        long finishTime = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (double)(finishTime - startTime)/1000 + " seconds");

        System.out.println("Sorting with insertionsort...");
        startTime = System.currentTimeMillis();
        InsertionSort.sort(arrCopy);
        finishTime = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000 + " seconds");


    }
}
