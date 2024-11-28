package com.test03.stack;

public class MTest {

	public static void main(String[] args) throws Exception{
		IntStack s = new IntStack(16);
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		
		System.out.println("peek: " + s.peek());
		
		System.out.println("pop: " + s.pop());
		s.dump();
		System.out.println("peek: " + s.peek());
		
		s.clear();
		System.out.println("isEmpty: "+s.isEmpty());
		//s.pop();
		
		s.push(11);
		s.dump();
	}

}
