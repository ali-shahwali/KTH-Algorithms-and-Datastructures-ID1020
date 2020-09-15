package Labb_2.HigherGrade;
import Labb_2.task_1_2_3.InsertionSort;

import java.util.*;
public class AugmentedInsertionSortTest
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        Scanner intScan = new Scanner(System.in);

        System.out.print("Enter desired array length: ");
        int n = intScan.nextInt();
        System.out.println();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            int randInt = rand.nextInt(n);
            arr[i] = randInt;
        }
        System.out.println(Arrays.toString(arr));
        InsertionSort.sort(arr);
        reverseOrder(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverseOrder(int[] arr)
    {
        int j = arr.length - 1;
        for(int i = 0; i < j; i++)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }
    }


}
