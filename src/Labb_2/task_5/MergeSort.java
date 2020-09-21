package Labb_2.task_5;
// code is heavily inspired by Robert Sedgewick and Kevin Wayne from their booksite Algorithms 4th edition

/*
README
    Merge sort sorts an array using the divide and conquer method, we merge an array by taking 2 ordered arrays
    and combining them in to 1 large array, the sort method uses recursion to divide the array in to halves
    so we can later merge them.

*/
public class MergeSort
{
    /*
        Input an array to be sorted, an auxiliary array of the same size that is empty, the lowest index
        and the highest index.
    */
    public static void sort(int[] arr, int[] aux, int lo, int hi)
    {
        if(hi <= lo)
            return;

        int mid = lo + (hi - lo) / 2;
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid + 1, hi);
        merge(arr, aux, lo, mid, hi);

    }

    /*
        Merge the two subsections by having a variable 'i' iterate through the lower half and a variable 'j'
        iterate through the higher half, we pick the smallest element from each half and store it in the array.
        If 'i' or 'j' is out of bounds we simply grab from the remaining half.
    */
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
    // if i is less than j, return true
    private static boolean less(int i, int j)
    {
        return i < j;
    }
}
