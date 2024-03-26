package main;
import customqueue.CustomQueue;
import customqueue.QueueTypeL; 
public class Test1 {

		public static void main(String[] args) {
		
		CustomQueue<String> cc = new QueueTypeL<>();
		cc.enqueue("A");
		cc.enqueue("B");
		cc.enqueue("c");
		cc.enqueue("d");
		cc.enqueue("e");
		
		cc.enqueue("Fahim");
		System.out.println(cc.dequeue());
		System.out.println(cc.dequeue());
		System.out.println(cc.dequeue());
		System.out.println(cc.dequeue());
		System.out.println(cc.dequeue());
		System.out.println(cc.dequeue());
		
		System.out.println();
		
		
		
		
		
		
	
		
	}
}
