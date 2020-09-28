package Labb_3.Task3;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
README
    Stores every word from the text in a hashmap and allows the user to input how many words are to be stored.
    It then prints out the average size of every hash bucket as well as the size of every bucket. An optimal hashmap
    should have an average size of 1 meaning every bucket should contain 1 word.
*/
public class HashDistribution
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File theText = new File("C:\\Users\\ali_z\\IdeaProjects\\KTH-Algoritmer-Datastrukturer-ID1020\\src\\Labb_3\\TheText.txt");
        Scanner scan = new Scanner(System.in);
        System.out.println("How many words are to be read?");
        int n = scan.nextInt();

        SeparateChainingHash<String, Integer> ht = new SeparateChainingHash<String, Integer>();
        char ch;
        String key;
        StringBuilder sb = new StringBuilder("");
        int words = 0;
        System.setIn(new FileInputStream(theText));
        while(!StdIn.isEmpty() && words < n)
        {
            ch = StdIn.readChar();
             if(ch == '\r')
                 continue;
             if(Character.isAlphabetic(ch))
                 sb.append(ch);
             else if(sb.length() >= 1)
             {
                 key = sb.toString().toLowerCase();
                 if(!ht.contains(key))
                 {
                     ht.put(key, 1);
                     words++;
                 }
                 else
                     ht.put(key, ht.get(key) + 1);
                 sb.delete(0,sb.length());
             }
        }

        int averageSize = ht.averageBucketSize();
        System.out.println("The average size of each bucket is " + averageSize);
        System.out.println("Size of each bucket is: ");
        ht.bucketSize();

    }
}
