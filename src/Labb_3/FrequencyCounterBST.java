package Labb_3;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class FrequencyCounterBST
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File theText = new File("C:\\Users\\ali_z\\IdeaProjects\\KTH-Algoritmer-Datastrukturer-ID1020\\src\\Labb_3\\TheText.txt");
        Scanner reader = new Scanner(theText);
        Scanner input = new Scanner(System.in);
        System.out.println("How many words do you want to read? Enter now: ");
        int n = input.nextInt();

        BinarySearchTree<String, Integer> bst = new BinarySearchTree<String, Integer>();
        int iterations = 0, distinct = 0;
        int minLen = 3;
        String key, mostFreq = "O";
        bst.put(mostFreq,0);
        while(reader.hasNextLine() && iterations < n)
        {
            key = reader.next();
            if(key.length() < minLen)
                continue;
            if(!bst.contains(key))
            {
                bst.put(key, 1);
                distinct++;
            }
            else
                bst.put(key, bst.get(key) + 1);
            if(bst.get(key) > bst.get(mostFreq))
                mostFreq = key;

            iterations++;
        }

        System.out.println("Number of words " + iterations);
        System.out.println("Number of distinct words " + distinct);
        System.out.println("Most frequent word '" + mostFreq + "' it appeared " + bst.get(mostFreq));
    }
}
