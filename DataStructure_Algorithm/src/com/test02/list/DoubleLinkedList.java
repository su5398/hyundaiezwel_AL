package com.test02.list;

import java.util.Comparator;

public class DoubleLinkedList<E> {
	
	class Node<E>{
		private E data;
		private Node<E> prev;
		private Node<E> next;
		
		//생성자
		Node(){
			data = null;
			prev = next = this;
		}
		Node(E obj, Node<E> prev, Node<E> next){ 
			data = obj;
			this.prev = prev;
			this.next = next;
		}
		
	}
	
	//DoubleLinkedList 클래스의 필드
	private Node<E> head;
	private Node<E> crnt;
	
	public DoubleLinkedList() {
		head = crnt = new Node<E>();//더미노드
	}
	
	//리스트가 비어있는지 확인
	public boolean isEmpty(){
		return head.next == head;
	}
	
	//검색
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head.next;
		//현재 비교를 하는 중인 노드
		
		while(ptr != head) {
			if(c.compare(obj, ptr.data) == 0) {
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		
		return null;
	}
	
	//crnt가 가르키는 노드 확인
	public void printCrntNode() {
		if(isEmpty()) {
			System.out.println("노드가 없습니다.");
		}else {
			System.out.println(crnt.data);
		}
	}
	
	//리스트에 전체 노드 확인
	public void dump() {
		Node<E> ptr = head.next;//더미 노드 다음 노드
		
		while(ptr != head) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
	//crnt를 하나 앞으로
	public boolean prev() {
		if(isEmpty()) {
			return false;
		}
		if(crnt.prev == head) {
			crnt = head.prev;
		}else {
			crnt = crnt.prev;
		}
		
		return true;
	}
	//crnt를 하나 뒤로
	public boolean next() {
		if(isEmpty()) {
			return false;
		}
		if(crnt.next == head) {
			crnt = head.next;
		}else {
			crnt = crnt.next;
		}
		
		return true;
	}
	
	//노드 추가
	public void add(E obj) {
		Node<E> node = new Node<E>(obj, crnt, crnt.next);
		crnt.next = crnt.next.prev = node;
		crnt = node;
	}
	
	//제일 앞에 노드 추가
	public void addFirst(E obj) {
		crnt = head;
		add(obj);
	}
	//제일 뒤에 노드 추가
	public void addLast(E obj) {
		crnt = head.prev; //마지막 노드를 선택, 바로 뒤에 추가
		add(obj);
	}
	
	//노드 삭제
	public void removeCrnt() {
		if(!isEmpty()) {
			crnt.prev.next = crnt.next;
			crnt.next.prev = crnt.prev;
			crnt = crnt.prev;
			if(crnt == head) {
				crnt = head.next;
			}
		}
	}
	
	public void removeFirst() {
		crnt = head.next;
		//crnt가 가르키는 노드를 삭제할 거라 crnt를 첫번째 노드를 가르키게끔 변경
		
		removeCrnt();
	}
	public void removeLast() {
		crnt = head.prev;
		removeCrnt();
	}
	
	//전체삭제
	public void clear() {
		while(!isEmpty()) {
			removeFirst();
		}
	}
}

