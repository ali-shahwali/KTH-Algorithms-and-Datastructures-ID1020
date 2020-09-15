package Labb_2.task_1_2_3;

import java.util.Arrays;
import java.util.Scanner;
public class InsertionSortTest
{
    public static void main(String[] args)
    {
        Scanner intScan = new Scanner(System.in);
        System.out.println("Enter how many integers you want to sort");
        int n = intScan.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter what you want to sort");
        for(int i = 0; i < arr.length; i++)
        {
            n = intScan.nextInt();
            arr[i] = n;
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("Checking inversions");
        InsertionSort.inversionCount(arr);

        System.out.println("Sorting...");

        InsertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
