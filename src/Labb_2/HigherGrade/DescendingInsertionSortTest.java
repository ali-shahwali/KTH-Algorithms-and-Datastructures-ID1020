package Labb_2.HigherGrade;

import java.util.*;

/*
README
    To sort in descending order we multiply every entry in the array with -1 making them negative, then sort them
    which essentially puts the largest entry because they are negative, then we multiply every entry again
    with -1 to convert them back to positive which has in turn given us the array sorted in descending order.
*/
public class DescendingInsertionSortTest
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        Scanner intScan = new Scanner(System.in);

        System.out.print("Enter desired array length: ");
        int n = intScan.nextInt();
        System.out.println();
        int[] arr = new int[n];
        int randInt;
        for(int i = 0; i < n; i++)
        {
            randInt = rand.nextInt(n);
            arr[i] = randInt;
        }

        System.out.println("Inputted array:\n" + Arrays.toString(arr));
        for(int i = 0; i < arr.length; i++)
            arr[i] *= -1;

        sort(arr);

        for(int i = 0; i < arr.length; i++)
            arr[i] *= -1;

        System.out.println("Sorted array in descending order: \n" + Arrays.toString(arr));

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
