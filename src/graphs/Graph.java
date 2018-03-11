package graphs;

import java.util.List;

public class Graph {
	private Node[] nodes;
	private int number_nodes;
	private Edge[] edges;
	private int number_edges;
	private int endPoint;

	public Graph(Edge[] edges,int endPoint) {
		this.edges = edges;
		this.number_nodes = calculateNumerNodes(edges);
		this.nodes = new Node[this.number_nodes];
		for (int i = 0; i < this.number_nodes; i++) {
			this.nodes[i] = new Node();
		}
		
		this.number_edges = edges.length;
		for (int edgeToAdd = 0; edgeToAdd < this.number_edges; edgeToAdd++) {
			this.nodes[edges[edgeToAdd].getFromNodeIndex()].getEdges().add(edges[edgeToAdd]);
			this.nodes[edges[edgeToAdd].getToNodeIndex()].getEdges().add(edges[edgeToAdd]);
		}
		this.endPoint=endPoint;
	}

	private int calculateNumerNodes(Edge[] edges) {
		int num_nodes = 0;
		for (Edge e : edges) {
			if (e.getToNodeIndex() > num_nodes)
				num_nodes = e.getToNodeIndex();
			if (e.getFromNodeIndex() > num_nodes)
				num_nodes = e.getFromNodeIndex();
		}
		num_nodes++;
		return num_nodes;
	}

	public void calculateShortestDistances() 
	{
		this.nodes[0].setDistanceFromSource(0);
		int nextNode = 0;
	
		for (int i = 0; i < this.nodes.length; i++) 
		{
	
			List<Edge> currentNodeEdges = this.nodes[nextNode].getEdges();
			for (int j = 0; j < currentNodeEdges.size(); j++) {
				int neighbourIndex = currentNodeEdges.get(j).getNeighbourIndex(nextNode);
				if (!this.nodes[neighbourIndex].isVisited()) 
				{
					int tentative = this.nodes[nextNode].getDistanceFromSource()+currentNodeEdges.get(j).getLength();
					if (tentative < nodes[neighbourIndex].getDistanceFromSource()) {
						nodes[neighbourIndex].setDistanceFromSource(tentative);
					}
				}
			}
			nodes[nextNode].setVisited(true);
			nextNode = getNodeShortestDistanced();
		}
	}

	// now we're going to implement this method in next part !
	private int getNodeShortestDistanced() {
		int storedNodeIndex = 0;
		int storedDist = Integer.MAX_VALUE;
		for (int i = 0; i < this.nodes.length; i++) 
		{
			int currentDist = this.nodes[i].getDistanceFromSource();
			if (!this.nodes[i].isVisited() && currentDist < storedDist) 
			{
				storedDist = currentDist;
				storedNodeIndex = i;
			}
		}
		return storedNodeIndex;
	}
	

	public void printResult() {
		String output = " ";
		
		for (int i = 0; i < this.nodes.length; i++) 
		{
			if(i== this.endPoint)
			{
				output = ("\nThe shortest distance from node 0 to node " + i + " is " + nodes[i].getDistanceFromSource());
				break;
			}

		}
		System.out.println(output + " lenght array nodes " + this.nodes.length);
	}

	public Node[] getNodes() {
		return nodes;
	}

	public int getNoOfNodes() {
		return number_nodes;
	}

	public Edge[] getEdges() {
		return edges;
	}

	public int getNoOfEdges() {
		return number_edges;
	}
}
