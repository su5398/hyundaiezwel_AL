package com.test06.tree;

import java.util.Comparator;

public class BinarySearchTree<K,V> {
	//노드
	class Node<K,V>{
		private K key;			//키값
		private V data;			//데이터
		private Node<K,V> left;	//왼쪽 자식노드
		private Node<K,V> right;//오른쪽 자식노드
		
		//생성자
		Node(K key, V data, Node<K,V> left, Node<K,V> right){
			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		K getKey() {
			return key;
		}
		V getValue() {
			return data;
		}
		
		void print() {
			System.out.println(data);
		}
	}
	
	private Node<K,V> root;
	private Comparator<?super K> comparator = null; //키값의 대소 관계를 판단
	
	//생성자
	public BinarySearchTree() {
		root = null;
	}
	
	public BinarySearchTree(Comparator<? super K> c) {
		this();
		comparator = c;
	}
	
	//키값들을 비교
	private int comp(K key1, K key2) {
		return (comparator==null) ? ((Comparable<K>)key1).compareTo(key2) : comparator.compare(key1, key2);
		//key1>key2 ==> 양수
		//key1<key2 ==> 음수
		//key1==key2 ==> 0
	}
	
	//키로 검색
	public V search(K key) {
		Node<K,V> n = root;
		
		while(true) {
			if(n == null) {
				return null;
			}
			
			int cond = comp(key, n.getKey()); //검색하려는 key와 n의 key를 비교
			if(cond == 0) {
				return n.getValue();
			}else if(cond<0) {
				n = n.left;
			}else {
				n = n.right;
			}
		}
	}
	
	//추가 노드 삽입
	public void add(K key, V data) {
		if(root==null) {
			root = new Node<K,V>(key,data,null,null);
		}else {
			addNode(root,key,data);
		}
	}
	
	private void addNode(Node<K,V> node, K key, V data) {
		int cond =comp(key, node.getKey()); //삽입할 key와 선택노드의 키를 비교
		
		if(cond==0) {
			return; //해당 키가 이미 존재하므로 추가하는 작업 종료
		}else if(cond<0) {	//삽입하려는 key가 작다!
			if(node.left == null) {	//선택노드의 왼쪽이 비어있다!!
				node.left = new Node<K,V>(key,data,null,null);
			}else {
				addNode(node.left,key,data);
			}
		}else {
			if(node.right == null) {	//선택노드의 왼쪽이 비어있다!!
				node.right = new Node<K,V>(key,data,null,null);
			}else {
				addNode(node.right,key,data);
			}
		}
	}
	
	//노드 삭제
	public boolean remove(K key) {
		Node<K,V> p = root;
		Node<K,V> parent = null;
		boolean isLeftChild = true; //p가 parent의 왼쪽 자식 노드인지
		
		//삭제할 키를 가지고 노드를 찾는다.
		//찾았다면 p는 찾은노드(삭제하려는 노드), parent는 찾는 노드의 부모
		while(true) {
			if(p==null) {return false;}
			
			int cond = comp(key,p.getKey());
			if(cond == 0) {
				break;
			}else {
				parent = p;
				if(cond<0) {
					isLeftChild = true;
					p = p.left;
				}else {
					isLeftChild = false;
					p = p.right;
				}
			}
		}
		
		//삭제진행
		//자식노드 0개, 자식노드1개
		if(p.left == null) {
			if(p==root) {
				root=p.right;
			}else if(isLeftChild) {
				parent.left = p.right;
			}else {
				parent.right = p.right;
			}
			
		}else if(p.right == null) {
			if(p==root) {
				root=p.left;
			}else if(isLeftChild) {
				parent.left = p.left;
			}else {
				parent.right = p.left;
			}
		}else {
			//자식 노드가 2개일때
			
			parent = p;
			Node<K,V> left = p.left;
			isLeftChild = true;
			
			while(left.right!=null) {
				parent = left;
				left = left.right;
				isLeftChild = false;
			}
			//left => 왼쪽 서브트리 중 가장 큰 노드, parent = left의 부모
			//왼쪽 서브트리 중 가장 큰 노드를 삭제 할 노드에다 덮어 씌운다 
			p.key = left.key;
			p.data = left.data;
			
			if(isLeftChild) {
				parent.left = left.left;
			}else {
				parent.right = left.left;
			}
		}
		
		return true;
	}
	
	public void print() {
		printTree(root);
	}
	private void printTree(Node node) {
		if(node != null) {
			printTree(node.left);
			System.out.println(node.key+":"+node.data);
			printTree(node.right);
		}
	}
	
}
