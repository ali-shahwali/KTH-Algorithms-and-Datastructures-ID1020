package Labb_2;

import Labb_2.task_6.MergeSortCutoff;
import Labb_2.task_5.MergeSort;
import java.util.*;
public class MergeSortDebugging
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        int[] arr = new int[100];
        for(int i = 0; i < 100;i++)
        {
            int randInt = rand.nextInt(100);
            arr[i] = randInt;
        }
        MergeSortCutoff.sort(arr,new int[100],0,99,10);
        System.out.println(Arrays.toString(arr));
    }
}
