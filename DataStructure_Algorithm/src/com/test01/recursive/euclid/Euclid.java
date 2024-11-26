package com.test01.recursive.euclid;

public class Euclid {
	//두 정수의 최대공약수 구하기
	
	public static void main(String[] args) {
		Euclid e = new Euclid();
		
		int gcd = e.euclid(22, 11);
		
		System.out.println("최대공약수: "+gcd);
		
	}
	
	
	public int euclid(int no1, int no2) {
		if(no2==0) {
			return no1;
		}else {
			return euclid(no2, no1%no2);
		}
	}
}
