package Labb_3.Task3;
import Labb_3.Task2.BinarySearchTree;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class DistributedHash
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File theText = new File("C:\\Users\\ali_z\\IdeaProjects\\KTH-Algoritmer-Datastrukturer-ID1020\\src\\Labb_3\\Task1\\TheText.txt");
        Scanner reader = new Scanner(theText);
        Scanner wordReader = new Scanner(theText);
        Scanner input = new Scanner(System.in);
        System.out.println("How many words do you want to read? Enter now: ");
        int n = input.nextInt();

        BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();

        int minlen = 3, iterations = 0;
        int key;
        String word;
        while(reader.hasNextLine() && iterations < n)
        {
            key = reader.next().hashCode();
            word = wordReader.next();
            if(word.length() < minlen)
                continue;
            if(!bst.contains(key))
            {
                bst.put(key,word);
                continue;
            }
            if(!(bst.get(key).equals(word)))
            {
                System.out.println("Duplicate: ");
                System.out.println(word + " " + word.hashCode());
                System.out.println(bst.get(key) + " " + key);
                System.out.println();
            }
            iterations++;
        }
    }
}
