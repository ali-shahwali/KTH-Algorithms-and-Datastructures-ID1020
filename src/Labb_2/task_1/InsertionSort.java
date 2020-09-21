package Labb_2.task_1;

import java.util.Arrays;

/*
README
    Simple insertion sort algorithm, we start at array index 1 and continuously
    compare with the element to the left until we reach index 0, then we increment
    to index 2 and repeat until we reach the final element.
    We do this with a nested for-loop giving us the worst case time complexity O(n²).
    We print the array after each inner loop using Arrays.toString()
*/
public class InsertionSort
{
    /*
        insertion sort starts at index 1 in the array and checks every element to the left of it
        if the element to the left it larger than it we preform a swap, otherwise we break and iterate to
        the next element in the array.
    */
    public static void sort(int[] arr)
    {
        for(int i = 1; i < arr.length;i++)
        {
            for(int j = i; j > 0 && less(arr[j],arr[j-1]);j--)
            {
                exchange(arr, j, j-1);
            }
            System.out.println(Arrays.toString(arr));
        }
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

