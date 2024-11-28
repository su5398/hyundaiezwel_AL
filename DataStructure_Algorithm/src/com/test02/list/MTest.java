package com.test02.list;

import java.util.Comparator;

public class MTest {

	public static void main(String[] args) {
		DoubleLinkedList<Data> list = new DoubleLinkedList<>();
		
		list.addFirst(new Data(1, "aaa"));
		list.addLast(new Data(3, "bb"));
		list.addFirst(new Data(17, "FFF"));
		list.addLast(new Data(22, "EeE"));
		
		list.dump();
		
		System.out.println();
		list.removeFirst();
		//list.removeLast();
		list.dump();
		
		System.out.println();
		System.out.println(list.search(new Data(0,"dddd"), new NameOrderComparator()));
		System.out.println(list.search(new Data(0,"dd"), new NameOrderComparator()));
		
		System.out.println(list.search(new Data(3,null), new NameOrderComparator()));
		System.out.println(list.search(new Data(13,null), new NameOrderComparator()));
		
		System.out.println();
		list.dump();
		System.out.println("--------");
		list.printCrntNode();
		list.prev();
		list.prev();
		list.printCrntNode();
		
		list.next();
		list.printCrntNode();
		
		list.next();
		list.printCrntNode();
		list.next();
		list.printCrntNode();
		
	}

}

class NoOrderComparator implements Comparator<Data>{
	public int compare(Data d1, Data d2) {
		return (d1.getNo() > d2.getNo()) ? 1 : (d1.getNo() < d2.getNo()) ? -1 : 0;
	}
}

class NameOrderComparator implements Comparator<Data>{
	public int compare(Data d1, Data d2) {
		return (d1.getName().compareTo(d2.getName()));
	}
}

class Data{
	private int no;
	private String name;
	public Data() {}
	public Data(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "[" + no + "]" + name;
	}
	
	
}