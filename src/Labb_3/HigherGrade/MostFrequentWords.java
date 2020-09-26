package Labb_3.HigherGrade;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.Key;
import java.util.Arrays;
import java.util.Scanner;
import Labb_3.Task2.OrderedArrayST;
public class MostFrequentWords
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File text = new File("C:\\Algoritmer\\leipzig1m.txt");
        Scanner reader = new Scanner(text);
        SeparateChainingHash<String, Integer> ht = new SeparateChainingHash<String, Integer>();
        String key;
        long startTime = System.nanoTime();
        while(reader.hasNextLine())
        {
            key = reader.next().toLowerCase();
            if(!Character.isAlphabetic(key.charAt(key.length()-1)))
                key = key.substring(0, key.length() - 1);
            if(ht.contains(key))
                ht.put(key, ht.get(key) + 1);
            else
                ht.put(key,1);
        }
        long finishTime = System.nanoTime();
        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000000000);

        OrderedArrST orderedST = new OrderedArrST(ht.size());
        startTime = System.nanoTime();
        for(String s : ht.keys())
        {
            orderedST.put(ht.get(s),s);
        }
        finishTime = System.nanoTime();
        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000000000);

    }
}
