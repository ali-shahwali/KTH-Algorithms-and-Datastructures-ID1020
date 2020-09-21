package Labb_2.HigherGrade;
// code is heavily inspired by Robert Sedgewick and Kevin Wayne from their booksite Algorithms 4th edition

/*
README
    Quicksort uses the divide and conquer method, we first grab a random element (usually the first) of an array
    and partition the array in to two parts, partitioning involves putting every element smaller than the partitioned
    element on the left side, and every element larger on the right side. We recursively do this to both sides
    which will provide us with a sorted array and a time complexity of O(nlog(n)).
*/
public class QuickSort
{
    /*
        Uses recursion to continuously partition the given array until the array is sorted, input 'arr' is the
        array that is sorted, 'lo' is the lowest index in the given subarray and 'hi' is the highest index
        in the given subarray.
    */
    public static void sort(int[] arr, int lo, int hi)
    {
        if(hi <= lo)
            return;

        int j = partition(arr,lo,hi);
        sort(arr,lo,j-1);
        sort(arr,j+1,hi);
    }

    /*
        Median 3 quicksort simply grabs the median of the first, middle and last element in the array as its
        partitioning element, we find the median by using insertion sort on the array of size 3. Note that we
        swap the median with last element.
    */
    public static void sortMedian3(int[] arr, int lo, int hi)
    {
        // n is used to find the middle of the current subarray
        int n = (hi - lo + 1);
        if(hi <= lo)
            return;

        // finds the median of the lowest, middle and highest entry
        int[] medianArr = {arr[lo],arr[lo + n/2],arr[hi]};
        int medianIndex = median3(medianArr,lo,lo + n/2,hi);
        exchange(arr,medianIndex,lo);

        int j = partition(arr,lo,hi);
        sort(arr,lo,j-1);
        sort(arr,j+1,hi);
    }

    /*
        we have a variable 'i' starting at lo and a variable 'j' starting at hi, we increment 'i' until we find
        an element larger than the element we are partitioning, we decrement 'j' until we find a smaller element.
        The purpose being to find what position the partitioning entry should be placed in. if 'j' never passes 'i' we
        swap them and continue the loop, if 'j' passes 'i' then we have found every smaller and larger element and
        we can swap the partitioning entry with j and return j's position for further partitioning.
    */
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

    // returns the median of 3 numbers
    private static int median3(int[] arr,int lo, int mid, int hi)
    {
        if ((arr[0] < arr[1] && arr[1] < arr[2]) || (arr[2] < arr[1] && arr[1] < arr[0]))
            return mid;
        else if ((arr[1] < arr[0] && arr[0] < arr[2]) || (arr[2] < arr[0] && arr[0] < arr[1]))
            return lo;
        else
            return hi;
    }

    // if i is less than j return true
    private static boolean less(int i, int j)
    {
        return i < j;
    }

    // swap values at index i an j in given array
    private static void exchange(int[] arr,int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
