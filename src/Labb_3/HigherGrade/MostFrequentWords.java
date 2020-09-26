package Labb_3.HigherGrade;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class MostFrequentWords
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File text = new File("C:\\Algoritmer\\leipzig1m.txt");
        Scanner reader = new Scanner(text);
        SeparateChainingHash<String, Integer> ht = new SeparateChainingHash<String, Integer>();
        String key;
        long startTime = System.nanoTime();
        StringBuilder sb;
        while(reader.hasNextLine())
        {
            key = reader.next().toLowerCase();
            sb = new StringBuilder("");
            for(int i = 0; i < key.length();i++)
            {
                if(Character.isAlphabetic(key.charAt(i)))
                    sb.append(key.charAt(i));
            }
            key = sb.toString();
            if(key.length() == 0)
                continue;
            if(ht.contains(key))
                ht.put(key, ht.get(key) + 1);
            else
                ht.put(key,1);
        }
        long finishTime = System.nanoTime();
        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000000000);

        OrderedArrST orderedST = new OrderedArrST();
        startTime = System.nanoTime();
        for(String s : ht.keys())
        {
            orderedST.put(ht.get(s),s);
        }
        finishTime = System.nanoTime();
        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000000000);

        Scanner intScan = new Scanner(System.in);
        int i = 0;
        while(i != 3)
        {
            System.out.println("'1' to find k:th most used words, '2' to find k:th to n:th most used words");
            i = intScan.nextInt();
            switch(i)
            {
                case 1:
                    System.out.println("Example: Typing '1' will give the most used word/words, " +
                            "typing '2' will give the second most used word/words etc ");
                    int k = intScan.nextInt();
                    System.out.println(Arrays.toString(orderedST.findKthMost(k)) + " "+ orderedST.getFrequency(k) +" occurrences");
                    break;
                case 2:
                    System.out.println("Example: Typing '1' then '3' will give the most used, and up to and including the" +
                            " 4th most used word/words");
                    k = intScan.nextInt();
                    int n = intScan.nextInt();
                    if(k > n)
                        System.out.println("Index out of bounds");
                    while(k <= n)
                    {
                        System.out.println(Arrays.toString(orderedST.findKthMost(k)) + " " + orderedST.getFrequency(k) + " occurrences");
                        k++;
                    }
                    break;
                default:
                    break;
            }
        }

    }
}
