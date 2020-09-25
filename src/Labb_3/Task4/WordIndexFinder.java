package Labb_3.Task4;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
public class WordIndexFinder
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File theText = new File("C:\\Users\\ali_z\\IdeaProjects\\KTH-Algoritmer-Datastrukturer-ID1020\\src\\Labb_3\\Task1\\TheText.txt");
        Scanner textReader = new Scanner(theText);
        ListBST<String> lbst = new ListBST<String>(40000);
        String key;
        int index = 0;
        while(textReader.hasNextLine())
        {
            key = textReader.next();
            lbst.put(key,index);
            index += key.length() + 1;
        }

        Scanner strScan = new Scanner(System.in);
        Scanner intScan = new Scanner(System.in);
        System.out.println("Type '1' to find another word, '2' to exit");
        int i = 0;
        while(i != 2)
        {
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
