package Labb_3.Task2;
import java.io.FileNotFoundException;
//import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
public class FrequencyCounterOrdArrST
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int minlen = 3;
        File theText = new File("C:\\Users\\ali_z\\IdeaProjects\\KTH-Algoritmer-Datastrukturer-ID1020\\src\\Labb_3\\Task1\\TheText.txt");
        Scanner reader = new Scanner(theText);
        Scanner input = new Scanner(System.in);
        System.out.println("How many words do you want to read? Enter now: ");
        int n = input.nextInt();

        OrderedArrayST<String, Integer> st = new OrderedArrayST<String, Integer>(n);
        int iterations = 0, distinct = 0;

        String key, mostFreq = "";
        st.put(mostFreq,0);
        long startTime = System.nanoTime();
        while(reader.hasNextLine() && iterations < n)
        {
            key = reader.next();
            if(key.length() < minlen)
                continue;

            if(!st.contains(key))
            {
                st.put(key, 1);
                distinct++;
            }
            else
                st.put(key,st.get(key) + 1);

            if(st.get(key) > st.get(mostFreq))
                mostFreq = key;

            iterations++;
        }
        long finishTime = System.nanoTime();
        /*
        Iterator itr = st.iterator();

        String maxKey = st.min();
        int maxValue = st.get(maxKey);
        String current;
        for(int i = 0; i < iterations; i++)
        {
            current = (String) itr.next();
            if(maxValue < st.get(current))
            {
                maxKey = current;
                maxValue = st.get(current);
            }
        }
        */
        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000000000);
        System.out.println("Most frequent word was '" + mostFreq + "'," + " it appeared "
                + st.get(mostFreq) + " times.");
        System.out.println("Nr of distinct words: " + distinct);
        System.out.println("Number of words: " + iterations);
    }
}
