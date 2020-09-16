package Labb_2.HigherGrade;
import java.util.*;
public class QuickSortTest
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        Scanner intScan = new Scanner(System.in);
        System.out.println("Enter desired array length");
        int n = intScan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            int randInt = rand.nextInt(n);
            arr[i] = randInt;
        }
        int[] arrCopy = arr;
        System.out.println(Arrays.toString(arr));
        QuickSort.sort(arr,0,n-1);
        System.out.println(Arrays.toString(arr));

        QuickSort.sortMedian3(arrCopy,0,n-1);
        System.out.println(Arrays.toString(arrCopy));
    }
}
