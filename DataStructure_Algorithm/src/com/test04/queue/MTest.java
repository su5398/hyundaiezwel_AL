package com.test04.queue;

public class MTest {

	public static void main(String[] args) throws Exception{
		IntQueue q = new IntQueue(8);
		
		q.enqueue(11);
		q.enqueue(22);
		q.dump();
		q.enqueue(32);
		q.enqueue(42);
		q.dump();
		
		System.out.println("dequeue: " + q.dequeue());
		q.dump();
		System.out.println("dequeue: " + q.dequeue());
		q.dump();
		
		q.enqueue(52);
		q.dump();
	}

}
