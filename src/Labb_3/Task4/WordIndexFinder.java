package Labb_3.Task4;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
public class WordIndexFinder
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File theText = new File("C:\\Users\\ali_z\\IdeaProjects\\KTH-Algoritmer-Datastrukturer-ID1020\\src\\Labb_3\\TheText.txt");
        Scanner textReader = new Scanner(theText);
        ListBST<String,Integer> lbst = new ListBST<String,Integer>(40000);
        String key;
        int index = 0;
        while(textReader.hasNextLine())
        {
            key = textReader.next().toLowerCase();
            int wordLen = key.length();
            if(!Character.isAlphabetic(key.charAt(key.length()-1)))
                key = key.substring(0, key.length() - 1);

            lbst.put(key,index);
            index += wordLen + 1;
        }

        Scanner strScan = new Scanner(System.in);
        Scanner intScan = new Scanner(System.in);
        int i = 0;
        while(i != 2)
        {
            System.out.println("Type '1' to find a word, '2' to exit");
            i = intScan.nextInt();
            switch(i)
            {
                case 1:
                    System.out.println("Enter a word:");
                    String word = strScan.nextLine();
                    System.out.println(Arrays.toString(lbst.get(word).toArray()));
                    break;
                default:
                    break;
            }
        }

    }
}
