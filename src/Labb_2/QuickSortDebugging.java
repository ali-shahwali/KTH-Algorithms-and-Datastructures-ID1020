package Labb_2;
import Labb_2.HigherGrade.QuickSort;

import java.util.Arrays;

public class QuickSortDebugging
{
    public static void main(String[] args) {
        int[] arr = {3,5,4,1,2};
        QuickSort.sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}

