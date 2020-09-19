package Labb_2.HigherGrade;
import Labb_2.task_1_2_3.InsertionSort;
public class QuickSort
{
    public static void sort(int[] arr, int lo, int hi)
    {
        if(hi <= lo)
            return;

        int j = partition(arr,lo,hi);
        sort(arr,lo,j-1);
        sort(arr,j+1,hi);
    }

    public static void sortMedian3(int[] arr, int lo, int hi)
    {
        int n = (hi - lo + 1);
        if(hi <= lo)
            return;

        int[] medianArr = {arr[lo],arr[lo + n/2],arr[hi]};
        int median = median3(medianArr);
        exchange(arr,median,lo);

        int j = partition(arr,lo,hi);
        sort(arr,lo,j-1);
        sort(arr,j+1,hi);
    }

    private static int partition(int[] arr, int lo, int hi)
    {
        int i = lo;
        int j = hi + 1;
        int v = arr[lo];
        while(true)
        {
            while(less(arr[++i],v))
            {
                if(i == hi)
                    break;
            }

            while(less(v,arr[--j]))
            {
                if(j == lo)
                    break;
            }

            if(j <= i)
                break;

            exchange(arr,i,j);
        }

        exchange(arr,lo,j);
        return j;
    }

    private static int median3(int[] arr)
    {
        InsertionSort.sort(arr);
        return arr[1];
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
