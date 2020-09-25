package Labb_3.HigherGrade;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class MostFrequentWords
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File text = new File("C:\\leipzig1m.txt");
        Scanner reader = new Scanner(text);
        SeparateChainingHash<String, Integer> ht = new SeparateChainingHash<String, Integer>();
        String key;
        while(reader.hasNextLine())
        {
            key = reader.next();
            if(ht.contains(key))
            {
                ht.put(key, ht.get(key) + 1);
            }
            else
                ht.put(key,1);
        }
    }
}
