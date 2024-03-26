package customqueue;

public class QueueTypeL<E> implements CustomQueue<E> {
	private int size;
	private Node<E> head;
	private Node<E> tail;
	
	public QueueTypeL() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean enqueue(Object object) {
		E node;
		try {
			node = (E)object;
		}catch(ClassCastException e) {
			throw new ClassCastException("Wrong argument type. The class cannot be cast to the type specified in queue!");
		}
		if(this.head == null) {
			this.head = new Node<E>(node);
			this.tail = this.head;
		}
		else {
			this.tail.next = new Node<E>(node);
			this.tail = this.tail.next;
		}
		this.size++;
		return true;
	}


	@Override
	public E dequeue() {
		if(this.head == null)
			throw new RuntimeException("Empty Queue!");
		E node = this.head.element;
		this.head = this.head.next;
		this.size--;
		return node;
	}


	@Override
	public E peek() {
		if(this.head == null)
			throw new RuntimeException("Empty Queue!");
		return this.head.element;
	}


	@Override
	public int getSize() {

		return this.size;
	}
	
	private class Node<K>{
		K element;
		Node<K> next;
		Node(K e){
			this.element = e;
			next = null;
		}
	}
	
}
