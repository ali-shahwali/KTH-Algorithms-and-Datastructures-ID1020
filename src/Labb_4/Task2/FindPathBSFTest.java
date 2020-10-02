package Labb_4.Task2;

import Labb_4.Graph;
import Labb_4.SymbolGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindPathBSFTest
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File database = new File("C:\\Users\\ali_z\\IdeaProjects\\KTH-Algoritmer-Datastrukturer-ID1020\\src\\Labb_4\\TheDatabase.txt");
        SymbolGraph sg = new SymbolGraph(database, " ");
        Scanner scan = new Scanner(System.in);
        Graph g = sg.graph();
        System.out.println("Enter source state");
        String sourceState = scan.nextLine().toUpperCase();
        System.out.println("What state do you want the path to?");
        String endState = scan.nextLine().toUpperCase();

        int start = sg.indexOf(sourceState);
        int end = sg.indexOf(endState);
        BreadthFirstPaths bfs = new BreadthFirstPaths(g, start);

        if(bfs.hasPathTo(end))
        {
            System.out.println(sg.nameOf(start) + " to " + sg.nameOf(end));
            for(int x : bfs.pathTo(end))
            {
                if( x == start)
                    System.out.println(sg.nameOf(start));
                else
                    System.out.println("-" + sg.nameOf(x));
            }
            System.out.println();
        }
        else
            System.out.println(sg.nameOf(start) + " not connected with " + sg.nameOf(end));

    }
}
