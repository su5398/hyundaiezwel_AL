package com.test02.list;

public class MTest {

	public static void main(String[] args) {
		DoubleLinkedList<Data> list = new DoubleLinkedList<>();
		
		list.addFirst(new Data(1, "aaa"));
		list.addLast(new Data(3, "bb"));
		list.addFirst(new Data(17, "FFF"));
		list.addLast(new Data(22, "EeE"));
		
		list.dump();
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