package customstack;

public interface CustomStack<E> {
	public E pop();
	
	public boolean push(E element);
	
	public boolean isEmpty();
	
	public void empty();
	
}
