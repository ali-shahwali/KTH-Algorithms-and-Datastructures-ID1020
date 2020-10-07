package Labb_4.HigherGrade;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
README
    Takes 3 inputs, start, end and between point, finds the shortest path from start to end passing through between point.
    Uses dijkstras shortest path algorithm and takes the path from start -> between then between->end to find the shortest path.
*/
public class ShortestPathTest
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File nyc = new File("C:\\Algoritmer\\NYC.txt");
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(new Scanner(nyc));

        Scanner scan = new Scanner(System.in);
        System.out.println("What is the start point?");
        int startPoint = scan.nextInt();

        System.out.println("What is the end point?");
        int endPoint = scan.nextInt();

        System.out.println("What point should it pass through?");
        int betweenPoint = scan.nextInt();

        scan.close();

        int distance = 0;
        DijkstraShortestPath dspStart = new DijkstraShortestPath(ewg,startPoint);
        DijkstraShortestPath dspEnd = new DijkstraShortestPath(ewg, betweenPoint);
        if(dspStart.hasPathTo(betweenPoint) && dspEnd.hasPathTo(endPoint))
        {
            for(Edge x : dspStart.pathTo(betweenPoint))
            {
                System.out.println(x);
                distance += x.weight();
            }
            for(Edge x : dspEnd.pathTo(endPoint))
            {
                System.out.println(x);
                distance += x.weight();
            }
        }
        else
            System.out.println("No such path from " + startPoint + " to " + " through " + betweenPoint);

        System.out.println("Total distance: " + distance);
    }
}
