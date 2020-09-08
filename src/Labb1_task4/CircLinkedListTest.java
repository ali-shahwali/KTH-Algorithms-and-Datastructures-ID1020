package Labb1_task4;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Iterator;
public class CircLinkedListTest
{
    // allows the user to add a string at the front and back, as well as remove at the front and back
    // of the list and also iterate through the list with a while loop and switch combo
    public static void main(String[] args)
    {
        CircLinkedList<String> circList = new CircLinkedList<String>();
        Scanner intScan = new Scanner(System.in);
        Scanner strScan = new Scanner(System.in);

        int i = 0;
        while(i != 6)
        {
            System.out.println("'1' to add back, '2' to add front, '3' & '4' same but remove, '5' to iterate, '6' to exit.");
            System.out.println("Enter: ");
            i = intScan.nextInt();
            switch(i)
            {
                case 1:
                    System.out.println("Add back");
                    String str = strScan.nextLine();
                    circList.addBack(str);
                    System.out.println(circList.toString());
                    break;

                case 2:
                    System.out.println("Add front: ");
                    String str2 = strScan.nextLine();
                    circList.addFront(str2);
                    System.out.println(circList.toString());
                    break;

                case 3:
                    System.out.println("Removing back");
                    circList.removeBack();
                    System.out.println(circList.toString());
                    break;

                case 4:
                    System.out.println("Removing front");
                    circList.removeFront();
                    System.out.println(circList.toString());
                    break;

                case 5:
                    Iterator itr = circList.iterator();
                    int j = 1;
                    while(j == 1)
                    {
                        System.out.println("'1' to iterate, else to exit");
                        j = intScan.nextInt();
                        System.out.println(itr.next());
                    }
                    break;

                default:
                    break;
            }
        }
    }
}
