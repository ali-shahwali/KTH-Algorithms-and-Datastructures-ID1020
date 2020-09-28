package Labb_3.HigherGrade;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
/*
    Stores every word read from the text inside a separate chaining hashmap, the key is the word and the value
    is every occurrence of the word. All data is then transferred to an ordered array symbol table that
    utilises binary search, the key is the word frequency and the value is every word with that frequency.
    Because the ordered array is sorted we have a constant access time O(1). We only read
    the text when inserting all the data in to our hashmap according to the assignment requirements.
*/
public class MostFrequentWords
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File text = new File("C:\\Algoritmer\\leipzig1m.txt");
        Scanner intScan = new Scanner(System.in);
        SeparateChainingHash<String, Integer> ht = new SeparateChainingHash<String, Integer>();

        char ch;
        StringBuilder sb = new StringBuilder("");
        String key;
        System.setIn(new FileInputStream(text));
        long startTime = System.nanoTime();
        while(!StdIn.isEmpty())
        {
            ch = StdIn.readChar();
            if(Character.isAlphabetic(ch))
                sb.append(ch);
            else if(sb.length() >= 1)
            {
                key = sb.toString().toLowerCase();
                if(!ht.contains(key))
                    ht.put(key,1);
                else
                    ht.put(key, ht.get(key) + 1);

                sb.delete(0, sb.length());
            }
        }

        // moves all data in the hashmap to the augmented ordered array
        OrderedArrST orderedST = new OrderedArrST();
        for(String s : ht.keys())
        {
            orderedST.put(ht.get(s),s);
        }
        long finishTime = System.nanoTime();
        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000000000);

        // returns the kth most used word/words in constant time, or kth to nth most used word in constant time.
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
