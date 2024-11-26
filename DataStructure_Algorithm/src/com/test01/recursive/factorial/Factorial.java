package com.test01.recursive.factorial;

public class Factorial {
	//정수의 팩토리얼값 구하기
	//n! = n * (n-1)!
	public int fac(int no) {
		if(no>0) {
			return no*fac(no-1);
		}else {
			return 1;
		}
	}
}
