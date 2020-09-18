package Labb_2.task_6;

public class MergeSortCutoff
{
    public static void sort(int[] arr, int[] aux, int lo, int hi, int cutoff)
    {
        if(hi <= lo + cutoff)
        {
            insertionSort(arr,lo,hi);
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(arr, aux, lo, mid, cutoff);
        sort(arr, aux, mid + 1, hi, cutoff);
        merge(arr, aux, lo, mid, hi);
    }

    private static void merge(int[] arr, int[] aux, int lo, int mid, int hi)
    {
        for (int k = lo; k <= hi; k++)
        {
            aux[k] = arr[k];
        }

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++)
        {
            if(i > mid)
            {
                arr[k] = aux[j];
                j++;
            }
            else if(j > hi)
            {
                arr[k] = aux[i];
                i++;
            }
            else if(less(aux[j], aux[i]))
            {
                arr[k] = aux[j];
                j++;
            }
            else
            {
                arr[k] = aux[i];
                i++;
            }
        }
    }
    private static void insertionSort(int[] arr, int lo, int hi)
    {

        for(int i = lo; i <= hi; i++)
        {
            for(int j = i; j > lo && less(arr[j],arr[j-1]); j--)
            {
                exchange(arr,j,j-1);
            }
        }
    }

    private static void exchange(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
    private static boolean less(int i, int j)
    {
        return i < j;
    }
}
