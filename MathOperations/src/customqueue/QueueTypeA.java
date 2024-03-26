package customqueue;

public class QueueTypeA<E> implements CustomQueue<E> {
	private final E[] array;
	private int tail;
	private int qSize;
	private int head;

	/**
	 * Create a new queue with a given size. This queue is not resizable. 
	 * The queue is array based and circular, which means, the queus will be full only and only if the number of element is
	 * equal to size of the this queue.
	 * @param size queue size
	 */
	@SuppressWarnings("unchecked")
	public QueueTypeA(int size) {
		if (size < 0)
			throw new IllegalArgumentException("Queue size cannot be negative!");
		this.qSize = 0;
		this.tail = -1;
		this.head = 0;
		this.array = (E[]) new Object[100];
	}

	/**
	 * Create a queue with defualt size (100 element). The queue array based and circular and not resizable, which means
	 * the queuonly and only if the the number of current elements in the queue is equal to size of this queue. 
	 */
	@SuppressWarnings("unchecked")
	public QueueTypeA() {
		this.qSize = 0;
		this.tail = -1;
		this.head = 0;
		this.array = (E[]) new Object[100];
	}

	/**
	 * Add an element to this queue. 
	 * @param object the new element to be added
	 * @return true if the new element is added successfully
	 * @throws ClassCastException if the new is not same type of object specified in queue initialization
	 */
	@Override
	public boolean enqueue(Object object) {
		//prepare for adding the element
		this.tail++;
		
		//Create a circular queue
		this.tail = this.tail % this.array.length;
		
		//Check if queue is full
		if (this.array[this.tail] != null)
			return false;
		
		//Throw if the new element is not the same format as specified in queue
		E node;
		try {
			node = (E) object;
		} catch (ClassCastException e) {
			throw new ClassCastException("Cannot cast " + object.toString() + ". Wrong format to cast!");
		}
		//Add the new element to the queue
		this.array[this.tail] = node;
		
		//update the current size of the queue
		this.qSize++;

		return true;
	}

	/**
	 * Return and remove the element from the top of the queue
	 * @return element from the top of the queue
	 * @throws RuntimeException if the queue is emepty
	 */
	@Override
	public E dequeue() {
		//If the queue is empty throw exception
		if (this.array[this.head] == null)
			throw new RuntimeException("Empty is Queue!");
		
		//Store the element from the top of the queue for later use (to return this element)
		E node = this.array[this.head];
		
		//Remove the element from the queue
		this.array[this.head] = null;
		
		//the index of new element which of top of queue, in other words, prepare for the next dequeue
		this.head++;
		
		//if the head is end of the queue, start from the index 0 again
		this.head = this.head % this.array.length;
		
		//update the size of the queue
		this.qSize--;
		
		//return the element which was at the top of the queue
		return node;
	}

	/**
	 * Return the element from the top of the queue, but do not delete the element
	 * @return the element on the top of the queue4
	 * @throws RuntimeException if the queue is emepty
	 */
	@Override
	public E peek() {
		
		//throw if the queue is empty
		if (this.array[this.head] == null)
			throw new RuntimeException("Empty is Queue!");

		//Return the element from the top of the queue
		return this.array[this.head];
	}
	
	/**
	 * Returnt the current size of this queue, the size will be between 0 and queue.length
	 */
	public int getSize() {
		return this.qSize;
	}

}
