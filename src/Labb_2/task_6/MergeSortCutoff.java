package Labb_2.task_6;
/*
README
    A merge sort with cutoff simply means that we choose a point in which we stop dividing the array
    in to smaller chunks and instead switch to insertion sort to sort the smaller chunks. This can
    lead to a more optimized merge sort.
*/
public class MergeSortCutoff
{
    /*
        Input an array to be sorted, an auxiliary array of the same size that is empty, the lowest index
        the highest index, and a cutoff.
    */
    public static void sort(int[] arr, int[] aux, int lo, int hi, int cutoff)
    {
        // check if in cutoff range
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

        int i = lo;
        int j = mid+1;
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

    /*
        insertion sort starts at index 1 in the array and checks every element to the left of it
        if the element to the left it larger than it we preform a swap, otherwise we break and iterate to
        the next element in the array.
    */
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
