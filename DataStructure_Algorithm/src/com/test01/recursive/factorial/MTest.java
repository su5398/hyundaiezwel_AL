package com.test01.recursive.factorial;

import java.util.Scanner;

public class MTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Factorial f = new Factorial();
		
		System.out.print("no: ");
		int no = sc.nextInt();
		
		System.out.println(no+"의 팩토리얼: "+f.fac(no));
		
	}

}
