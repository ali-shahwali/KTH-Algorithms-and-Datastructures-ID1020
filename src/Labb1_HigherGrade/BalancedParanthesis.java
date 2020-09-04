package Labb1_HigherGrade;
import Labb1_task2.Stack;
import java.util.Scanner;
public class BalancedParanthesis
{

    public static void main(String[] args)
    {
        Scanner strScan = new Scanner(System.in);

        System.out.println("Enter your sequence of parantheses:");
        String str = strScan.nextLine();

        char[] arr = new char[str.length()];
        for(int i = 0; i < str.length();i++)
            arr[i] = str.charAt(i);

        if(checkBalancedParantheses(arr))
            System.out.println("The parantheses are balanced");
        else
            System.out.println("The parantheses are not balanced");
    }

    public static boolean checkBalancedParantheses(char[] arr)
    {
        Stack stack = new Stack();
        for(int i = 0; i < arr.length; i++)
        {
            if (arr[i] == ('(' | '[' | '{'))
                stack.push(arr[i]);
            else if(arr[i] == (')' | ']' | '}'))
            {
                if(stack.isEmpty() || stack.pop() != opposite(arr[i]))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static char opposite(char a)
    {
        if(a == ')')
            return '(';
        else if(a == ']')
            return '[';
        else
            return '{';
    }
}
