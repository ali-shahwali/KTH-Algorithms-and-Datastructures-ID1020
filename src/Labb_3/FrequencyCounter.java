package Labb_3;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
public class FrequencyCounter
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int minlen = 3;
        File theText = new File("C:\\Users\\ali_z\\IdeaProjects\\KTH-Algoritmer-Datastrukturer-ID1020\\src\\Labb_3\\TheText.txt");
        Scanner reader = new Scanner(theText);
        Scanner input = new Scanner(System.in);
        System.out.println("How many words do you want to read? Enter now: ");
        int n = input.nextInt();

        OrderedArrayST<String, Integer> st = new OrderedArrayST<String, Integer>(n);
        int iterations = 0;
        while(reader.hasNextLine() && iterations < n)
        {
            String key = reader.next();
            if(key.length() < minlen)
                continue;

            if(!st.contains(key))
                st.put(key,1);
            else
                st.put(key,st.get(key) + 1);

            iterations++;
        }




    }
}
