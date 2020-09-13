package Labb_2;
import java.util.Arrays;
import java.util.Random;
public class MergeSortTest
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        int[] arr = new int[100];
        for(int i = 0; i < 100; i++)
        {
            int random = rand.nextInt(100);
            arr[i] = random;
        }

        MergeSort.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
