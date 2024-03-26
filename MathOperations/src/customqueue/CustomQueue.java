package customqueue;

public interface CustomQueue<E> {
	public boolean enqueue(Object object);
	public E dequeue();
	public E peek();
	public int getSize();	
}
