package graphs;

import java.util.*;

public class Node 
{
	  private int distanceFromSource = Integer.MAX_VALUE;
	  private boolean visited;
	  private List<Edge> edges = new ArrayList<Edge>(); 
	  
	  public int getDistanceFromSource() {
	    return distanceFromSource;
	  }
	  public void setDistanceFromSource(int distanceFromSource) {
	    this.distanceFromSource = distanceFromSource;
	  }
	  public boolean isVisited() {
	    return visited;
	  }
	  public void setVisited(boolean visited) {
	    this.visited = visited;
	  }
	  public List<Edge> getEdges() {
	    return edges;
	  }
	  public void setEdges(List<Edge> edges) {
	    this.edges = edges;
	  }

	}