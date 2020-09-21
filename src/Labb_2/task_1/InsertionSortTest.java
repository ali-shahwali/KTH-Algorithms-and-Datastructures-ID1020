package Labb_2.task_1;

import Labb_2.task_2.InsertionSortSwaps;
import Labb_2.task_3.InsertionSortInversion;
import java.util.Arrays;
import java.util.Scanner;

// takes a user inputted array of length n and finds every inversion, sorts using insertion sort and counts every swap
public class InsertionSortTest
{
    public static void main(String[] args)
    {
        Scanner intScan = new Scanner(System.in);
        System.out.println("Enter how many integers you want to sort");
        int n = intScan.nextInt();
        int[] arr = new int[n];
        int[] arrSwaps = new int[n];

        System.out.println("Enter what you want to sort");
        for(int i = 0; i < arr.length; i++)
        {
            n = intScan.nextInt();
            arr[i] = n;
            arrSwaps[i] = n;
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("Finding inversions: ");
        InsertionSortInversion.inversionCount(arr);

        System.out.println("Sorting...");
        InsertionSort.sort(arr);

        //System.out.println("Number of swaps: " + InsertionSortSwaps.sort(arrSwaps));
    }
}
