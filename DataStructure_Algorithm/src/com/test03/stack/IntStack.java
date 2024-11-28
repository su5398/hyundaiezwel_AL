package com.test03.stack;

public class IntStack {
	private int[] s;		//데이터 저장용 스택 배열
	private int capacity;	//스택의 용량
	private int ptr;		//포인터, 스택에 저장된 데이터 수
	
	//생성자
	public IntStack(int max) {
		ptr = 0;
		capacity = max;
		
		try {
			s = new int[capacity];
		} catch (Exception e) {
			capacity = 0;
		}
	}
	
	//push : 데이터 삽입
	public int push(int no) throws Exception{
		if(ptr>=capacity) {
			System.out.println("[스택이 가득 찼다]");
			throw new Exception();
		}
		return s[ptr++]=no; //s[ptr]에 저장 후 ptr 1 증가
	}
	//pop  : 데이터 추출
	public int pop() throws Exception{
		if(ptr <= 0) {
			System.out.println("[스택이 비었다]");
			throw new Exception();
		}
		return s[--ptr];
	}
	
	//스택의 정상에 있는 데이터 확인
	public int peek() throws Exception{
		if(ptr <= 0) {
			System.out.println("[스택이 비었다]");
			throw new Exception();
		}
		return s[ptr-1];
	}
	
	//스택을 비우기
	public void clear() {
		ptr = 0;
	}
	
	public int size() {
		return ptr;
	}
	
	public boolean isEmpty() {
		return ptr<=0;
	}
	public boolean isFull() {
		return ptr>=capacity;
	}
	
	//스택의 모든 데이터를 바닥 -> 피크 순서로 확인
	public void dump() {
		if(isEmpty()) {
			System.out.println("스택이 비었다");
		}else {
			for(int i=0; i<ptr; i++) {
				System.out.println(s[i] + " ");
			}
			System.out.println();
		}
	}
	
	//스택에서 no를 찾아 인덱스 리턴
	public int indexOf(int no) {
		for(int i=0; i<ptr; i++) {
			if(s[i] == no) {
				return i; //검색 성공
			}
		}
		return -1; //검색 실패
	}
}
