package linkedlist;

public interface CustomLinkedList<E> {
	public boolean add(Object object);
	public boolean remove(Object object);
	public E get(Object object);
	public E peak(Object object);
	public int getSize();
}
