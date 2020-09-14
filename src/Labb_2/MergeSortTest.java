package Labb_2;
import java.util.Arrays;
import java.util.Random;
public class MergeSortTest
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        int[] arr = new int[1000];
        for(int i = 0; i < arr.length; i++)
        {
            int randomInt = rand.nextInt(1000);
            arr[i] = randomInt;
        }
        int[] sortedArr = MergeSort.sort(arr);
        System.out.println(Arrays.toString(sortedArr));
    }
}
