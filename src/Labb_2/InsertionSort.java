package Labb_2;

import java.util.Arrays;

public class InsertionSort
{
    public static void sort(int[] arr)
    {
        int swaps = 0;
        for(int i = 0; i < arr.length;i++)
        {
            for(int j = i; j > 0 && less(arr[j],arr[j-1]);j--)
            {
                exchange(arr, j, j-1);
                swaps++;
                System.out.println(Arrays.toString(arr));
            }
        }
        System.out.println(swaps);
    }

    private static void exchange(int[] arr, int i, int j)
    {
        int temp = i;
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean less(int i, int j)
    {
        return i < j;
    }
}

