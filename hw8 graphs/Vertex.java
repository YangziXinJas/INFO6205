import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{
	private String value;
	private List<Edge> edges;
	private boolean visited;
	private Vertex prev;
	private double shortestPath = Double.MAX_VALUE;
	
	public Vertex(String value) {
		this.value = value;
		this.edges = new ArrayList<>();
	}
	
	public void addNeighbor(Edge e) {
		edges.add(e);
	}
	
	public List<Edge> getNeighbors(){
		return edges;
	}
	
	public void setEdge(List<Edge> edges) {
		this.edges = edges;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void setVisited() {
		visited = true;
	}
	
	public Vertex getPrevVertex() {
		return prev;
	}
	
	public void setPrevVertex(Vertex prev) {
		this.prev = prev;
	}
	
	public double getShortedDistance() {
		return shortestPath;
	}
	
	public void setShortestDistance(double min) {
		shortestPath = min;
	}
	
	public String getValue() {
		return this.value;
	}
	
	
	@Override
	public int compareTo(Vertex o) {
		// TODO Auto-generated method stub
		return Double.compare(this.getShortedDistance(), o.getShortedDistance());
	}

}
