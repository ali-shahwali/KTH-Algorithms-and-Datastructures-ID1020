package Labb_4.HigherGrade;
import java.io.File;
import java.util.Scanner;
public class ShortestPathTest
{
    public static void main(String[] args)
    {
        File nyc = new File("C:\\Algoritmer\\NYC.txt");
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(new In(nyc));
        Scanner scan = new Scanner(System.in);

        System.out.println("What is the start point?");
        int startPoint = scan.nextInt();
        System.out.println("What is the end point?");
        int endPoint = scan.nextInt();
        System.out.println("What point should it pass through?");
        int betweenPoint = scan.nextInt();

        DijkstraShortestPath dsp = new DijkstraShortestPath(ewg,startPoint);
        if(dsp.hasPathTo(betweenPoint) && dsp.hasPathTo(endPoint))
        {
            for(Edge x : dsp.pathTo(betweenPoint))
            {
                if(x.)
            }
        }
        else
            System.out.println("No such path from " + startPoint + " to " + " through " +betweenPoint);
    }
}
