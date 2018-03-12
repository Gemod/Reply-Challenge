package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class Map {
	private int[][] matrix;
	private int r;
	private int c;
	private List<Obstacol> obstacols;
	private int number_obstacol;
	HashMap<Obstacol,List<Pair>> cross= new HashMap<>() ;


	public Map(int r, int c, List<Obstacol> obstacols) {
		super();
		this.r = r;
		this.c = c;
		this.number_obstacol = number_obstacol;
		this.obstacols=obstacols;
	}
	public List<Obstacol> getObstacols()
	{
		return obstacols;
	}
	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
	public double area(int x1, int y1, int x2, int y2, int x3, int y3)
	{
	   return Math.abs((x1*(y2-y3) +x2*(y3-y1)+ x3*(y1-y2))/2.0);
	}
	
	public List<Pair> getallCell()
	{
		List<Pair> allcells= new ArrayList<>();
		for(int i=0;i<this.r;i++)
		{
			for(int j=0;j<this.c;j++)
			{
				allcells.add(new Pair(i,j));
			}
		}
		return allcells;
	}
	public HashMap<Obstacol, List<Pair>> getCross() {
		return cross;
	}
	public void setCross(HashMap<Obstacol, List<Pair>> cross) {
		this.cross = cross;
	}
	public List<Pair> getMatrixPath()
	{
		List<Pair> path= new ArrayList<>();
		List<Pair> points=this.getallCell();
		for(Pair p: points)
		{
			for(Obstacol o : this.getObstacols())
			{
				if(!isInside(o.getX1(),o.getY1(),o.getX2(),o.getY2(),o.getX3(),o.getY3(),p.getX(),p.getY()))
				{
					if(!path.contains(p))
					{
						path.add(p);
					}
				}
			}
		}
		return path;
	}
	// x, y are coordinate of point that we want to know if is a point of triangle
	private boolean isInside(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y) 
	{
		double A = area(x1, y1, x2, y2, x3, y3);
		double A1 = area(x, y, x2, y2, x3, y3);
		double A2 = area(x1, y1, x, y, x3, y3);
		double A3 = area(x1, y1, x2, y2, x, y);
		return (A == A1 + A2 + A3);
	}
	public static void main(String[] args) 
	{
		List<Obstacol> obstacols= new ArrayList<>();
		obstacols.add(new Obstacol(2, 0, 2, 2, 4, 0));
		Map maps = new Map(5,5,obstacols);		
		for(Pair p: maps.getMatrixPath())
		{
			System.out.println(p.toString());
		}
	}
}
