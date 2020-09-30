package Labb_4.Task3;
import Labb_4.Digraph;
import Labb_4.SymbolDigraph;
import java.util.Scanner;
public class DigraphHasPathTest
{
    public static void main(String[] args)
    {
        SymbolDigraph sdg = new SymbolDigraph("C:\\Users\\ali_z\\IdeaProjects\\KTH-Algoritmer-Datastrukturer-ID1020\\src\\Labb_4\\TheDatabase.txt", " ");
        Scanner scan = new Scanner(System.in);
        Digraph dg = sdg.graph();

        System.out.println("Enter source state");
        String sourceState = scan.nextLine().toUpperCase();
        System.out.println("What state do you want the path to?");
        String endState = scan.nextLine().toUpperCase();

        int start = sdg.indexOf(sourceState);
        int end = sdg.indexOf(endState);

        DigraphDFP dfp = new DigraphDFP(dg,start);

        if(dfp.marked(end))
        {
            System.out.println("There is a directed path between " + sdg.nameOf(start) + " and " + sdg.nameOf(end));
        }
        else
            System.out.println("There is no directed path between those states");
    }
}
