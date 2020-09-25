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
        Scanner wordReader = new Scanner(theText);
        Scanner input = new Scanner(System.in);
        System.out.println("How many words do you want to read? Enter now: ");

        BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();

        int minlen = 3;
        int key;
        String word;
        while(wordReader.hasNextLine())
        {
            word = wordReader.next();
            key = word.hashCode();
            if(word.charAt(word.length()-1) == '.')
                word = word.substring(0,word.length()-1);
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
        }
    }
}
