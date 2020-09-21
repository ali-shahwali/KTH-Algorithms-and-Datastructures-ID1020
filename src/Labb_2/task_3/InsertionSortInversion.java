package Labb_2.task_3;

import java.util.Arrays;

/*
README
    An inversion is every pair of elements which in the context of the array is out-of-order
    For example the array containing [3,2,4,1] has inversions (3-2) (3-1) (2-4) and (4-1).
    To find every inversion we use a similar algorithm as insertion sort, we start at index 0
    and using a nested for-loop we check for every inversion by iterating through the array.
    We concatenate each inversion to a string and return said string. In the worst case
    we also have O(n²) time complexity.
*/
public class InsertionSortInversion
{
    // prints every inversion in a given integer array
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
        for(int i = 1; i < arr.length;i++)
        {
            for(int j = i; j > 0 && less(arr[j],arr[j-1]);j--)
            {
                exchange(arr, j, j-1);
            }
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
