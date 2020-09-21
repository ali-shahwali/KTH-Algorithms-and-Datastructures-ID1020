package Labb_2.HigherGrade;
import java.util.*;
/*
README
    Sorts an array with given input n in sizes with entries ranging  from 0-n first without median 3 partitioning
    quicksort and then with median 3 partitioning quicksort, tracks time with System.nanoTime() which we convert to
    seconds.
*/
public class QSortMedian3Test
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        Scanner intScan = new Scanner(System.in);
        System.out.println("Enter desired array length");
        int n = intScan.nextInt();

        int[] arr = new int[n];
        int[] arrCopy = new int[n];
        int randInt;
        for(int i = 0; i < n; i++)
        {
            randInt = rand.nextInt(n);
            arr[i] = randInt;
            arrCopy[i] = randInt;
        }

        System.out.println("Sorting without median 3");
        long startTime = System.nanoTime();
        QuickSort.sort(arr,0,arr.length-1);
        long finishTime = System.nanoTime();
        System.out.println("Time elapsed: " + (double)(finishTime - startTime)/1000000000 + " seconds");

        System.out.println("Sorting with median 3");
        startTime = System.nanoTime();
        QuickSort.sortMedian3(arrCopy,0, arrCopy.length-1);
        finishTime = System.nanoTime();
        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000000000 + " seconds");
    }
}
