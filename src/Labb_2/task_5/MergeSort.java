package Labb_2.task_5;

public class MergeSort
{
    public static void sort(int[] arr, int[] aux, int lo, int hi)
    {
        if(hi <= lo)
            return;

        int mid = lo + (hi - lo) / 2;
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid + 1, hi);
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

    private static boolean less(int i, int j)
    {
        return i < j;
    }
}
