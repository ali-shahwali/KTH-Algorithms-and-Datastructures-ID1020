package Labb_2.task_5;
import Labb_2.task_1_2_3.InsertionSort;
import java.util.Scanner;
import java.util.Random;
public class CompareSortTest
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        Scanner intScan = new Scanner(System.in);
        System.out.print("Enter how many elements are to be sorted: ");
        int n = intScan.nextInt();
        System.out.println();


        int[] arr = new int[n];
        int[] arrCopy = new int[n]; // used to sort with insertionsort
        for(int i = 0; i < arr.length; i++)
        {
            int randomInt = rand.nextInt(n);
            arr[i] = randomInt;
            arrCopy[i] = randomInt;
        }
        int[] aux = new int[arr.length]; // auxiliary array used for merge

        System.out.println("Sorting with mergesort...");
        long startTime = System.nanoTime();
        MergeSort.sort(arr,aux,0,arr.length-1);
        long finishTime = System.nanoTime();
        System.out.println("Time elapsed: " + (double)(finishTime - startTime)/1000000000 + " seconds");

        System.out.println("Sorting with insertionsort...");
        startTime = System.nanoTime();
        InsertionSort.sort(arrCopy);
        finishTime = System.nanoTime();
        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000000000 + " seconds");


    }
}