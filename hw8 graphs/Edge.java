
public class Edge {
	private double weight;
	private Vertex src;
	private Vertex dest;
	
	public Edge(double weight, Vertex src, Vertex dest) {
		this.weight = weight;
		this.src = src;
		this.dest = dest;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public Vertex getSource() {
		return src;
	}
	
	public void setSource(Vertex src) {
		this.src = src;
	}
	
	public Vertex getDestination(){
		return dest;
	}
	
	public void setDestination(Vertex dest) {
		this.dest = dest;
	}
}
