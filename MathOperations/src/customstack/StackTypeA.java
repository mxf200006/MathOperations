package customstack;

public class StackTypeA<E> implements CustomStack<E> {
	
	private int currentIndex;
	private E[] array;
	
	@SuppressWarnings("unchecked")
	public StackTypeA() {
		this.currentIndex = -1;
		this.array = (E[]) new Object[1000];
	}

	public StackTypeA(int currentIndex, E[] array) {
		super();
		this.currentIndex = currentIndex;
		this.array = array;
	}


	@Override
	public E pop() {
		//Get ready for the next push operation
		this.currentIndex--;
		
		//Stack is empty
		if(this.currentIndex < 0)
			throw new RuntimeException("Stack is empty!");
		
		//Store the top element so later it will be  returned
		E temp = this.array[this.currentIndex];
		
		//Remove the top element form the stack
		this.array[this.currentIndex] = null;
		
		
		//return the element that was in top of the stack
		return temp;
	}

	
	@Override
	public boolean push(Object element) {
		@SuppressWarnings("unchecked")
		E node = (E)element;
		
		this.currentIndex++;
		
		//Stack is full and the element is not added
		if(this.currentIndex > 4)
			return false;
	
		//Add element to the stack;
		this.array[this.currentIndex] = node;
		
		//Element was successfully added
		return true;
	}

	@Override
	public boolean isEmpty() {
		return this.currentIndex < 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void empty() {
		this.array = (E[]) new Object[this.array.length];
	}


}
