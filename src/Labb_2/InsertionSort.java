package Labb_2;

import java.util.Arrays;

public class InsertionSort
{
    public static void inversionCount(int[] arr)
    {
        StringBuilder sb = new StringBuilder("");
        int inversions = 0;
        for(int i = 0; i < arr.length;i++)
        {
            for(int j = i + 1; j < arr.length;j++)
            {
                if(arr[i]>arr[j])
                {
                    sb.append("["+i+","+arr[i]+"],"+"["+j+","+arr[j]+"] ");
                    inversions++;
                }
            }
        }
        System.out.println(sb.toString());
        System.out.println("there are "+inversions+" inversions");
    }

    /*
        insertion sort starts at index 1 in the array and checks every element to the left of it
        if the element to the left it larger than it we preform a swap, otherwise we break and iterate to
        the next element in the array.
    */
    public static void sort(int[] arr)
    {
        int swaps = 0;
        for(int i = 1; i < arr.length;i++)
        {
            for(int j = i; j > 0 && less(arr[j],arr[j-1]);j--)
            {
                exchange(arr, j, j-1);
                swaps++;
            }
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("number of swaps "+swaps);
    }

    // swaps value at index i in array with value at index j in array
    private static void exchange(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // if i is less than j, return true
    private static boolean less(int i, int j)
    {
        return i < j;
    }
}

