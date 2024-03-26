package customstack;

/**
 * Create a Linked List based stack.
 * 
 * @author 87fahim
 *
 * @param <E>
 */
public class StackTypeL<E> implements CustomStack<E> {
	private int size;
	private Node<E> top;

	public StackTypeL() {
		this.size = -1;
		this.top = null;
	}

	@Override
	public E pop() {
		if (this.top == null)
			throw new RuntimeException("Stack is empty!");

		Node<E> node = this.top;
		this.top = this.top.pervious;
		this.size--;

		return node.element;
	}

	@Override
	public boolean push(Object element) {
		try {
			E e = (E) element;
			Node<E> node = this.top;
			this.top = new Node<E>(e);
			this.top.pervious = node;

			this.size++;
			return true;
		} catch (ClassCastException c) {
			
			throw new ClassCastException("Cannot cast to " + this.toString());
		}
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size < 0;
	}

	@Override
	public void empty() {
		this.top = null;
		this.size = -1;

	}

	public String toString() {
		return "StackTypeL";
		
	}
	private class Node<K> {
		Node<K> pervious;
		K element;

		Node(K element) {
			this.element = (K) element;
			this.pervious = null;
		}

	}

}
