
public class Node<E> {
	private Node<E> prev;
	private Node<E> next;
	private E val;
	
	public Node() {
		this(null, null, null);
	}
	
	public Node(E val) {
		this(null, null, val);
	}
	
	public Node(Node<E> prev, Node<E> next, E val) {
		this.prev = prev;
		this.next = next;
		this.val = val;
	}
	
	public Node<E> getPrev(){
		return prev;
	}
	
	public Node<E> getNext(){
		return next;
	}
	
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	public void setPrev(Node<E> prev) {
		this.prev = prev;
	}
	
	public E getVal(){
		return val;
	}
}
