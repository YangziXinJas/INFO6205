
public class DoublyLinkedList<E> {

	private Node<E> header;
	private int size;
	
	public DoublyLinkedList(){
		header = new Node<E>();
		size = 0;
	}
	
	public void addToTail(E tail) {
		Node<E> newNode = new Node<E>();
		// special case size = 0;
		if (size == 0) {
			// new node with be connected to header
			newNode = new Node<E>(header, header, tail);
			header.setNext(newNode); // header nodes prev and next is new node
			header.setPrev(newNode);
		} else {
			Node<E> temp = new Node<E>();
			temp = header.getPrev();
			newNode = new Node<E>(temp, header, tail); // last node is previous for new node and head is
																		// next of new node
			temp.setNext(newNode); // previous last node's next is set to new node
			header.setPrev(newNode);
		}
		size++;
	}
	
	public void addToFirst(E first) {
		if(size == 0) {
			addToTail(first);
		}else {
			// get the previous last node
			Node<E> tempNext = header.getNext();
			Node<E> newNode = new Node<>(header, tempNext, first); 
			tempNext.setPrev(newNode);
			header.setNext(newNode);
			
		}
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public void printList() {
		Node<E> curr = header.getNext();
		if(size == 0) {
			System.out.print("[]");
		}else {
			System.out.print("[" + curr.getVal());
			curr = curr.getNext();
			while(curr != header) {
				System.out.print(", " + curr.getVal());
				curr = curr.getNext();
			}
			System.out.print("]");
		}
	}
}
