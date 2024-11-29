package com.test04.queue;

public class IntQueue {
	private int[] q; 		//큐, 데이터 저장
	private int capacity; 	//큐의 크기, 저장 할 수 있는 최대 수, 용량
	private int num;		//현재 데이터 개수
	private int front;		//맨 처음
	private int rear;		//맨 마지막
	
	public IntQueue(int max) {
		num = front = rear = 0;
		capacity = max;
		
		try {
			q = new int[capacity];
		} catch (Exception e) {
			capacity = 0;
		}
	}
	
	//큐에 데이터 삽입 - 인큐
	public int enqueue(int no) { 
		if(num >= capacity) { 
			System.out.println("[큐가 가득 찼다.]");
		}
		q[rear++] = no;
		num++;
		if(rear == capacity) {
			rear = 0;
		}
		
		return no;
	}
	
	//큐에서 데이터 추출 -  디큐
	public int dequeue() throws Exception{
		if(num <= 0) {
			System.out.println("[큐가 비었다]");
			throw new Exception();
		}
		int val = q[front++];
		num--;
		if(front==capacity) {
			front = 0;
		}
		
		return val;
	}
	
	//맨 앞의 데이터 확인
	public int peek() throws Exception {
		if(num<=0) {
			System.out.println("[큐가 비었다.]");
			throw new Exception();
		}
		return q[front];
	}
	
	//큐를 비움
	public void clear() {
		num=front=rear=0;
	}
	
	//큐의 크기 확인
	public int getCapacity() {
		return capacity;
	}
	
	//큐에 저장된 데이터 수 확인
	public int size() {
		return num;
	}
	
	//비었는지 확인
	public boolean isEmpty() {
		return num<=0;
	}
	//가득찼는지 확인
	public boolean isFull() {
		return num>=capacity;
	}
	
	//큐의 모든 데이터를 front->rear 순으로 출력
	public void dump() {
		if(num <= 0) {
			System.out.println("[큐가 비었다]");
		}else {
			for(int i=0; i<num; i++) {
				System.out.print(q[(i+front)%capacity]+" ");
			}
			System.out.println();
		}
	}
}
