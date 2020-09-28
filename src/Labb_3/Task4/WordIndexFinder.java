package Labb_3.Task4;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
/*
README
    Stores the word as a key inside an ordered array ST that utilises binary search and has an arraylist for each
    value. It stores at what character index inside the text the word appears, it does this for every
    occurrence of the word.
*/
public class WordIndexFinder
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File theText = new File("C:\\Users\\ali_z\\IdeaProjects\\KTH-Algoritmer-Datastrukturer-ID1020\\src\\Labb_3\\TheText.txt");
        Scanner strScan = new Scanner(System.in);
        Scanner intScan = new Scanner(System.in);

        OrderedArrListST<String,Integer> st = new OrderedArrListST<String,Integer>(40000);
        String key;
        int index = 0;
        char ch;
        StringBuilder sb = new StringBuilder("");
        System.setIn(new FileInputStream(theText));
        // Reads every word from the text and removes non alphabetic characters
        while(!StdIn.isEmpty())
        {
            ch = StdIn.readChar();

            if(ch == '\r')
                continue;
            if(Character.isAlphabetic(ch))
                sb.append(ch);
            else if(sb.length() >= 1)
            {
                key = sb.toString().toLowerCase();
                st.put(key, (index - key.length()));
                sb.delete(0, sb.length());
            }

            index++;
        }

        // Allows the user to enter a word to find the character index of every occurrence of the word
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
                    System.out.println(Arrays.toString(st.get(word).toArray()));
                    break;
                default:
                    break;
            }
        }

    }
}
