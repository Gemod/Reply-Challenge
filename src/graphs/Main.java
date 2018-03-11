package graphs;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main 
{
	 public static void main(String[] args) 
	 {
		    Edge[] edges = 
		    {
		      new Edge(0, 2, 1), new Edge(0, 3, 4), new Edge(0, 4, 2),
		      new Edge(0, 1, 3), new Edge(1, 3, 2), new Edge(1, 4, 3),
		      new Edge(1, 5, 1), new Edge(2, 4, 1), new Edge(3, 5, 4),
		      new Edge(4, 5, 2), new Edge(4, 6, 7), new Edge(4, 7, 2),
		      new Edge(5, 6, 4), new Edge(6, 7, 5)
		    };
		    Edge[] edges1=
		    {
		    	new Edge(0,1,1),new Edge(0,2,4),new Edge(1,2,2),new Edge(1,3,4),
		    	new Edge(1,4,1),new Edge(2,4,4),new Edge(3,5,6),new Edge(3,6,1),
		    	new Edge(4,3,1),new Edge(6,4,5),new Edge(6,5,9),new Edge(6,7,1),
		    	new Edge(7,5,2)
		    };
		    System.err.println("inserisci numero");
		    Scanner in= new Scanner(System.in);
		    Graph g = new Graph(edges,in.nextInt());
		    g.calculateShortestDistances();
		    g.printResult();
		    System.out.println();
		    System.err.println("fuduli merda, inserisci numero");
		    Graph g1= new Graph(edges1,in.nextInt());
		    g1.calculateShortestDistances();
		    g1.printResult();
		
		    
		     
		    
	 }
}
