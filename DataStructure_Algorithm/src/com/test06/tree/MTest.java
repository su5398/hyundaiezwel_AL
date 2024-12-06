package com.test06.tree;

public class MTest {

	public static void main(String[] args) {
		BinarySearchTree<Integer, Data> tree = new BinarySearchTree<>();
		
		tree.add(1, new Data(1,"lcj"));
		tree.add(10, new Data(10,"jsd"));
		tree.add(5, new Data(5,"kjs"));
		tree.add(12, new Data(12,"hhh"));
		tree.add(13, new Data(13,"pcj"));
		
		tree.print();
		
		System.out.println("search: "+tree.search(20));
		
		tree.remove(10);
		tree.print();
	}

}

class Data{
	private Integer no;
	private String name;
	public Data(Integer no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	
	Integer keyCode() {
		return no;
	}
	public String toString() {
		return name;
	}
}
