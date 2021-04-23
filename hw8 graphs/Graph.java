import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class Graph {
	
	private ArrayList<Vertex> vertices;
	private Vertex start;
	
	public Graph() {
		
		vertices = new ArrayList<>();

	}
	
	public void addVertices(ArrayList<Vertex> vs) {
		for(Vertex v: vs) {
			Vertex newVertex = new Vertex(v.getValue());
			vertices.add(newVertex);
		}
		vertices.get(0).addNeighbor(new Edge(10, vertices.get(0), vertices.get(1)));
		vertices.get(0).addNeighbor(new Edge(15, vertices.get(0), vertices.get(2)));
		
		vertices.get(1).addNeighbor(new Edge(15, vertices.get(1), vertices.get(3)));
		vertices.get(1).addNeighbor(new Edge(15, vertices.get(1), vertices.get(5)));
		
		vertices.get(2).addNeighbor(new Edge(10, vertices.get(2), vertices.get(4)));
		
		vertices.get(3).addNeighbor(new Edge(1, vertices.get(3), vertices.get(5)));
		vertices.get(3).addNeighbor(new Edge(2, vertices.get(3), vertices.get(4)));
		
		vertices.get(5).addNeighbor(new Edge(5, vertices.get(5), vertices.get(4)));
	}
	
	public ArrayList<Vertex> getVertices(){
		return vertices;
	}
	
	public void dijkstra(Vertex src) {
		start = src;
		src.setShortestDistance(0);
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.add(src);
		
		// start
		while(!pq.isEmpty()) {
			Vertex curr = pq.poll();
			
			for(Edge e: curr.getNeighbors()) {
				Vertex dest = e.getDestination();
				double weight = e.getWeight();
				double minDistance = curr.getShortedDistance() + weight;
				
				if(minDistance < dest.getShortedDistance()) {
					pq.remove(curr);
					dest.setPrevVertex(curr);
					dest.setShortestDistance(minDistance);
					pq.add(dest);
				}
			}
		}

	}
	
	public String getShortestPath(Vertex dest){
		List<Vertex> path = new ArrayList<>();
		String result = "";
		for(Vertex v = dest; v != null; v = v.getPrevVertex()) {
			path.add(v);
			result = v.getValue() + " -> " + result;
			if(v.getValue().equals(start.getValue())) {
				return result + "DONE";
			}
		}
		//Collections.reverse(path);
		if(!path.contains(start)) {
			return "NO PATH";
		}
		return result;
	}
}
