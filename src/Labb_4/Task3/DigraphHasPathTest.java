package Labb_4.Task3;
import Labb_4.Digraph;
import Labb_4.SymbolDigraph;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

/*
README
    Uses depth-first search to conclude if there is a path from inputted state to inputted end state.
    Assumes states are linked with specific directions i.e AL -> FL and not FL -> AL.
    Prints out the answer.
*/
public class DigraphHasPathTest
{
    public static void main(String[] args) throws FileNotFoundException {
        File database = new File("C:\\Users\\ali_z\\IdeaProjects\\KTH-Algoritmer-Datastrukturer-ID1020\\src\\Labb_4\\TheDatabase.txt");
        SymbolDigraph sdg = new SymbolDigraph(database, " ");
        Digraph dg = sdg.digraph();

        Scanner scan = new Scanner(System.in);
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
