package Labb_2;
import Labb_2.HigherGrade.QuickSort;

import java.util.Arrays;

public class QuickSortDebugging
{
    public static void main(String[] args) {
        int[] arr = {3,1,2,5,4,5,1,2,2,6,5,4,2,1,34,7,2};
        QuickSort.sortMedian3(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}

