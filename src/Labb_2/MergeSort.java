package Labb_2;

public class MergeSort
{
    public static int[] sort(int[] arr)
    {
        if(arr.length <= 1)
            return arr;
        else
        {
            int divSize = arr.length/2;

            int[] leftArr = new int[divSize];
            int[] rightArr;

            if(arr.length % 2 == 0)
                rightArr = new int[divSize];
            else
                rightArr = new int[divSize + 1];

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

            int[] sortedArr = merge(leftArr, rightArr);

            return sortedArr;
        }
    }

    private static int[] merge(int[] leftArr,int[] rightArr)
    {
        int[] mergeArr = new int[leftArr.length + rightArr.length];

        int leftIndex, rightIndex, mergeIndex = 0;

        return mergeArr;
    }
}
