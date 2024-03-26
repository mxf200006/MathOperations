package linkedlist;

public class LinkedListL<E> implements CustomLinkedList<E> {
	private int size;
	private Node head;

	public LinkedListL() {
		this.size = 0;
		this.head = null;
	}

	/**
	 * Add a new element to this list. The new element will be added at the
	 * beggining of the list. Adding new item will cost O(1)
	 * 
	 * @return true if the new item was added successfully, false otherwise.
	 * @throws ClassCastException if the type of new item is not the same specified
	 *                            for this list.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(Object object) {
		Node<E> node;
		Node<E> temp;
		try {
			node = new Node<E>((E) object);
			if (this.head == null)
				this.head = node;
			else {
				temp = this.head;
				this.head = node;
				this.head.next = temp;
			}
		} catch (ClassCastException c) {
			throw new ClassCastException("Wrong data type for this list!");
		}
		this.size++;
		return true;
	}

	/**
	 * Return a specified item from this list, if it exists, or null if the specific
	 * item is not found.
	 * 
	 * @return a item with is equal to type argument. The type is specified with
	 *         Object.equal().
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E get(Object object) {
		
		Node<E> node = this.head;
		E item = (E) node.element;
		try {	
			do {
				if (item.equals((E) object))
					return item;
				else
					node = node.next;
			} while (node.next != null);

		} catch (ClassCastException c) {
			throw new ClassCastException("Wrong data type for this list!");
		}
		
		//Not found
		return null;
	}

	@Override
	public int getSize() {

		return this.size;
	}

	private class Node<T> {
		private T element;
		private Node next;

		public Node(T node) {
			this.element = node;
			this.next = null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object object) {
		
		return true;
	}

	@Override
	public E peak(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}
