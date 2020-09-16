package Labb_2.HigherGrade;

public class QuickSort
{
    public static void sort(int[] arr, int lo, int hi)
    {

    }

    private static boolean less(int i, int j)
    {
        return i < j;
    }

    private static void exchange(int[] arr,int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
