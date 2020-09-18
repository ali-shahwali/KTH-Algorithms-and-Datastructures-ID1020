package Labb_2;
import java.util.*;
import Labb_2.task_5.MergeSort;
public class AlternateMergeSort
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        int[] arrCopy = new int[n];
        for(int i = 0; i < n; i++)
        {
            int randInt = rand.nextInt();
            arr[i] = randInt;
            arrCopy[i] = randInt;
        }
        long startTime = System.nanoTime();
        sort(arr);
        long finishTime = System.nanoTime();
        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000000000 + " seconds");

        startTime = System.nanoTime();
        MergeSort.sort(arrCopy,new int[n],0, arrCopy.length-1);
        finishTime = System.nanoTime();
        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000000000 + " seconds");
    }
    public static int[] sort(int[] arr)
    {
        if(arr.length <= 1)
            return arr;
        else
        {
            int divSize = arr.length/2;

            int[] leftArr = new int[divSize];
            int[] rightArr = new int[arr.length-divSize];

            for(int i = 0; i < divSize; i++)
            {
                leftArr[i] = arr[i];
            }

            for(int j = 0; j < rightArr.length; j++)
            {
                rightArr[j] = arr[divSize + j];
            }

            leftArr = sort(leftArr);
            rightArr = sort(rightArr);


            return merge(leftArr,rightArr);
        }
    }

    private static int[] merge(int[] leftArr,int[] rightArr)
    {
        int[] mergeArr = new int[leftArr.length + rightArr.length];
        int leftIndex = 0, rightIndex = 0, mergeIndex = 0;

        while(less(leftIndex,leftArr.length) || less(rightIndex,rightArr.length))
        {
            if(less(leftIndex,leftArr.length) && less(rightIndex,rightArr.length))
            {
                if(less(leftArr[leftIndex],rightArr[rightIndex]))
                    mergeArr[mergeIndex] = leftArr[leftIndex++];
                else
                    mergeArr[mergeIndex] = rightArr[rightIndex++];

                mergeIndex++;
            }
            else if(less(leftIndex,leftArr.length))
                mergeArr[mergeIndex++] = leftArr[leftIndex++];
            else
                mergeArr[mergeIndex++] = rightArr[rightIndex++];
        }
        return mergeArr;
    }

    private static boolean less(int i, int j)
    {
        return i < j;
    }
}
