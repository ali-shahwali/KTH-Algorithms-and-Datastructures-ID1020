package Labb_1.HigherGrade;
import Labb_1.task2.Stack;

import java.util.Scanner;
public class BalancedParenthesis
{
    // user inputs a string and of characters and the program checks if parentheses are balanced
    public static void main(String[] args)
    {
        Scanner strScan = new Scanner(System.in);

        System.out.println("Enter your sequence of parentheses:");
        String str = strScan.nextLine();

        char[] arr = new char[str.length()];
        for(int i = 0; i < str.length();i++)
            arr[i] = str.charAt(i);

        if(checkBalancedParentheses(arr))
            System.out.println("The parentheses are balanced");
        else
            System.out.println("The parentheses are not balanced");
    }

    /*
       we use a stack and push in any opening parentheses or bracket in to the stack
       if we encounter a closing parentheses or bracket we pop the stack and check if they pair
       if they don't we know the parentheses are not balanced, if they do we continue
       if we encounter a closing parentheses or bracket and the stack is empty we know balance isn't upheld
       at the end we check again if the stack is empty, if true we have balanced parentheses
    */
    public static boolean checkBalancedParentheses(char[] arr)
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

    // simply converts a parenthesis or bracket to the opposite for comparison
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
